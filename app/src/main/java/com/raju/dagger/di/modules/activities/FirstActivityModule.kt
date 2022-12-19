package com.raju.dagger.di.modules.activities

import com.raju.dagger.di.modules.ActivityModule
import com.raju.dagger.di.modules.FirstDataManagerModule
import com.raju.dagger.di.modules.fragments.FirstFragmentModule
import com.raju.dagger.di.scopes.PerFragment
import com.raju.dagger.presentation.fragments.FirstFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module(includes = [ActivityModule::class, FirstDataManagerModule::class])
abstract class FirstActivityModule {

    @PerFragment
    @ContributesAndroidInjector(modules = [FirstFragmentModule::class])
    abstract fun firstFragment(): FirstFragment
}