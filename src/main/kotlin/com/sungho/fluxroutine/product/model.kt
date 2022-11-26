package com.sungho.fluxroutine.product

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table
import java.math.BigDecimal




@Table(name = "PRODUCT")
class Product(
    @Id
    var id: Long = 0,

    var label: String = "",

    var price: BigDecimal = BigDecimal.ZERO,
)