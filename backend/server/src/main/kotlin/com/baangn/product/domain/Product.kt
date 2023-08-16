package com.baangn.product.domain

import com.support.domain.BaseRootEntity
import com.support.domain.Location
import com.support.domain.Money
import javax.persistence.*

/**
 * TODO: 조회전용쿼리 작성, override 없이 엔티티 동일성 비교
 * TODO: like, chat count 이동
 * TODO: DELETE 어노테이션 적용하기
 */

@Entity
@Table
class Product(
    @Embedded
    val seller: Seller,

    @Embedded
    val buyer: Buyer? = null,

    status: ProductStatus = ProductStatus.FOR_SALE,

    title: String,

    description: String,

    productImages: ProductImages = ProductImages(),

    money: Money,

    location: Location = Location(),

    thumbNailImage: String = "",

    viewCount: Long = 0,

    categoryIds: List<Long> = listOf(),

    id: Long = 0L
) : BaseRootEntity<Product>(id) {

    @Embedded
    var status: ProductStatus = status
        private set

    @Column(nullable = false, length = 255)
    var title: String = title
        private set

    @Column(nullable = false, length = 255)
    var description: String = description
        private set

    @Embedded
    var productImages: ProductImages = productImages
        private set

    @Embedded
    var money: Money = money
        private set

    @Embedded
    var location: Location = location
        private set

    @Column
    var thumbNailImage: String = thumbNailImage
        private set

    @Column
    var viewCount: Long = viewCount
        private set

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
        name = "product_category",
        joinColumns = [JoinColumn(name = "product_id")]
    )
    private val _categoryIds: MutableList<Long> = categoryIds.toMutableList()

    val categoryIds: List<Long>
        get() = _categoryIds

    val soldOut: Boolean
        get() = status == ProductStatus.FOR_SALE

    val reviewed: Boolean
        get() = status == ProductStatus.REVIEWED

    fun addCategory(categoryId: Long) {
        check(_categoryIds.size <= 3) { "카테고리는 최대 셋까지만" }
        _categoryIds.removeIf { it == categoryId }
        _categoryIds.add(categoryId)
    }

    fun addProductImages(url: String) {
        check(productImages.images.size <= 9) { "이미지는 최대 열장까지만" }
        productImages.add(ProductImage(url))
    }

    fun increaseViewCount() {
        viewCount++
    }

    fun changeStatus(status: ProductStatus) {
        this.status = status
    }

    fun updateThumbnailImage() {
        thumbNailImage = productImages.images
            .takeIf { it.isNotEmpty() }
            ?.first()!!.url
    }
}