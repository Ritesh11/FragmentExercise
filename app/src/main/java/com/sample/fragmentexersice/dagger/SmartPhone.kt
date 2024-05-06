package com.sample.daggerexample

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmartPhone @Inject constructor(battery: Battery,memoryCard: MemoryCard, simCard: SimCard){
    init {
        battery.getBatteryCharge()
        simCard.getConnection()
        memoryCard.factoryReset()
        println("Assembling the Phone")
    }

    fun makeACallWithRecording() {
        println("Calling.....")
    }
}