package com.pauloelienay.productservice.utils

import java.math.BigDecimal
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

internal class MoneyTest {
	@Test
	fun constructorHandlesLong() {
		val money = `$`(10)

		assertEquals(BigDecimal.TEN.setScale(2), money.toBigDecimal())
	}

	@Test
	fun constructorHandlesDouble() {
		val money = `$`(10.00)

		assertEquals(BigDecimal.TEN.setScale(2), money.toBigDecimal())
	}

	@Test
	fun testsToString() {
		val money = `$`(10)

		assertEquals("$10.00", money.toString())
	}

	@Test
	fun plusAssign() {
		val money = `$`(10)

		money += `$`(10)

		assertEquals(`$`(20).toBigDecimal(), money.toBigDecimal())
	}

	@Test
	fun plus() {
		val money = `$`(10)

		val actual = money + `$`(10)

		assertEquals(`$`(20).toBigDecimal(), actual.setScale(2))
	}

	@Test
	fun minusAssign() {
		val money = `$`(10)

		money -= `$`(10)

		assertEquals(`$`(0).toBigDecimal(), money.toBigDecimal())
	}

	@Test
	fun minus() {
		val money = `$`(10)

		val actual = money - `$`(10)

		assertEquals(`$`(0), actual)
	}

	@Test
	fun divAssign() {
		val money = `$`(10)

		money /= `$`(10)

		assertEquals(`$`(1), money)
	}

	@Test
	fun div() {
		val money = `$`(10)

		val actual = money / `$`(10)

		assertEquals(`$`(1), actual)
	}

	@Test
	fun timesAssign() {
		val money = `$`(10)

		money *= `$`(10)

		assertEquals(`$`(100), money)
	}

	@Test
	fun times() {
		val money = `$`(10)

		val actual = money * `$`(10)

		assertEquals(`$`(100), actual)
	}

	@Test
	fun remAssign() {
		val money = `$`(10)

		money %= `$`(10)

		assertEquals(`$`(0), money)
	}

	@Test
	fun rem() {
		val money = `$`(10)

		val actual = money % `$`(10)

		assertEquals(`$`(0), actual)
	}

	@Test
	fun compareTo() {
		val money = `$`(10)

		val equals = `$`(10)
		val more = `$`(20)
		val less = `$`(5)

		assertEquals(0, money.compareTo(equals))
		assertEquals(-1, money.compareTo(more))
		assertEquals(1, money.compareTo(less))
	}

	@Test
	fun toBigDecimal() {
		val money = `$`(10)

		assertEquals(BigDecimal.TEN.setScale(2), money.toBigDecimal())
	}
}