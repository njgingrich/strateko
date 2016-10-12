package game

import game.framework.*
import game.strategy.GameMap

/**
 * @author nathan
 * Created on 10/9/16.
 */
class GameImpl(map: GameMap) : Game {
    private var turn = 1
    private var currentPlayer = Player.RED

    private val map: GameMap

    init {
        this.map = map
    }

    override fun getTileAt(p: Position): Tile {
        return map.board[p] ?: TileImpl(TileType.GRASS)
    }

    override fun getPieceAt(p: Position): Piece? {
        return map.pieces[p]
    }

    override fun getWinner(): Player? {
        if (hasNoFlag(Player.RED)) return Player.BLUE
        else if (hasNoFlag(Player.BLUE)) return Player.RED
        else return null
    }

    private fun hasNoFlag(p: Player): Boolean {
        if (map.pieces.filterValues {
            it.type == PieceType.FLAG && it.owner == p
            }.isEmpty()) {
            return true
        } else {
            return false
        }
    }

    override fun getPlayerInTurn(): Player {
        return currentPlayer
    }

    override fun getTurn(): Int {
        return turn
    }

    override fun movePiece(from: Position, to: Position): Boolean {
        val p = getPieceAt(from) ?: return false
        if (isImmobilePiece(p)) return false

        if (getPlayerInTurn() != p.owner) return false
        if (getTileAt(to).type == TileType.WATER) return false
        if (p.type != PieceType.SCOUT) {
            if(moveLongerThanOneTile(from, to)) return false
        }

        if (Math.abs(from.col - to.col) > 0 &&
            Math.abs(from.row - to.row) > 0) return false

        // battle
        val toPiece = getPieceAt(to)
        if (toPiece != null) {
            val winner = battle(p, toPiece)
            map.pieces[from]?.let {
                map.pieces.put(to, winner)
                map.pieces.remove(from)
                endPlayerTurn()
                return true
            }
        } else {
            map.pieces[from]?.let {
                map.pieces.put(to, p)
                map.pieces.remove(from)
                endPlayerTurn()
                return true
            }
        }

        return false
    }

    private fun battle(attacker: Piece, defender: Piece): Piece {
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

    override fun endPlayerTurn() {
        val p = getPlayerInTurn()
        if (getWinner() != null) {
            endGame(p)

        // Game isn't over
        } else if (p == Player.BLUE) {
            currentPlayer = Player.RED
            turn += 1
        } else {
            currentPlayer = Player.BLUE
        }
    }

    override fun endGame(p: Player) {
        //throw NotImplementedError("Not implemented.")
    }

}