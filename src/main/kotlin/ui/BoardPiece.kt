package ui

import game.framework.Piece
import game.framework.Player
import javafx.scene.control.Button
import tornadofx.addClass

/**
 * @author nathan.gingrich
 * Created Oct 13, 2016.
 */
class BoardPiece(p: Piece) : Button() {
    private val lowerOwnerName = p.owner.name.toLowerCase()
    private val lowerPieceName = p.type.name.toLowerCase()
    private val cssName = "$lowerOwnerName-$lowerPieceName"

    init {
        when (p.owner) {
            Player.BLUE -> {
                addClass(Styles.bluePiece)
            }
            else -> {
                addClass(Styles.redPiece)
            }
        }
        addClass(cssName)
    }
}