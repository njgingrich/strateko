package ui

import tornadofx.Stylesheet
import tornadofx.c
import tornadofx.cssclass
import java.net.URI

/**
 * @author nathan.gingrich
 * Created Oct 13, 2016.
 */
class Styles : Stylesheet() {
    companion object {
        val img by cssclass()
        val redPiece by cssclass()
        val bluePiece by cssclass()

        val redColor= c("#FF0000")
        val blueColor= c("#0000FF")
    }

    init {
        button {
            add(redPiece) {
                backgroundColor += redColor
                //graphic = ("/ui/img/red/flag.png")
                graphic = URI("/ui/img/red/flag.png")
            }
            add(bluePiece) {
                backgroundColor += blueColor
            }
        }
    }
}