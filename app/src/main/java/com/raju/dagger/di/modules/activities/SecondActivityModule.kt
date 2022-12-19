package com.raju.dagger.di.modules.activities

import com.raju.dagger.di.modules.ActivityModule
import com.raju.dagger.di.modules.SecondDataManagerModule
import com.raju.dagger.di.modules.fragments.SecondFragmentModule
import com.raju.dagger.di.scopes.PerFragment
import com.raju.dagger.presentation.fragments.SecondFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class, SecondDataManagerModule::class])
abstract class SecondActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [SecondFragmentModule::class])
    abstract fun secondFragment(): SecondFragment
}