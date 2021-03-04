package com.lucidsoftworksllc.applicationblank.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.lucidsoftworksllc.applicationblank.R
import com.lucidsoftworksllc.applicationblank.base.ViewModelFactory
import com.lucidsoftworksllc.applicationblank.databinding.ActivityMainBinding
import com.lucidsoftworksllc.applicationblank.main_activity.repositories.MainActivityApi
import com.lucidsoftworksllc.applicationblank.main_activity.repositories.MainActivityRepository
import com.lucidsoftworksllc.applicationblank.main_activity.view_models.MainActivityViewModel
import com.lucidsoftworksllc.applicationblank.others.RemoteDataSource
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels {
        ViewModelFactory(MainActivityRepository(RemoteDataSource().buildApi(MainActivityApi::class.java)))
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        binding.goButton.setOnClickListener {
            val symbol = binding.symbolEdittext.text.toString().capitalize(Locale.ROOT)
            viewModel.getData(symbol)
        }
    }
}