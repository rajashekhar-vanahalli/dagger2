package com.raju.dagger.presentation.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import androidx.fragment.app.commit
import com.raju.dagger.R
import com.raju.dagger.databinding.ActivitySecondBinding
import com.raju.dagger.presentation.fragments.SecondFragment
import com.raju.dagger.utils.DataManager
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject
import javax.inject.Named

class SecondActivity : AppCompatActivity(), HasAndroidInjector {

    private lateinit var binding: ActivitySecondBinding

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @Named("data_manager_2")
    lateinit var dataManager: DataManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AndroidInjection.inject(this) // instead of getApplication().getComponent().inject(this)
        if (savedInstanceState == null) {
            supportFragmentManager.commit {
                setReorderingAllowed(true)
                add<SecondFragment>(R.id.fragment_container_view)
            }
        }
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}