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
            Pair(Position(0, 0), PieceImpl(PieceType.BOMB, Player.BLUE)),
            Pair(Position(9, 0), PieceImpl(PieceType.MARSHAL, Player.RED)),
            Pair(Position(9, 1), PieceImpl(PieceType.GENERAL, Player.RED)),
            Pair(Position(9, 2), PieceImpl(PieceType.COLONEL, Player.RED)),
            Pair(Position(9, 3), PieceImpl(PieceType.MAJOR, Player.RED)),
            Pair(Position(9, 4), PieceImpl(PieceType.CAPTAIN, Player.RED)),
            Pair(Position(9, 5), PieceImpl(PieceType.LIEUTENANT, Player.RED)),
            Pair(Position(9, 6), PieceImpl(PieceType.SERGEANT, Player.RED)),
            Pair(Position(9, 7), PieceImpl(PieceType.MINER, Player.RED)),
            Pair(Position(9, 8), PieceImpl(PieceType.SCOUT, Player.RED)),
            Pair(Position(9, 9), PieceImpl(PieceType.SPY, Player.RED))
        )
        board = mutableMapOf(
            Pair(Position(4, 2), TileImpl("water")),
            Pair(Position(4, 3), TileImpl("water")),
            Pair(Position(5, 2), TileImpl("water")),
            Pair(Position(5, 3), TileImpl("water")),
            Pair(Position(4, 6), TileImpl("water")),
            Pair(Position(4, 7), TileImpl("water")),
            Pair(Position(5, 6), TileImpl("water")),
            Pair(Position(5, 7), TileImpl("water"))
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

    override fun moveUnit(from: Position, to: Position): Boolean {
        units.get(from)?.let {
            units.put(to, it)
            units.remove(from)
            return true
        }
        return false
    }

    override fun endTurn() {
        throw UnsupportedOperationException("not implemented")
    }

}