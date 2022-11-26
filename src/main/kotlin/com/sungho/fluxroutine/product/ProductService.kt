package com.sungho.fluxroutine.product

import kotlinx.coroutines.*
import kotlinx.coroutines.reactive.awaitSingle
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional
import java.math.BigDecimal


@Component
class ProductService(
    private val productRepository: ProductRepository,
) {
    suspend fun getProductList(): List<Product> {
        val product: List<Product> = productRepository.findAllProductList()
        return product

    }

    suspend fun getProductById(id:Long): Product {
        val product: Product = productRepository.findById(id).awaitSingle()
        return product
    }

    @Transactional
    suspend fun saveProduct(saveProductRequest: SaveProductRequest){
        val product = Product(label = saveProductRequest.label, price = saveProductRequest.price)
         productRepository.save(product).awaitSingle()
    }

    @Transactional
    suspend fun updateProduct(id:Long,updateProductRequest: UpdateProductRequest){
        val product = productRepository.findById(id).awaitSingle()
        product.label = updateProductRequest.label
        product.price = updateProductRequest.price
        productRepository.save(product).awaitSingle()
    }
}



