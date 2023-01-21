package com.example.mysampleminidaggerproject.di.modules

import com.example.mysampleminidaggerproject.core.repository.UserRepository
import com.example.mysampleminidaggerproject.core.repository.UserRepositoryImpl
import dagger.Binds
import dagger.Module
import javax.inject.Singleton

@Module
internal interface RepositoryModule {
    @Binds
    @Singleton
    fun provideUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository

    /*    @Provides
    @Singleton
    fun provideUserRepository(repositoryImpl: UserRepositoryImpl): UserRepository {
        return repositoryImpl
    }*/
}
