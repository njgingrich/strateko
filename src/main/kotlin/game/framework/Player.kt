package game.framework

import java.security.InvalidParameterException

/**
 * @author nathan
 * Created on 10/9/16.
 */
enum class Player {
    RED, BLUE;

    fun other(p: Player) = when (p) {
        RED -> BLUE
        BLUE -> RED
        else -> {
            throw InvalidParameterException("Impossible player")
        }
    }
}