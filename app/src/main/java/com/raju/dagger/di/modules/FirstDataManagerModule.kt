package com.raju.dagger.di.modules

import android.content.Context
import android.content.SharedPreferences
import com.raju.dagger.di.scopes.PerActivity
import com.raju.dagger.utils.DataManager
import dagger.Module
import dagger.Provides
import javax.inject.Named
import javax.inject.Singleton

@Module
class FirstDataManagerModule {

    @Provides
    @PerActivity
    @Named("shared_pref_1")
    fun provideSharedPreferences1(context: Context): SharedPreferences =
        context.getSharedPreferences("shared_pref_1", Context.MODE_PRIVATE)

    @Provides
    @PerActivity
    @Named("data_manager_1")
    fun provideDataManager1(@Named("shared_pref_1") sharedPreferences: SharedPreferences): DataManager =
        DataManager(sharedPreferences)

}