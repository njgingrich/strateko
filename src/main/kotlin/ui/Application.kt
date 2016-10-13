package ui

import tornadofx.App
import tornadofx.reloadStylesheetsOnFocus
import ui.view.BoardView

/**
 * @author nathan.gingrich
 * Created Oct 12, 2016.
 */
class Application : App(BoardView::class, Styles::class) {
    init {
        reloadStylesheetsOnFocus()
    }
}