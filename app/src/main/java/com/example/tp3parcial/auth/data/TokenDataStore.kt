package com.example.tp3parcial.auth.data

import android.content.Context
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStoreFile
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.first
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TokenDataStore @Inject constructor(
    @ApplicationContext private val context: Context
) {
    private val dataStore = PreferenceDataStoreFactory.create {
        context.preferencesDataStoreFile("auth_prefs")
    }
    private val USER_ID_KEY = intPreferencesKey("user_id")

    suspend fun saveToken(token: String) {
        dataStore.edit { it[TOKEN_KEY] = token }
    }

    suspend fun getToken(): String? {
        return dataStore.data.first()[TOKEN_KEY]
    }

    suspend fun clearToken() {
        dataStore.edit { it.remove(TOKEN_KEY) }
    }


    suspend fun saveUserId(id: Int) {
        dataStore.edit { it[USER_ID_KEY] = id }
    }

    suspend fun getUserId(): Int? {
        return dataStore.data.first()[USER_ID_KEY]
    }

    suspend fun clearUserId() {
        dataStore.edit { it.remove(USER_ID_KEY) }
    }

    companion object {
        val TOKEN_KEY = stringPreferencesKey("auth_token")
    }
}