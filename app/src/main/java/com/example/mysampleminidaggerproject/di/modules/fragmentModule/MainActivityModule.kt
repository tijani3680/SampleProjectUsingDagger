package com.example.mysampleminidaggerproject.di.modules.fragmentModule

import com.example.mysampleminidaggerproject.ui.view.fragment.FragmentDataStore
import com.example.mysampleminidaggerproject.di.FragmentScope
import com.example.mysampleminidaggerproject.di.modules.SubjectFragmentModules
import com.example.mysampleminidaggerproject.ui.view.fragment.FragmentHome
import com.example.mysampleminidaggerproject.ui.view.fragment.FragmentOther
import com.example.mysampleminidaggerproject.ui.view.fragment.FragmentSubject
import com.example.templete.di.modules.fragmentModule.OtherFragmentModules
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal class MainActivityModule

@Module
internal interface MainFragmentBuilder{
    @ContributesAndroidInjector(modules = [HomeFragmentModules::class])
    @FragmentScope
    fun homeFragment():FragmentHome

    @ContributesAndroidInjector(modules = [SubjectFragmentModules::class])
    @FragmentScope
    fun subjectFragment():FragmentSubject

    @ContributesAndroidInjector(modules = [OtherFragmentModules::class])
    @FragmentScope
    fun otherFragment():FragmentOther

    @ContributesAndroidInjector(modules = [DataStoreFragmentModule::class])
    @FragmentScope
    fun dataStoreFragment(): FragmentDataStore
}
