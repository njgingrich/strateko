package ui

import game.framework.Piece
import game.framework.Player
import javafx.scene.control.Button
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import tornadofx.addClass

/**
 * @author nathan.gingrich
 * Created Oct 13, 2016.
 */
class BoardPiece(p: Piece) : Button() {
    private val baseURI = "/ui/img/"
    private val lowerOwnerName = p.owner.name.toLowerCase()
    private val lowerPieceName = p.type.name.toLowerCase()

    init {
        when (p.owner) {
            Player.BLUE -> {
                addClass(Styles.bluePiece)
            }
            else -> {
                addClass(Styles.redPiece)
            }
        }
        val imageUri = "$baseURI$lowerOwnerName/$lowerPieceName.png"
        System.out.println("class: " + p.owner.name.toLowerCase() + "Piece")
        val image = ImageView()
        graphic = image
        image.imageProperty().set(Image(imageUri))
    }
}