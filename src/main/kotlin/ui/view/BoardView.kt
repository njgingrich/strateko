package ui.view

import game.PieceImpl
import game.framework.PieceType
import game.framework.Player
import javafx.scene.control.Button
import javafx.scene.control.SplitPane
import javafx.scene.layout.GridPane
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
    val graphic = resources.url("/ui/img/red/flag.png")
    //val bp = BoardPiece(PieceImpl(PieceType.FLAG, Player.RED), graphic)

    init {
        restartButton.text = "Restart"
        for (row in 0..9) {
            for (col in 0..9) {
                //board.add(Button("$row,$col"), row, col)
                val bp = BoardPiece(PieceImpl(PieceType.FLAG, Player.RED), graphic)
                bp.addClass(Styles.redPiece)
                board.add(bp, row, col)
            }
        }
    }
}