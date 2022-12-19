package com.raju.dagger.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.raju.dagger.R
import com.raju.dagger.databinding.FragmentSecondBinding
import com.raju.dagger.utils.DataManager
import com.raju.dagger.utils.User
import dagger.android.AndroidInjection
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

class SecondFragment : Fragment(), HasAndroidInjector {

    private var _binding: FragmentSecondBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @Named("data_manager_2")
    lateinit var dataManager: DataManager

    @Inject
    lateinit var user: User

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("SecondFragment", "dataManager: $dataManager")
        Log.d("SecondFragment", "user: $user")
        binding.textView.text = "Hello, ${user.name}"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector

    companion object {
        @JvmStatic
        fun newInstance() =
            SecondFragment().apply {
                arguments = Bundle().apply {

                }
            }
    }
}