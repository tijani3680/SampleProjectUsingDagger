package com.example.mysampleminidaggerproject.di

import android.content.Context
import com.example.mysampleminidaggerproject.App
import com.example.mysampleminidaggerproject.di.modules.fragmentModule.MyFinalActivityBuilderModule
import com.example.mysampleminidaggerproject.di.modules.RepositoryModule
import com.example.mysampleminidaggerproject.di.modules.RetrofitModule
import com.example.mysampleminidaggerproject.di.modules.RoomModule
import com.example.mysampleminidaggerproject.di.modules.UtilsClassModule
import com.example.mysampleminidaggerproject.di.modules.ViewModelModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [AndroidInjectionModule::class, RetrofitModule.ApiHelperModule::class, ViewModelModule::class, RoomModule.MainDaoHelperModule::class, RetrofitModule::class, RoomModule::class, RepositoryModule::class, UtilsClassModule::class, MyFinalActivityBuilderModule::class]
)

interface MainComponent {
    fun inject(application: App)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun applicationContext(@ApplicationContext context: Context): Builder
        fun build(): MainComponent
    }
}
