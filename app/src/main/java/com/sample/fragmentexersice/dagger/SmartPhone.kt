package com.sample.daggerexample

import javax.inject.Inject

class SmartPhone @Inject constructor(battery: Battery,memoryCard: MemoryCard, simCard: SimCard){
    init {
        println("Assembling the Phone")
    }

    fun makeACallWithRecording() {
        println("Calling.....")
    }
}