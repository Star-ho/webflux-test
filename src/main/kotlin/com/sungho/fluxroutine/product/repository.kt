package com.sungho.fluxroutine.product

import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository
import reactor.core.publisher.Flux

interface ProductRepository: ReactiveCrudRepository<Product, Long> {
    @Query("select * from PRODUCT")
    suspend fun findAllProductList(): List<Product>
    suspend fun findByLabel(label: String): List<Product>
}
