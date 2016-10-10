import kotlin.collections.MutableMap

/**
 * @author nathan
 * Created on 10/9/16.
 */
class GameImpl : Game {
    var units: MutableMap<Position, Piece>
    var board: Map<Position, Tile>

    init {
        units = mutableMapOf(
            Pair(Position(0, 0), PieceImpl(PieceType.BOMB, Player.BLUE)),
            Pair(Position(0, 1), PieceImpl(PieceType.FLAG, Player.BLUE)),
            Pair(Position(0, 2), PieceImpl(PieceType.GENERAL, Player.BLUE)),
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

    override fun movePiece(from: Position, to: Position): Boolean {
        val p = getPieceAt(from) ?: return false
        if (isImmobilePiece(p)) return false

        if (p.type != PieceType.SCOUT) {
            if(moveLongerThanOneTile(from, to)) return false
        }

        if (Math.abs(from.col - to.col) > 0 &&
            Math.abs(from.row - to.row) > 0) return false

        // battle
        val toPiece = getPieceAt(to)
        if (toPiece != null) {
            val winner = battle(p, toPiece)
            units.get(from)?.let {
                units.put(to, winner)
                units.remove(from)
                return true
            }
        } else {
            units.get(from)?.let {
                units.put(to, p)
                units.remove(from)
                return true
            }
        }

        return false
    }

    private fun battle(attacker: Piece, defender: Piece): Piece {
        System.out.println("attacker: " + attacker)
        System.out.println("defender: " + defender)
        when (defender.type) {
            PieceType.BOMB -> {
                if (attacker.type == PieceType.MINER) {
                    return attacker
                } else {
                    return defender
                }
            }
            PieceType.MARSHAL -> {
                if (attacker.type == PieceType.SPY) {
                    return attacker
                } else {
                    return defender
                }
            }
            else -> {
                if (attacker.type < defender.type) {
                    return attacker
                } else {
                    return defender
                }
            }
        }
    }

    private fun moveLongerThanOneTile(from: Position, to: Position): Boolean {
        if (Math.abs(from.col - to.col) > 1) {
            return true
        } else if (Math.abs(from.row - to.row) > 1) {
            return true
        }
        return false
    }

    private fun isImmobilePiece(p: Piece): Boolean {
        if (p.type == PieceType.BOMB ||
            p.type == PieceType.FLAG) {

            return true
        }

        return false
    }

    override fun endTurn() {
        throw UnsupportedOperationException("not implemented")
    }

}