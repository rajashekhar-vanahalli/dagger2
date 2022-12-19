package com.raju.dagger.di.modules.fragments

import com.raju.dagger.di.scopes.PerFragment
import com.raju.dagger.utils.User
import dagger.Module
import dagger.Provides

@Module
class SecondFragmentModule {

    @Provides
    @PerFragment
    fun providesUser() = User("I am user 2")
}