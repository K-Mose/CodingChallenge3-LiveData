package com.example.codingchallenge3_livedata

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.codingchallenge3_livedata.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainActivityViewModel
    private lateinit var viewModelFactory: MainActivityViewModelFactory
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MainActivity, R.layout.activity_main)
        viewModelFactory = MainActivityViewModelFactory(0)
        viewModel = ViewModelProvider(this, viewModelFactory ).get(MainActivityViewModel::class.java)
        /*
        Integrate ViewModel with DataBinding
        Live Data는 항상 activity, fragment, service의 lifecycle과 연관되기 떄문에
        observer를 쓰지 않고 layout에 binding 하게되면
        lifecycleOwner를 제공해야 한다.
        여기서는 lifecycleOwner에 MainActivity를 lifecycleOwner로 할당한다.
         */
        binding.lifecycleOwner = this
        binding.viewModel = viewModel
    }
}