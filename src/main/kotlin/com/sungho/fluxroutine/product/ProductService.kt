//package com.sungho.fluxroutine.product
//
//import kotlinx.coroutines.*
//import org.springframework.data.repository.reactive.ReactiveCrudRepository
//import org.springframework.stereotype.Component
//import org.springframework.stereotype.Repository
//import org.springframework.web.bind.annotation.RequestMapping
//import org.springframework.web.bind.annotation.RestController
//import reactor.core.publisher.Flux
//import java.math.BigDecimal
//import javax.persistence.*
//
//@RestController
//class ProductController(
//    private val productService: ProductService
//){
//    @RequestMapping("/product")
//    suspend fun getProductList(): List<Product> {
//        return productService.getProductList()
//    }
//}
//
//@Component
//class ProductService(
//    private val productRepository: ProductRepository,
//) {
//    suspend fun getProductList(): List<Product> {
//        return withContext(Dispatchers.Default) { productRepository.findByLabel("asd") }
//    }
//}
//
//@Entity
//class Product(
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    val id: Long = 0,
//
//    @Column(name = "LABEL")
//    var label: String = "",
//
//    @Column(name = "PRICE")
//    var price: BigDecimal = BigDecimal.ZERO,
//
//    )
//
//@Repository
//interface ProductRepository:ReactiveCrudRepository<Product,Long>{
//    suspend fun findByLabel(label: String):List<Product>
//
//}
