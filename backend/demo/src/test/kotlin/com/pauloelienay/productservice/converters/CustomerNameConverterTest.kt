package com.pauloelienay.productservice.converters

import com.pauloelienay.productservice.models.customer.CustomerName
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CustomerNameConverterTest {

	@Test
	fun convertToDatabaseColumn() {
		val customerNameConverter = CustomerNameConverter()
		val customerName = CustomerName(firstName = "Elienay", lastName = "Albuquerque")

		assertEquals("Elienay Albuquerque", customerNameConverter.convertToDatabaseColumn(customerName))
	}

	@Test
	fun convertToEntityAttribute() {
		val customerNameConverter = CustomerNameConverter()
		val customerName = CustomerName(firstName = "Elienay", lastName = "Albuquerque")

		assertEquals(customerNameConverter.convertToEntityAttribute("Elienay Albuquerque"), customerName)
	}
}