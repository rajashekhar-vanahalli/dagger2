package com.raju.dagger.di.modules

import com.raju.dagger.di.modules.activities.FirstActivityModule
import com.raju.dagger.di.modules.activities.SecondActivityModule
import com.raju.dagger.di.scopes.PerActivity
import com.raju.dagger.presentation.activities.FirstActivity
import com.raju.dagger.presentation.activities.SecondActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilderModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [FirstActivityModule::class])
    abstract fun bindFirstActivity(): FirstActivity

    @PerActivity
    @ContributesAndroidInjector(modules = [SecondActivityModule::class])
    abstract fun bindSecondActivity(): SecondActivity
}