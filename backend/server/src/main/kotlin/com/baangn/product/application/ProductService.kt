package com.baangn.product.application

import com.baangn.product.domain.*
import com.support.domain.Money
import org.springframework.stereotype.Service
import javax.transaction.Transactional

/**
 * 값 검사는 Dto
 * 사진이 열장까지는 도메인 로직이라고 생각한다.
 * TODO: 0821 물건 등록 시 사용자 정보가 존재하는지 유무는 어디에 존재해야할까 ? 일단 보류
 */

@Transactional
@Service
class ProductService(
    private val productRepository: ProductRepository,
) {
    fun create(userId: Long, request: CreateProductRequest): ProductResponse {

        val productImages = ProductImages(
            request.images.map {
                ProductImage(
                    url = it.url
                )
            }.toMutableList()
        )

        check(productImages.images.size <= 10) { "이미지는 최대 열장까지 가능합니다" }

        val product = Product(
            seller = Seller(id = userId),
            title = request.title,
            description = request.description,
            money = Money.krw(request.money),
            productImages = productImages,
            categoryIds = request.categoryIds
        ).also {  }

        product.updateThumbnailImage()

        return ProductResponse(productRepository.save(product))
    }
}