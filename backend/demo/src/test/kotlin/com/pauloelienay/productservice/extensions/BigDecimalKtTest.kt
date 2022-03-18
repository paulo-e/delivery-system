package com.pauloelienay.productservice.extensions

import com.pauloelienay.productservice.model.`$`
import java.math.BigDecimal
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BigDecimalKtTest {

	@Test
	fun toMoney() {
		val money = BigDecimal.TEN.toMoney()

		assertEquals(`$`(10), money)
	}
}