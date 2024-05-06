package com.sample.fragmentexersice.dagger

import com.sample.daggerexample.Battery
import javax.inject.Inject

class LithiumIonBattery @Inject constructor(): Battery {
    override fun getBatteryCharge() {
        println("Lithium Ion battery is 100% Charged")
    }
}