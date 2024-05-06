package com.sample.fragmentexersice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sample.daggerexample.SmartPhone
import com.sample.fragmentexersice.dagger.component.DaggerSmartPhoneComponent
import com.sample.fragmentexersice.dagger.component.SmartPhoneComponent
import com.sample.fragmentexersice.databinding.ActivityMainBinding
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    @Inject
    lateinit var smartPhone: SmartPhone

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        DaggerSmartPhoneComponent.create().getSmartPhone().makeACallWithRecording()


        DaggerSmartPhoneComponent.create().inject(this)
        smartPhone.makeACallWithRecording()

    }
}