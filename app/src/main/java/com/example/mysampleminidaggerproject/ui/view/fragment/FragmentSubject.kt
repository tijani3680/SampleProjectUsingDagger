package com.example.mysampleminidaggerproject.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import com.example.mysampleminidaggerproject.core.dataSource.dataStore.DataStoreHelper
import com.example.mysampleminidaggerproject.ui.adapter.AdapterSubject
import com.example.mysampleminidaggerproject.ui.viewmodel.SubjectVM
import com.example.mysampleminidaggerproject.utils.Status
import com.example.templete.R
import com.example.templete.databinding.FragmentSubjectBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

class FragmentSubject : Fragment(), HasAndroidInjector {
    private lateinit var binding: FragmentSubjectBinding
    private lateinit var subjectAdapter: AdapterSubject
    private lateinit var navController: NavController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    lateinit var dispatchingAndroidInjector: DispatchingAndroidInjector<Any>

    @Inject
    lateinit var dataStoreHelper: DataStoreHelper
    private val subjectViewModel by lazy {
        ViewModelProvider(this, viewModelFactory)[SubjectVM::class.java]
    }

    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        subjectAdapter = context?.let {
            AdapterSubject(it) {

                when (it.type) {
                    1 -> navController.navigate(R.id.action_fragmentSubject_to_fragmentDataStore)

                }

            }
        }!!
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_subject, container, false)
        binding.rclSubject.layoutManager = GridLayoutManager(context, 2)
//        binding.rclSubject.layoutManager = StaggeredGridLayoutManager(3,LinearLayoutManager.VERTICAL)
        binding.rclSubject.adapter = subjectAdapter
        setupObserver()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        AndroidSupportInjection.inject(this)
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)
    }

    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    private fun setupObserver() {
        subjectViewModel.getSubject()?.observe(viewLifecycleOwner) {
            if (it.status == Status.SUCCESS) {
                subjectAdapter.submitList(it.data)
            }
        }
    }
}
