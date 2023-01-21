package com.example.mysampleminidaggerproject.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mysampleminidaggerproject.ui.adapter.AdapterUser
import com.example.mysampleminidaggerproject.ui.viewmodel.UserVM
import com.example.mysampleminidaggerproject.utils.Status
import com.example.templete.R
import com.example.templete.databinding.FragmentHomeBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FragmentHome : Fragment(), HasAndroidInjector {
    private lateinit var binding: FragmentHomeBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    private lateinit var userAdapter: AdapterUser
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)
    private val userViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[UserVM::class.java]
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        userAdapter = context?.let { AdapterUser(it) }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        binding.rclUsers.layoutManager = LinearLayoutManager(context)
        binding.rclUsers.adapter = userAdapter
        setupObserver()

        binding.swipRefreshLayout.setOnRefreshListener {
            setupObserver()
        }
        return binding.root
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    private fun setupObserver() {

        userViewModel.getUsersUsingFlow()?.observe(viewLifecycleOwner) {

            when (it.status) {
                Status.LOADING -> binding.prg.visibility = View.VISIBLE
                Status.SUCCESS -> {
                    binding.prg.visibility = View.GONE
                    if (binding.swipRefreshLayout.isRefreshing) {
                        binding.swipRefreshLayout.isRefreshing = false
                    }
                    it.data?.let { it1 -> userAdapter.initList(it1) }
                }

                Status.ERROR -> {
                    binding.prg.visibility = View.GONE
                    if (binding.swipRefreshLayout.isRefreshing) {
                        binding.swipRefreshLayout.isRefreshing = false
                    }
                    Toast.makeText(context, it.message, Toast.LENGTH_SHORT).show()
                }
            }

        }
    }
}
