package com.example.mysampleminidaggerproject.ui.view.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.mysampleminidaggerproject.core.dataSource.dataStore.DataStoreHelper
import com.example.templete.R
import com.example.templete.databinding.FragmentDataStoreBinding
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import dagger.android.support.AndroidSupportInjection
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.collect
import javax.inject.Inject

class FragmentDataStore : Fragment(), HasAndroidInjector {
    private lateinit var binding: FragmentDataStoreBinding
    private val coroutineScope: CoroutineScope = CoroutineScope(Dispatchers.IO)


    @Inject
   lateinit var dispatchingAndroidInjector:DispatchingAndroidInjector<Any>

    @Inject
    lateinit var dataStoreHelper: DataStoreHelper


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        AndroidSupportInjection.inject(this)
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_data_store,container,false)

        binding.btnSaveDataStore.setOnClickListener {
            if (!binding.edtDatastoreValue.text.toString().isEmpty()){
                coroutineScope.launch {
                    dataStoreHelper.saveUserName(binding.edtDatastoreValue.text.toString())
                    withContext(Dispatchers.Main){
                        binding.edtDatastoreValue.setText("")
                    }
                }
            }


        }
        binding.btnReadeDataStore.setOnClickListener {
            coroutineScope.launch {
                dataStoreHelper.getUserName().collect {
                    withContext(Dispatchers.Main) {
                        binding.txtShowDataStore.text = it
                    }
//                    cancel()
                }
            }

        }

        binding.btnDeleteDataStore.setOnClickListener {
            coroutineScope.launch {
                dataStoreHelper.clearDataStore()
            }

        }
        return binding.root
    }


    override fun androidInjector(): AndroidInjector<Any> {
        return dispatchingAndroidInjector
    }

    override fun onDestroy() {
        super.onDestroy()
        if ( coroutineScope.isActive){
            coroutineScope.cancel()
        }
    }
}
