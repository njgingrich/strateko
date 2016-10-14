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
        val redPiece by cssclass()
        val bluePiece by cssclass()

        /*val redBomb by cssclass()
        val redMarshal by cssclass()
        val redGeneral by cssclass()
        val redColonel by cssclass()*/

        val redColor= c("#FF0000")
        val blueColor= c("#0000FF")
    }

    init {
        button {
            add(redPiece) {
                backgroundColor += redColor
                //graphic = ("/ui/img/red/flag.png")
                graphic = URI("/ui/img/red/blank.png")
            }
            add(bluePiece) {
                backgroundColor += blueColor
                graphic = URI("/ui/img/blue/blank.png")
            }
        }
    }
}