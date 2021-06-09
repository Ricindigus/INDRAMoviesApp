package pe.com.dmorales.moviesapp.core.utils

import androidx.databinding.InverseMethod

object ConverterUtils{
    @InverseMethod("stringToInt")
    @JvmStatic fun intToString(value: Int?): String {
        return value?.toString() ?: String.EMPTY
    }

    @JvmStatic fun stringToInt(value: String): Int? {
        return if (value.isEmpty()) null else value.toInt()
    }

    @InverseMethod("stringToText")
    @JvmStatic fun textToString(value: String?): String {
        return (value?: String.EMPTY)
    }

    @JvmStatic fun stringToText(valueString: String): String? {
        return if (valueString.isBlank()) null else valueString
    }
}

