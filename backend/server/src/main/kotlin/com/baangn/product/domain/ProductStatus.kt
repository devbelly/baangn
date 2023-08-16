package com.baangn.product.domain


enum class ProductStatus(val description: String){
    HIDE("숨기기"),
    FOR_SALE("판매중"),
    SOLD_OUT("거래완료"),
    RESERVED("예약중"),
    DELETED("삭제"),
    REVIEWED("리뷰완료")
}