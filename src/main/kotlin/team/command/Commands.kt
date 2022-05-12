package team.command

interface ICommand {
    fun navigate(code: String)
    fun invoke()
    fun back()
}