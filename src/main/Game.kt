/**
 * @author nathan
 * Created on 10/9/16.
 */
interface Game {
    fun getTileAt(p: Position)

    fun getUnitAt(p: Position)

    fun getWinner()

    fun getPlayerInTurn()

    fun getTurn()

    fun moveUnit(from: Position, to: Position)

    fun endTurn()

}