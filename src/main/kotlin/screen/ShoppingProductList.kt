package screen

import data.Product

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
                ***==============================
                선택하신 [$selectedCategory] 카테고리 상품입니다.
            """.trimIndent())
            val productSize = categoryProducts.size
            for(index in 0 until productSize) {
                println("${index}. ${categoryProducts[index].name}")
            }
        } else {
           showEmptyProductMessage(selectedCategory)
        }
    }

    private fun showEmptyProductMessage(selectedCategory: String) {
        println("[$selectedCategory] 카테고리의 상품이 등록되기 전 입니다.")
    }
}