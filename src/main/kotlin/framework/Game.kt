package framework

/**
 * @author nathan
 * Created on 10/9/16.
 */
interface Game {
    /**
     * Get the tile at the given position.
     * Valid tiles are in TileType.kt
     *
     * @param p the position to look at
     * @return The tile at p
     */
    fun getTileAt(p: Position): Tile

    /**
     * Get the piece at the given position.
     *
     * @param p the position to look at
     * @return The piece at p, or null if there is no piece
     */
    fun getPieceAt(p: Position): Piece?

    /**
     * Return the winner of the game if there is one,
     * or null if no player has won yet.
     *
     * @return The winner, or null if there is no winner
     */
    fun getWinner(): Player?

    /**
     * Get the current player whose turn it is.
     *
     * @return The player whose turn it is
     */
    fun getPlayerInTurn(): Player

    /**
     * Get the current game turn. In turn 1, both players
     * go before turn 2 begins, so the number of total moves will
     * be turns * 2
     *
     * @return The current turn of the game
     */
    fun getTurn(): Int

    /**
     * Move a piece from position from to position to. If the move
     * is not possible, the unit will not be moved and false will
     * be returned.
     *
     * @param from The original position of the piece
     * @param to The new position of the piece
     * @return true if the move is possible (after the move is
     * made), or false if the move is impossible
     */
    fun movePiece(from: Position, to: Position): Boolean

    /**
     * End the turn for a player, not the full turn.
     * endPlayerTurn will be called twice for each 'turn'.
     */
    fun endPlayerTurn()

}