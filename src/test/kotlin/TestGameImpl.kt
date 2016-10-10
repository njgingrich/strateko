import io.kotlintest.specs.StringSpec

/**
 * @author nathan
 * Created on 10/9/16.
 */
class TestGameImpl : StringSpec() {
    private var game: GameImpl = GameImpl()

    override fun beforeEach() {
        game = GameImpl()
    }

    init {
        "There should be no winner at start" {
            game.getWinner() shouldBe null
        }
        "Red player should go first" {
            game.getPlayerInTurn() shouldBe Player.RED
        }
        "First turn should be turn 1" {
            game.getTurn() shouldBe 1
        }
        "There should be a bomb at (0,0)" {
            game.getPieceAt(Position(0, 0))?.type shouldBe PieceType.BOMB
        }
        "There should be a scout at (9,8)" {
            game.getPieceAt(Position(9, 8))?.type shouldBe PieceType.SCOUT
        }
        "There should be water tiles at (4,2)->(5,3) and (4,6)->(5,7)" {
            val positionTable = table(
                headers("row", "col"),
                row(4, 2),
                row(4, 3),
                row(5, 2),
                row(5, 3),
                row(4, 6),
                row(4, 7),
                row(5, 6),
                row(5, 7)
            )
            forAll(positionTable) { row, col ->
                game.getTileAt(Position(row, col))?.type shouldBe TileType.WATER
            }
        }
        "All normal pieces can move one square at a time" {
            val units = table(
                headers("col"),
                row(0), // PieceType.MARSHAL
                row(1), // PieceType.GENERAL
                row(2), // PieceType.COLONEL
                row(3), // PieceType.MAJOR
                row(4), // PieceType.CAPTAIN
                row(5), // PieceType.LIEUTENANT
                row(6), // PieceType.SERGEANT
                row(7), // PieceType.MINER
                row(8), // PieceType.SCOUT
                row(9)  // PieceType.SPY
            )
            forAll(units) { col ->
                game.movePiece(Position(9, col), Position(9, col-1)) shouldBe true
            }
        }
        "The flag and bomb cannot move" {
            game.movePiece(Position(0, 0), Position(1, 0)) shouldBe false
            game.movePiece(Position(0, 1), Position(1, 1)) shouldBe false
        }
        "The scout can move multiple squares" {
            game.movePiece(Position(9, 8), Position(0, 8)) shouldBe true
            game.movePiece(Position(0, 8), Position(8, 8)) shouldBe true
        }
        "Non-scout pieces can only move one square" {
            game.movePiece(Position(9, 7), Position(0, 7)) shouldBe false
            game.movePiece(Position(9, 0), Position(3, 0)) shouldBe false
        }
        "Pieces cannot move diagonally" {
            game.movePiece(Position(9, 9), Position(8, 8)) shouldBe false
        }
        "When a piece moves onto another piece the lower piece is removed" {
            game.movePiece(Position(9, 8), Position(0, 8)) shouldBe true
            game.movePiece(Position(0, 8), Position(0, 2)) shouldBe true
            game.getPieceAt(Position(0,2))?.type shouldBe PieceType.GENERAL
        }
        "A bomb beats all other pieces but the miner" {
            game.units = mutableMapOf(
                Pair(Position(8,0), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,1), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,2), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,3), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,4), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,5), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,6), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,7), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,8), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(8,9), PieceImpl(PieceType.BOMB, Player.BLUE)),
                Pair(Position(9,0), PieceImpl(PieceType.MARSHAL, Player.RED)),
                Pair(Position(9,1), PieceImpl(PieceType.GENERAL, Player.RED)),
                Pair(Position(9,2), PieceImpl(PieceType.COLONEL, Player.RED)),
                Pair(Position(9,3), PieceImpl(PieceType.MAJOR, Player.RED)),
                Pair(Position(9,4), PieceImpl(PieceType.CAPTAIN, Player.RED)),
                Pair(Position(9,5), PieceImpl(PieceType.LIEUTENANT, Player.RED)),
                Pair(Position(9,6), PieceImpl(PieceType.SERGEANT, Player.RED)),
                Pair(Position(9,7), PieceImpl(PieceType.MINER, Player.RED)),
                Pair(Position(9,8), PieceImpl(PieceType.SCOUT, Player.RED)),
                Pair(Position(9,9), PieceImpl(PieceType.SPY, Player.RED))
            )
            for(col in 0..9) {
                if (col == 7) {
                    game.movePiece(Position(9, col), Position(8, col)) shouldBe true
                    game.getPieceAt(Position(8, col))?.type shouldBe PieceType.MINER
                } else {
                    System.out.println(col)
                    game.movePiece(Position(9, col), Position(8, col)) shouldBe true
                    game.getPieceAt(Position(8, col))?.type shouldBe PieceType.BOMB
                }
            }
        }
        "The spy beats the marshal if the spy attacks" {
            game.units = mutableMapOf(
                Pair(Position(0,0), PieceImpl(PieceType.MARSHAL, Player.RED)),
                Pair(Position(0,1), PieceImpl(PieceType.SPY, Player.BLUE))
            )
            game.movePiece(Position(0,1), Position(0,0))
            game.getPieceAt(Position(0,0))?.type shouldBe PieceType.SPY
        }
    }
}