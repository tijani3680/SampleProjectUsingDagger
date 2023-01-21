package com.example.mysampleminidaggerproject.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException
import javax.inject.Inject
import javax.inject.Provider
import javax.inject.Singleton

@Singleton
class MyViewModelFactory @Inject constructor(private val creators:Map<Class<out ViewModel>,@JvmSuppressWildcards Provider<ViewModel>>) :ViewModelProvider.Factory{
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val creator =creators[modelClass]
            ?:throw IllegalArgumentException("unknown model call $modelClass")
        return modelClass.cast(creator.get())!!
    }
}
