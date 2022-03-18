package com.pauloelienay.productservice.converters

import com.pauloelienay.productservice.models.customer.CustomerName
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class CustomerNameConverter : AttributeConverter<CustomerName, String> {
	override fun convertToDatabaseColumn(attribute: CustomerName?): String =
		"${attribute!!.firstName} ${attribute.lastName}"

	override fun convertToEntityAttribute(dbData: String?): CustomerName {
		val names = dbData!!.split(" ")
		return CustomerName(names[0], names[1])
	}
}