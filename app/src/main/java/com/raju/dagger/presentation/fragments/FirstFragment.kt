package com.raju.dagger.presentation.fragments

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.raju.dagger.databinding.FragmentFirstBinding
import com.raju.dagger.presentation.activities.SecondActivity
import com.raju.dagger.utils.DataManager
import com.raju.dagger.utils.User
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject
import javax.inject.Named

class FirstFragment : Fragment(), HasAndroidInjector {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and onDestroyView.
    private val binding get() = _binding!!

    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    @Inject
    @Named("data_manager_1")
    lateinit var dataManager: DataManager

    @Inject
    lateinit var user: User

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
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
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("FirstFragment", "dataManager: $dataManager")
        Log.d("FirstFragment", "user: $user")
        binding.textView.text = "Hello, ${user.name}"

        binding.textView.setOnClickListener {
            Intent(requireActivity(), SecondActivity::class.java).apply {
                startActivity(this)
            }
        }
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