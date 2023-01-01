package screen

import extensions.getNotEmptyString

/*
Step1. 장바구니에 추가한 상품 관리
Step2. 사용자 입력값 요청 처리 공통화
Step3. 프로젝트 전역에서 참조하는 상수
* */

class ShoppingCategory {
    fun showCategories() {
        val categories = arrayOf("패션", "전자기기", "반려동물용품")
        for (category in categories) {
            println(category)
        }
        println("=> 장바구니로 이동하시려면 #을 입력해주세요")

        var selectedCategory = readLine().getNotEmptyString()

        if (selectedCategory == "#") {

            val shoppingCart = ShoppingCart()
            shoppingCart.showCartItem()

        } else {
            if(categories.contains(selectedCategory)) {
                val shoppingProductList = ShoppingProductList()
                shoppingProductList.showProducts(selectedCategory)
            } else {
                showErrorMessage(selectedCategory)
            }
        }
    }

    private fun showErrorMessage(selectedCategory: String?) {
        println("[${selectedCategory}] : 존재하지 않는 카테고리 입니다. 다시 입력해주세요.")
        showCategories()
    }
}