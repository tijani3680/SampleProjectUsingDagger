package com.example.mysampleminidaggerproject.di.modules

import android.content.Context
import com.example.mysampleminidaggerproject.core.dataSource.dataStore.DataStoreHelper
import com.example.mysampleminidaggerproject.di.ApplicationContext
import com.example.mysampleminidaggerproject.utils.NetworkHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class UtilsClassModule{
    @Provides
    @Singleton
    fun provideDataStoreHelper(@ApplicationContext context: Context): DataStoreHelper {
        return DataStoreHelper(context)
    }

}
