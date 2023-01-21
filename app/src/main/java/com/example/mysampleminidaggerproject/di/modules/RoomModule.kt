package com.example.mysampleminidaggerproject.di.modules

import android.content.Context
import androidx.room.Room
import com.example.mysampleminidaggerproject.core.dataSource.local.DatabaseHelper
import com.example.mysampleminidaggerproject.core.dataSource.local.MainDao
import com.example.mysampleminidaggerproject.core.dataSource.local.MainDaoHelper
import com.example.mysampleminidaggerproject.core.dataSource.local.MainDaoHelperImpl
import com.example.mysampleminidaggerproject.core.dataSource.remote.ApiHelper
import com.example.mysampleminidaggerproject.core.dataSource.remote.ApiHelperImpl
import com.example.mysampleminidaggerproject.core.repository.UserRepositoryImpl
import com.example.mysampleminidaggerproject.di.ApplicationContext
import dagger.Binds
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
internal class RoomModule {

    @Provides
    @Singleton
    fun provideDataBase(@ApplicationContext context: Context): DatabaseHelper {
        return Room.databaseBuilder(context, DatabaseHelper::class.java, "TijaniDatabase")
            .fallbackToDestructiveMigration()
            .build()
    }

       @Provides
       @Singleton
       fun provideMainDao(dataBase: DatabaseHelper): MainDao {
           return dataBase.mainDao
       }


    @Module
    internal interface MainDaoHelperModule {
        @Binds
        @Singleton
        fun provideMainDaoHelper(mainDaoHelperImpl: MainDaoHelperImpl): MainDaoHelper

    }

}
