package game.strategy

import game.framework.Piece
import game.framework.Position
import game.framework.Tile

/**
 * @author nathan
 * Created on 10/11/16.
 */
interface GameMap {
    val board: MutableMap<Position, Tile>
    val pieces: MutableMap<Position, Piece>
}