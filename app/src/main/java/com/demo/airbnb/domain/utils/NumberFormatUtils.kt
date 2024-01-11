package com.demo.airbnb.domain.utils

import android.icu.text.NumberFormat
import java.util.Locale

object NumberFormatUtils {
    fun formatCurrency(locale: Locale, value: Double): String {
        return NumberFormat.getCurrencyInstance(locale).format(value)
    }
}