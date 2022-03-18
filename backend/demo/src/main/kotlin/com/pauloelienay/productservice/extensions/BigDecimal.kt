package com.pauloelienay.productservice.extensions

import com.pauloelienay.productservice.utils.`$`
import java.math.BigDecimal

fun BigDecimal.toMoney() = `$`(this)