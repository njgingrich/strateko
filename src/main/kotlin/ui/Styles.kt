package ui

import javafx.scene.layout.BorderStrokeStyle
import javafx.scene.paint.Color
import javafx.scene.shape.StrokeLineCap
import javafx.scene.shape.StrokeLineJoin
import javafx.scene.shape.StrokeType
import tornadofx.*
import java.net.URI

/**
 * @author nathan.gingrich
 * Created Oct 13, 2016.
 */
class Styles : Stylesheet() {
    companion object {
        val redPiece by cssclass()
        val bluePiece by cssclass()

        val redBomb by cssclass()
        val redMarshal by cssclass()
        val redGeneral by cssclass()
        val redColonel by cssclass()
        val redMajor by cssclass()
        val redCaptain by cssclass()
        val redLieutenant by cssclass()
        val redSergeant by cssclass()
        val redMiner by cssclass()
        val redScout by cssclass()
        val redSpy by cssclass()
        val redFlag by cssclass()
        val blueBomb by cssclass()
        val blueMarshal by cssclass()
        val blueGeneral by cssclass()
        val blueColonel by cssclass()
        val blueMajor by cssclass()
        val blueCaptain by cssclass()
        val blueLieutenant by cssclass()
        val blueSergeant by cssclass()
        val blueMiner by cssclass()
        val blueScout by cssclass()
        val blueSpy by cssclass()
        val blueFlag by cssclass()


        val redColor= c("#FF0000")
        val blueColor= c("#0000FF")
    }
    private val baseURI = "/ui/img/"

    val selected = mixin {
        borderWidth += box(5.px)
        borderColor += box(Color.WHITE)
        borderStyle += BorderStrokeStyle(StrokeType.INSIDE,
                StrokeLineJoin.MITER,
                StrokeLineCap.SQUARE,
                10.0, 0.0, listOf(25.0, 5.0))
    }

    init {
        button {
            add(redPiece) {
                backgroundColor += redColor
                graphic = URI("red/blank.png")
                maxHeight = 36.px
                maxWidth = 36.px
            }
            add(bluePiece) {
                backgroundColor += blueColor
                graphic = URI("${baseURI}blue/blank.png")
                maxHeight = 36.px
                maxWidth = 36.px
            }
            add(redBomb) {
                graphic = URI("${baseURI}red/bomb.png")
                selected {
                    graphic = URI("${baseURI}red/bomb.png")
                }
            }
            add(redMarshal) {
                graphic = URI("${baseURI}red/marshal.png")
            }
            add(redGeneral) {
                graphic = URI("${baseURI}red/general.png")
            }
            add(redColonel) {
                graphic = URI("${baseURI}red/colonel.png")
            }
            add(redMajor) {
                graphic = URI("${baseURI}red/major.png")
            }
            add(redCaptain) {
                graphic = URI("${baseURI}red/captain.png")
            }
            add(redLieutenant) {
                graphic = URI("${baseURI}red/lieutenant.png")
            }
            add(redSergeant) {
                graphic = URI("${baseURI}red/sergeant.png")
            }
            add(redMiner) {
                graphic = URI("${baseURI}red/miner.png")
            }
            add(redScout) {
                graphic = URI("${baseURI}red/scout.png")
            }
            add(redSpy) {
                graphic = URI("${baseURI}red/spy.png")
            }
            add(redFlag) {
                graphic = URI("${baseURI}red/flag.png")
                selected {
                    +selected
                }
            }
            add(blueBomb) {
                graphic = URI("${baseURI}blue/bomb.png")
                +selected
            }
            add(blueMarshal) {
                graphic = URI("${baseURI}blue/marshal.png")
            }
            add(blueGeneral) {
                graphic = URI("${baseURI}blue/general.png")
            }
            add(blueColonel) {
                graphic = URI("${baseURI}blue/colonel.png")
            }
            add(blueMajor) {
                graphic = URI("${baseURI}blue/major.png")
            }
            add(blueCaptain) {
                graphic = URI("${baseURI}blue/captain.png")
            }
            add(blueLieutenant) {
                graphic = URI("${baseURI}blue/lieutenant.png")
            }
            add(blueSergeant) {
                graphic = URI("${baseURI}blue/sergeant.png")
            }
            add(blueMiner) {
                graphic = URI("${baseURI}blue/miner.png")
            }
            add(blueScout) {
                graphic = URI("${baseURI}blue/scout.png")
            }
            add(blueSpy) {
                graphic = URI("${baseURI}blue/spy.png")
            }
            add(blueFlag) {
                graphic = URI("${baseURI}blue/flag.png")
            }
        }
    }
}