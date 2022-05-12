package team.command

import team.pult.ApplePult
import team.pult.IInvoker
import team.tv.AppleTV
import team.tv.IReceiver

class TVOnCommand(
    private val tv: IReceiver
): ICommand {

    private var currentDestination: Destination? = null
    private var currentCode: String = ""
    private val stack = ArrayDeque<Destination>()

    init {
        currentDestination = Destination.LOGIN
        tv.onLoginOpened()
        stack.addFirst(Destination.LOGIN)
    }

    override fun invoke() {
        if (currentCode.isNotEmpty()) {
            when (currentDestination) {
                Destination.LOGIN -> {
                    currentDestination = Destination.LOGIN
                    tv.onLoginOpened()
                }
                Destination.CHANNELS -> {
                    currentDestination = Destination.CHANNELS
                    tv.onChannelsOpened()
                }
                Destination.PLAYER -> {
                    currentDestination = Destination.PLAYER
                    tv.onPlayerOpened()
                }
            }
        } else {
            println("Nothing selected..")
        }
    }

    override fun navigate(code: String) {
        currentCode = code
        when (code.toLowerCase()) {
            "0" -> println("0")
            "1" -> println("1")
            "2" -> println("2")
            "3" -> println("3")
            "4" -> println("4")
            "5" -> println("5")
            "6" -> println("6")
            "7" -> println("7")
            "8" -> println("8")
            "9" -> println("9")
            "up" -> println("Up")
            "down" -> println("Down")
            "left" -> println("Left")
            "right" -> println("Right")
            "oK" -> println("Ok")
            "back" -> println("Back")
            else -> currentCode = ""
        }
    }

    override fun back() {
        currentDestination = stack.removeLastOrNull()
        println("Navigate back..")
    }
}

enum class Destination {
    LOGIN,
    CHANNELS,
    PLAYER
}

fun main() {
    val tv: IReceiver = AppleTV()
    val command = TVOnCommand(tv)
    val pult: IInvoker = ApplePult(command)

    pult.navigate("Up")
    pult.ok()
    pult.back()
}