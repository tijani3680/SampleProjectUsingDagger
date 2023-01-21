package com.example.mysampleminidaggerproject.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mysampleminidaggerproject.di.MyViewModelFactory
import com.example.mysampleminidaggerproject.di.ViewModelKey
import com.example.mysampleminidaggerproject.ui.viewmodel.SubjectVM
import com.example.mysampleminidaggerproject.ui.viewmodel.UserVM
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
internal interface ViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(UserVM::class)
    fun provideUserViewModle(userVM: UserVM): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(SubjectVM::class)
    fun provideSubjectViewModle(subjectVM: SubjectVM): ViewModel

    @Binds
    fun provideViewModelFactory(viewModelFactory: MyViewModelFactory): ViewModelProvider.Factory
}
