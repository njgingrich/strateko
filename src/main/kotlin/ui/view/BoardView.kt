package ui.view

import javafx.scene.control.Label
import javafx.scene.layout.BorderPane
import tornadofx.View

/**
 * @author nathan.gingrich
 * Created Oct 12, 2016.
 */
class BoardView : View() {
    override val root: BorderPane by fxml()
    val hello: Label by fxid()

    init {
        hello.text = "Hello World"
    }
}