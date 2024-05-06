package com.sample.fragmentexersice

import android.app.Application
import com.sample.daggerexample.SmartPhone
import com.sample.fragmentexersice.dagger.component.DaggerSmartPhoneComponent
import com.sample.fragmentexersice.dagger.component.SmartPhoneComponent
import com.sample.fragmentexersice.dagger.module.MemoryCardModule
import javax.inject.Inject

class ExerciseApplication : Application() {

    lateinit var smartPhoneComponent: SmartPhoneComponent

    override fun onCreate() {
        super.onCreate()
        smartPhoneComponent = initDagger()
    }


    private fun initDagger(): SmartPhoneComponent =
        DaggerSmartPhoneComponent.builder().memoryCardModule(MemoryCardModule("1000"))
            .build()

}