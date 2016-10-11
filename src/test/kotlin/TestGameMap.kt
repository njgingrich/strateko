import framework.*
import strategy.map.GameMap

/**
 * @author nathan
 * Created on 10/11/16.
 */
class TestGameMap : GameMap {
    override val pieces: MutableMap<Position, Piece> = mutableMapOf(
        Pair(Position(0, 0), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(0, 1), PieceImpl(PieceType.FLAG, Player.BLUE)),
        Pair(Position(0, 2), PieceImpl(PieceType.GENERAL, Player.BLUE)),
        Pair(Position(0, 4), PieceImpl(PieceType.FLAG, Player.RED)),

        Pair(Position(3, 3), PieceImpl(PieceType.MARSHAL, Player.RED)),
        Pair(Position(3, 4), PieceImpl(PieceType.SPY, Player.BLUE)),

        Pair(Position(8, 0), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 1), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 2), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 3), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 4), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 5), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 6), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 7), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 8), PieceImpl(PieceType.BOMB, Player.BLUE)),
        Pair(Position(8, 9), PieceImpl(PieceType.BOMB, Player.BLUE)),

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
    override val board: MutableMap<Position, Tile> = mutableMapOf(
        Pair(Position(4, 2), TileImpl(TileType.WATER)),
        Pair(Position(4, 3), TileImpl(TileType.WATER)),
        Pair(Position(5, 2), TileImpl(TileType.WATER)),
        Pair(Position(5, 3), TileImpl(TileType.WATER)),
        Pair(Position(4, 6), TileImpl(TileType.WATER)),
        Pair(Position(4, 7), TileImpl(TileType.WATER)),
        Pair(Position(5, 6), TileImpl(TileType.WATER)),
        Pair(Position(5, 7), TileImpl(TileType.WATER))
    )
}

