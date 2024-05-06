package com.sample.fragmentexersice.dagger.component

import com.sample.daggerexample.SmartPhone
import com.sample.fragmentexersice.MainActivity
import com.sample.fragmentexersice.dagger.module.BatteryModule
import com.sample.fragmentexersice.dagger.module.MemoryCardModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MemoryCardModule::class, BatteryModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone

    fun inject(mainActivity: MainActivity)
}