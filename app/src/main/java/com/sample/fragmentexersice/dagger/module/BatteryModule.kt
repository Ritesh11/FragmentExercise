package com.sample.fragmentexersice.dagger.module

import com.sample.daggerexample.Battery
import com.sample.fragmentexersice.dagger.LithiumIonBattery
import dagger.Binds
import dagger.Module

@Module
abstract class BatteryModule {

    @Binds
    abstract fun providesLithiumIonBattery(lithiumIonBattery: LithiumIonBattery) : Battery


    /* This can also be done if you don't want a abstract Class
    @Provides
    fun providesLithiumIonBattery(lithiumIonBattery: LithiumIonBattery) : Battery{
        return lithiumIonBattery
    }*/

}