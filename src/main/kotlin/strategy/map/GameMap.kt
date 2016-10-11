package strategy.map

import framework.Piece
import framework.Position
import framework.Tile

/**
 * @author nathan
 * Created on 10/11/16.
 */
interface GameMap {
    val board: MutableMap<Position, Tile>
    val pieces: MutableMap<Position, Piece>
}