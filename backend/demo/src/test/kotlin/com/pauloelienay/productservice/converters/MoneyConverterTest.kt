package com.pauloelienay.productservice.converters

import com.pauloelienay.productservice.utils.`$`
import java.math.BigDecimal.TEN
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MoneyConverterTest {

	@Test
	fun convertToDatabaseColumn() {
		val moneyConverter = MoneyConverter()
		val money = `$`(10)

		assertEquals(TEN.setScale(2), moneyConverter.convertToDatabaseColumn(money))
	}

	@Test
	fun convertToEntityAttribute() {
		val moneyConverter = MoneyConverter()

		assertEquals(`$`(10), moneyConverter.convertToEntityAttribute(TEN))
	}
}