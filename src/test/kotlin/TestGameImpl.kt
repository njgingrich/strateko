import framework.PieceType
import framework.Player
import framework.Position
import framework.TileType
import io.kotlintest.specs.StringSpec

/**
 * @author nathan
 * Created on 10/9/16.
 */
class TestGameImpl : StringSpec() {
    private var game: GameImpl = GameImpl(TestGameMap())

    override fun beforeEach() {
        game = GameImpl(TestGameMap())
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
                game.getTileAt(Position(row, col)).type shouldBe TileType.WATER
            }
        }
        "All normal pieces can move one square at a time" {
            for(col in 0..9) {
                game.movePiece(Position(9, col), Position(9, col-1)) shouldBe true
                game.endPlayerTurn()
            }
        }
        "The flag and bomb cannot move" {
            game.movePiece(Position(0, 0), Position(1, 0)) shouldBe false
            game.movePiece(Position(0, 1), Position(1, 1)) shouldBe false
        }
        "The scout can move multiple squares" {
            game.movePiece(Position(9, 8), Position(0, 8)) shouldBe true
            game.endPlayerTurn()
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
            game.endPlayerTurn()
            game.movePiece(Position(0, 8), Position(0, 2)) shouldBe true
            game.getPieceAt(Position(0, 2))?.type shouldBe PieceType.GENERAL
        }
        "A bomb beats all other pieces but the miner" {
            for(col in 0..9) {
                if (col == 7) {
                    game.movePiece(Position(9, col), Position(8, col)) shouldBe true
                    game.getPieceAt(Position(8, col))?.type shouldBe PieceType.MINER
                    game.endPlayerTurn()
                } else {
                    game.movePiece(Position(9, col), Position(8, col)) shouldBe true
                    game.getPieceAt(Position(8, col))?.type shouldBe PieceType.BOMB
                    game.endPlayerTurn()
                }
            }
        }
        "The spy beats the marshal if the spy attacks" {
            game.endPlayerTurn()
            game.movePiece(Position(3, 4), Position(3, 3))
            game.getPieceAt(Position(3, 3))?.type shouldBe PieceType.SPY
        }
        "After red and blue each take their turn three times, the turn should be 4" {
            game.endPlayerTurn()
            game.endPlayerTurn()
            game.endPlayerTurn()
            game.endPlayerTurn()
            game.endPlayerTurn()
            game.endPlayerTurn()
            game.getTurn() shouldBe 4
        }
        "After blue captures red's flag, blue wins" {
            game.endPlayerTurn()
            game.movePiece(Position(0,2), Position(0,3))
            game.endPlayerTurn()
            game.movePiece(Position(0,3), Position(0,4))
            game.getWinner() shouldBe Player.BLUE
        }
        "After red captures blue's flag, red wins" {
            game.movePiece(Position(9,8), Position(1,8))
            game.endPlayerTurn()
            game.movePiece(Position(1,8), Position(1,1))
            game.endPlayerTurn()
            game.movePiece(Position(1,1), Position(0,1))
            game.getWinner() shouldBe Player.RED
        }

        "Red cannot move blue's pieces and vice versa" {
            game.movePiece(Position(0,2), Position(1,2)) shouldBe false
            game.movePiece(Position(9,0), Position(8,1)) shouldBe false
        }
    }
}