package com.pauloelienay.productservice.converters

import com.pauloelienay.productservice.extensions.toMoney
import com.pauloelienay.productservice.utils.Money
import java.math.BigDecimal
import javax.persistence.AttributeConverter
import javax.persistence.Converter

@Converter
class MoneyConverter : AttributeConverter<Money, BigDecimal> {
	override fun convertToDatabaseColumn(attribute: Money?): BigDecimal = attribute!!.toBigDecimal()

	override fun convertToEntityAttribute(dbData: BigDecimal?): Money = dbData!!.toMoney()

}