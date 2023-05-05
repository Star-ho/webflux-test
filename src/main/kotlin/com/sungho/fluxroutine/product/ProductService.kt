package com.sungho.fluxroutine.product

import kotlinx.coroutines.flow.*
import kotlinx.coroutines.reactor.awaitSingle
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Transactional


@Component
class ProductService(
    private val productRepository: ProductRepository,
) {
    suspend fun getProductList(): Flow<Product> {
        return productRepository.findAllProductList()
    }

    suspend fun getProductById(id: Long): Product {
        return productRepository.findById(id).awaitSingle()
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



