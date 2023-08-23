package com.baangn.product.application

import com.baangn.product.domain.Product
import java.math.BigDecimal
import javax.validation.constraints.Min
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern

data class CreateProductRequest(
    @field:NotNull
    val title: String,
    @field:NotNull
    val description: String,
    @field:Min(0)
    val money: BigDecimal,
    val images: List<ImageData>,
    val categoryIds: List<Long>,
)

data class ProductResponse(
    val id: Long,
    val title: String,
    val description: String,
    val money: BigDecimal,
    val images: List<ImageData>
) {
    constructor(product: Product) : this(
        product.id,
        product.title,
        product.description,
        product.money.amount,
        product.productImages.images.map { ImageData(it.url) }
    )
}

data class ImageData(
//    @field:Pattern(
//        regexp = "^(http(s?):)([/|.|\\w|\\s|-])*\\.(?:jpg|gif|png)\$",
//        message = "올바른 형식의 이미지 URL이어야 합니다"
//    )
    val url: String
)