package com.demo.airbnb.utils

import com.demo.airbnb.domain.utils.NumberFormatUtils
import org.junit.Assert.*

import org.junit.Test
import java.util.Locale

class NumberFormatUtilsTest {

    @Test
    fun formatCurrencyInUSD() {
        val result = NumberFormatUtils.formatCurrency(Locale.US, 123.45)
        assertEquals("$123.45", result)
    }

    @Test
    fun formatCurrencyInBRL() {
        val result = NumberFormatUtils.formatCurrency(Locale("pt", "BR"), 123.45)
        assertEquals("R$ 123,45", result)
    }
}