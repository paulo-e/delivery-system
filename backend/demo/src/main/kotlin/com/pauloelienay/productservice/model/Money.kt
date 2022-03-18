package com.pauloelienay.productservice.model

import java.math.BigDecimal

typealias `$` = Money

class Money(private var value: BigDecimal) {
	constructor(long: Long) : this(BigDecimal.valueOf(long))

	constructor(double: Double) : this(BigDecimal.valueOf(double))

	operator fun plusAssign(money: Money) {
		value += money.value
	}

	operator fun plus(money: Money) = value + money.value

	operator fun minusAssign(money: Money) {
		value -= money.value
	}

	operator fun minus(money: Money) = value - money.value

	operator fun divAssign(money: Money) {
		value /= money.value
	}

	operator fun div(money: Money) = value / money.value

	operator fun timesAssign(money: Money) {
		value *= money.value
	}

	operator fun times(money: Money) = value * money.value

	operator fun remAssign(money: Money) {
		value %= money.value
	}

	operator fun rem(money: Money) = value % money.value

	operator fun compareTo(money: Money) = value.compareTo(money.value)

	override fun toString(): String = "$${value.setScale(2)}"

	override fun equals(other: Any?): Boolean = if (other!!::class == Money::class) this.value == (other as Money).value
	else if (other::class == BigDecimal::class) this.value == other
	else false

	override fun hashCode(): Int = value.hashCode()

	fun toBigDecimal(): BigDecimal = value.setScale(2)
}