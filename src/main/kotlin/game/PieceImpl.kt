package game

import game.framework.Piece
import game.framework.PieceType
import game.framework.Player

/**
 * @author nathan
 * Created on 10/9/16.
 */
class PieceImpl(override var type: PieceType, override var owner: Player) : Piece {

}