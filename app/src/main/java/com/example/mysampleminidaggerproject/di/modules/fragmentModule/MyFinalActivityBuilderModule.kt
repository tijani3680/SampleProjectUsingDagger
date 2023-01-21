package com.example.mysampleminidaggerproject.di.modules.fragmentModule

import com.example.mysampleminidaggerproject.di.ActivityScope
import com.example.mysampleminidaggerproject.ui.view.activity.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
internal interface MyFinalActivityBuilderModule {

    @ContributesAndroidInjector(modules = [MainActivityModule::class, MainFragmentBuilder::class])
    @ActivityScope
    fun mainActivity(): MainActivity
}
