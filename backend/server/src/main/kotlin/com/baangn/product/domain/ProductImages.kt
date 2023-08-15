package com.baangn.product.domain

import javax.persistence.CollectionTable
import javax.persistence.ElementCollection
import javax.persistence.Embeddable
import javax.persistence.FetchType

/**
 *
 */

@Embeddable
class ProductImages (
    images: MutableList<ProductImage> = mutableListOf()
) {
    @ElementCollection(fetch = FetchType.EAGER)
    @CollectionTable(name = "product_images")
    private val _images: MutableList<ProductImage> = images.toMutableList()
    val images: List<ProductImage>
        get() = _images

    fun add(image: ProductImage) {
        _images.add(image)
    }

    fun remove(image: ProductImage) {
        _images.remove(image)
    }

    fun removeAll() {
        _images.clear()
    }
}