package screen

import LINE_DIVIDER
import data.CartItems
import data.Product
import extensions.getNotEmptyInt
import extensions.getNotEmptyString

class ShoppingProductList {
    private val products = arrayOf(
        Product("패션", "겨울 패딩"),
        Product("패션", "겨울 패딩1"),
        Product("패션", "겨울 패딩2"),
        Product("패션", "겨울 패딩3"),
        Product("패션", "겨울 패딩4"),
    )

    private val categories: Map<String, List<Product>> = products.groupBy { product ->
        product.categoryLabel
    }

    fun showProducts(selectedCategory: String) {
        val categoryProducts = categories[selectedCategory]
        if(!categoryProducts.isNullOrEmpty()) {
            println("""
                $LINE_DIVIDER
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())

            //val productSize = categoryProducts.size
            /*for(index in 0 until productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }*/
            categoryProducts.forEachIndexed { index, product ->
                println("${index}. ${product.name}")
            }

            showCartOption(categoryProducts, selectedCategory)
        } else {
           showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showCartOption(categoryProducts: List<Product>, selectedCategory: String) {
        println("""
            $LINE_DIVIDER
            장바구니에 담을 상품 번호를 선택해주세요.
        """.trimIndent())

        val selectedIndex = readLine().getNotEmptyInt()
        categoryProducts.getOrNull(selectedIndex)?.let { product ->
            CartItems.addProduct(product)
            println("=> 장바구니로 이동하시려면 #을, 계속 쇼핑하시려면 *을 입력해주세요")
        }

        val answer = readLine().getNotEmptyString()
        if(answer == "#") {
            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItem()
        } else if (answer == "*"){
            showProducts(selectedCategory)
        } else {
            // TODO 그 외 값을 입력한 경우에 대한 처리
        }

    }
    


    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전 입니다.")
    }
}