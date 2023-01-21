package com.example.mysampleminidaggerproject.core.dataSource.dataStore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.example.mysampleminidaggerproject.di.ApplicationContext
import com.example.mysampleminidaggerproject.utils.ConstantVariable
import javax.inject.Inject
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class DataStoreHelper @Inject constructor (@ApplicationContext context: Context) {
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(ConstantVariable.TIJANI_DATA_STORE)
    private val dataStore: DataStore<Preferences> = context.dataStore
    suspend fun saveUserName(userName: String) {
        dataStore.edit { dataStore ->
            dataStore[ConstantVariable.USER_NAME_KEY_DATA_STORE] = userName
        }
    }
    fun getUserName(): Flow<String> {
        val userName: Flow<String> = dataStore.data
            .map {
                val userName = it[ConstantVariable.USER_NAME_KEY_DATA_STORE] ?: ""
                userName
            }

        return userName
    }

    suspend fun clearDataStore() {
        dataStore.edit {
            it.clear()
        }
    }

}
