package com.pauloelienay.productservice.models

import javax.persistence.Entity
import javax.persistence.FetchType.EAGER
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType.IDENTITY
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.Table

@Entity
@Table(name = "products")
data class Product(
	@Id @GeneratedValue(strategy = IDENTITY) var id: Long? = null,

	var title: String? = null,

	var description: String? = null,

	@ManyToOne(fetch = EAGER, optional = false) @JoinColumn(name = "owner_id",
		nullable = false) var owner: Customer? = null,
)
