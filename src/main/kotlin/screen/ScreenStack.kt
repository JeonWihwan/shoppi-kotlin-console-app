package screen

object ScreenStack {

    private val screenStack = mutableListOf<Screen>()

    fun push(screen: Screen) {
        screenStack.add(screen)
    }
    fun pop(screen: Screen) {
        screenStack.removeLastOrNull()
    }
    fun peek() : Screen? {
        return screenStack.lastOrNull()
    }
}

sealed class Screen