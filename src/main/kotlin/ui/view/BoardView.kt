package ui.view

import game.PieceImpl
import game.framework.PieceType
import game.framework.Player
import javafx.scene.control.Button
import javafx.scene.control.SplitPane
import javafx.scene.layout.GridPane
import tornadofx.CssRule
import tornadofx.View
import tornadofx.addClass
import ui.BoardPiece
import ui.Styles

/**
 * @author nathan.gingrich
 * Created Oct 12, 2016.
 */
class BoardView : View() {
    override val root: SplitPane by fxml()
    val restartButton: Button by fxid()
    val board: GridPane by fxid()
    //val graphic = resources.url("/ui/img/red/flag.png")

    init {
        restartButton.text = "Restart"
        for (row in 0..9) {
            for (col in 0..9) {
                val bp: BoardPiece
                if (row in 0..3) {
                    bp = BoardPiece(PieceImpl(PieceType.BOMB, Player.BLUE))
                    board.add(bp, col, row)
                } else if (row in 6..9) {
                    bp = BoardPiece(PieceImpl(PieceType.FLAG, Player.RED))
                    board.add(bp, col, row)
                }
            }
        }
        setGraphic(PieceType.BOMB)
    }

    private fun setGraphic(type: PieceType): String {
        return type.name.toLowerCase()
    }
}