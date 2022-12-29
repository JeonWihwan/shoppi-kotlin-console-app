package screen

class ShoppingHome {

    fun start() {
        welcomeMessage()
        showCategories()
    }

    private fun welcomeMessage() {
        println("안녕하세요, Shoppi에 오신 것을 환영합니다.")
        println("이름을 입력하세요 : ")

        val name = readLine()
        println(
            """
                감사합니다. 반갑습니다. $name 님
                원하시는 카테고리를 입력해주세요.
                ***============================================***
            """.trimIndent()
        )
    }

    private fun showCategories() {
        val shoppingCategory = ShoppingCategory()
        shoppingCategory.showCategories()
    }



}