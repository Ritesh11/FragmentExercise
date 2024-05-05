package com.sample.fragmentexersice.dagger.component

import com.sample.daggerexample.SmartPhone
import com.sample.fragmentexersice.dagger.module.MemoryCardModule
import dagger.Component

@Component(modules = [MemoryCardModule::class])
interface SmartPhoneComponent {
    fun getSmartPhone(): SmartPhone
}