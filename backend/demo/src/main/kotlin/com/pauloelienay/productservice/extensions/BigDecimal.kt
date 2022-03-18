package com.pauloelienay.productservice.extensions

import com.pauloelienay.productservice.model.`$`
import java.math.BigDecimal

fun BigDecimal.toMoney() = `$`(this)