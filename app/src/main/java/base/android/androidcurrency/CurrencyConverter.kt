package base.android.androidcurrency

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

object CurrencyConverter {

    fun displayCurrency(language: String?, countryISO: String?, currencyAmount: String): String {
        var language = language
        var countryISO = countryISO
        if ("" == countryISO || countryISO == null) {
            countryISO = "GH"
        }
        if ("" == language || language == null) {
            language = "en"
        }
        val newLocale = Locale(language, countryISO)
        try {
            val doubleValue = java.lang.Double.parseDouble(currencyAmount)
            val currencyFormatter = NumberFormat.getCurrencyInstance(newLocale)
            return currencyFormatter.format(doubleValue)
        } catch (ex: NumberFormatException) {
            return "0.00"
        }

    }

    fun getCurrentCurrency(language: String?, countryISO: String?): String {
        var language = language
        var countryISO = countryISO
        if ("" == countryISO || countryISO == null) {
            countryISO = "GH"
        }
        if ("" == language || language == null) {
            language = "en"
        }
        val currentLocale = Locale(language, countryISO)
        val currentCurrency = Currency.getInstance(currentLocale)
        return currentCurrency.symbol
    }

}
