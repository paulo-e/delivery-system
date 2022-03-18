package com.pauloelienay.productservice.extensions

import com.pauloelienay.productservice.utils.`$`
import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class BigDecimalKtTest {

	@Test
	fun toMoney() {
		val money = BigDecimal.TEN.toMoney()

		assertEquals(`$`(10), money)
	}
}