import kotlin.collections.MutableMap

/**
 * @author nathan
 * Created on 10/9/16.
 */
class GameImpl : Game {
    var units: MutableMap<Position, PieceImpl>

    init {
        units = mutableMapOf(
                Pair(Position(0,0), PieceImpl(PieceType.BOMB, Player.RED))
        )
    }

    override fun getTileAt(p: Position): Tile {
        throw UnsupportedOperationException("not implemented")
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