import io.kotlintest.specs.StringSpec

/**
 * @author nathan
 * Created on 10/9/16.
 */
class TestGameImpl : StringSpec() {
    private var game: GameImpl = GameImpl()

    override fun beforeAll() {
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
        "There should be a scout at (9,9)" {
            game.getPieceAt(Position(9, 9))?.type shouldBe PieceType.SCOUT
        }
        "There should be water tiles at (4,2)->(5,3)" {
            val positionTable = table(
                    headers("x", "y"),
                    row(4, 2),
                    row(4, 3),
                    row(5, 2),
                    row(5, 3)
            )
            forAll(positionTable) { x, y ->
                game.getTileAt(Position(x, y))?.type shouldBe "water"
            }
        }
    }
}