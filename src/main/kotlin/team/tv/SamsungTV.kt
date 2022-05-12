package team.tv

class SamsungTV: IReceiver {
    override fun onLoginOpened() {
        println("${javaClass.simpleName} - ${javaClass.methods[0].name}")
    }

    override fun onChannelsOpened() {
        println("${javaClass.simpleName} - ${javaClass.methods[1].name}")
    }

    override fun onPlayerOpened() {
        println("${javaClass.simpleName} - ${javaClass.methods[2].name}")
    }
}