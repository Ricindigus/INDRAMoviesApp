package pe.com.dmorales.moviesapp.core.data.datasource.local.preferences

import android.content.SharedPreferences
import pe.com.dmorales.moviesapp.core.utils.getBoolean
import pe.com.dmorales.moviesapp.core.utils.getString
import pe.com.dmorales.moviesapp.core.utils.putBoolean
import pe.com.dmorales.moviesapp.core.utils.putString

class AuthenticationPreferences(private val preferences: SharedPreferences) {
    companion object {
        const val PREFERENCES_NAME = "AuthenticationPreferences"
        const val KEY_TOKEN = "token"
        const val KEY_IS_LOGGED = "is_logged"
    }

    var logged: Boolean
        get() = preferences.getBoolean(KEY_IS_LOGGED)
        set(value) = preferences.putBoolean(KEY_IS_LOGGED, value)

    var token: String?
        get() = preferences.getString(KEY_TOKEN)
        set(value) = preferences.putString(KEY_TOKEN, value)

    fun clear() {
        preferences.edit().clear().apply()
    }
}
