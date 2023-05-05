package com.sungho.fluxroutine.product

import kotlinx.coroutines.flow.Flow
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface ProductRepository: ReactiveCrudRepository<Product, Long> {
    @Query("select * from PRODUCT")
    suspend fun findAllProductList(): Flow<Product>
    suspend fun findByLabel(label: String): List<Product>
}
