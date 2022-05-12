package team.pult

import team.command.ICommand

class ApplePult(
    private val command: ICommand
): IInvoker {

    override fun navigate(code: String) {
        command.navigate(code)
        println("${javaClass.simpleName} - ${javaClass.methods[0]}")
    }

    override fun ok() {
        println("${javaClass.simpleName} - ${javaClass.methods[1]}")
    }

    override fun back() {
        command.back()
        println("${javaClass.simpleName} - ${javaClass.methods[2]}")
    }
}