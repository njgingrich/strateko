package framework

/**
 * @author nathan
 * Created on 10/9/16.
 */
interface Game {
    /**
     *
     */
    fun getTileAt(p: Position): Tile?

    fun getPieceAt(p: Position): Piece?

    fun getWinner(): String?

    fun getPlayerInTurn(): Player

    fun getTurn(): Int

    fun movePiece(from: Position, to: Position): Boolean

    fun endTurn()

}