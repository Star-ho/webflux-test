package com.sungho.fluxroutine.product

import kotlinx.coroutines.flow.Flow
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import java.math.BigDecimal

@RestController
@RequestMapping("/product")
class ProductController(
    private val productService: ProductService
){
    @GetMapping
    suspend fun getProductList(): Flow<Product> {
        return productService.getProductList()
    }

    @GetMapping("/{id}")
    suspend fun getProduct(@PathVariable("id") id:Long): Product {
        return productService.getProductById(id)
    }

    @PostMapping
    suspend fun saveProduct(@RequestBody saveProductRequest: SaveProductRequest){
        productService.saveProduct(saveProductRequest)
    }

    @PutMapping("/{id}")
    suspend fun updateProduct(@PathVariable id:Long,@RequestBody updateProductRequest: UpdateProductRequest){
        productService.updateProduct(id,updateProductRequest)
    }
}

class SaveProductRequest(
    val label:String,
    val price:BigDecimal,
)

class UpdateProductRequest(
    val label:String,
    val price:BigDecimal,
)