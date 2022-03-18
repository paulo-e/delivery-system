package com.pauloelienay.productservice.models

import com.pauloelienay.productservice.converters.CustomerNameConverter
import com.pauloelienay.productservice.converters.MoneyConverter
import com.pauloelienay.productservice.models.customer.CustomerName
import com.pauloelienay.productservice.utils.Money
import javax.persistence.CascadeType.ALL
import javax.persistence.Convert
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.OneToMany
import javax.persistence.Table

@Entity
@Table(name = "customers")
data class Customer(
	@Id @GeneratedValue(strategy = IDENTITY) var id: Long? = null,

	@Convert(converter = CustomerNameConverter::class) var customerName: CustomerName? = null,

	@Convert(converter = MoneyConverter::class) var balance: Money? = null,

	@OneToMany(mappedBy = "owner",
		fetch = LAZY,
		cascade = [ALL]) private var cart: MutableCollection<Product> = mutableListOf(),
) {
	val cartMap: Map<String, Product>
		get() = cart.associateBy { it.title!! }

	fun addToCart(product: Product) {
		cart.add(product)
	}

	operator fun plusAssign(product: Product) = addToCart(product)

	fun removeFromCart(product: Product) {
		if (product.id != null)
			cart.removeIf { it.id == product.id }
		else cart.removeIf { it == product }
	}

	operator fun minusAssign(product: Product) = removeFromCart(product)
}