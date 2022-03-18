package com.pauloelienay.productservice.models

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class CustomerTest {
	@Test
	fun addToCart() {
		val customer = Customer()
		val product1 = Product(title = "Shoes")
		val product2 = Product(title = "Socks")

		customer += product1
		customer.addToCart(product2)

		assertEquals(listOf(product1, product2).associateBy { it.title }, customer.cartMap)
	}

	@Test
	fun removeFromCart() {
		val customer = Customer()
		val product1 = Product(title = "Shoes")
		val product2 = Product(title = "Socks")
		val product3 = Product(id = 1, title = "T-Shirt")

		customer += product1
		customer += product1
		customer += product2
		customer += product3
		customer -= product3
		customer -= product1
		customer.removeFromCart(product1)

		assertEquals(listOf(product2).associateBy { it.title }, customer.cartMap)
	}
}