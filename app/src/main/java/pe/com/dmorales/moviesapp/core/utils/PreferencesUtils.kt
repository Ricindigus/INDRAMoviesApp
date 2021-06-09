package pe.com.dmorales.moviesapp.core.utils

import android.content.SharedPreferences


fun SharedPreferences.getString(key: String): String? {
    return getString(key, null)
}

fun SharedPreferences.putString(key: String, value: String?) {
    edit().putString(key, value).apply()
}

fun SharedPreferences.getBoolean(key: String): Boolean {
    return getBoolean(key, false)
}

fun SharedPreferences.putBoolean(key: String, value: Boolean) {
    edit().putBoolean(key, value).apply()
}

fun SharedPreferences.getLong(key: String): Long {
    return getLong(key, 0)
}

fun SharedPreferences.putLong(key: String, value: Long) {
    edit().putLong(key, value).apply()
}

fun SharedPreferences.getInt(key: String): Int {
    return getInt(key, 0)
}

fun SharedPreferences.putInt(key: String, value: Int) {
    edit().putInt(key, value).apply()
}