import kotlin.collections.MutableMap

/**
 * @author nathan
 * Created on 10/9/16.
 */
class GameImpl : Game {
    var units: MutableMap<Position, PieceImpl>
    var board: Map<Position, TileImpl>

    init {
        units = mutableMapOf(
            Pair(Position(0, 0), PieceImpl(PieceType.BOMB, Player.RED)),
            Pair(Position(9, 9), PieceImpl(PieceType.SCOUT, Player.RED))
        )
        board = mutableMapOf(
            Pair(Position(4, 2), TileImpl("water")),
            Pair(Position(4, 3), TileImpl("water")),
            Pair(Position(5, 2), TileImpl("water")),
            Pair(Position(5, 3), TileImpl("water"))
        )
    }

    override fun getTileAt(p: Position): Tile? {
        return board.get(p)
    }

    override fun getPieceAt(p: Position): Piece? {
        return units.get(p)
    }

    override fun getWinner(): String? {
        return null
    }

    override fun getPlayerInTurn(): Player {
        return Player.RED
    }

    override fun getTurn(): Int {
        return 1
    }

    override fun moveUnit(from: Position, to: Position) {
        throw UnsupportedOperationException("not implemented")
    }

    override fun endTurn() {
        throw UnsupportedOperationException("not implemented")
    }

}