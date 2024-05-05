package com.sample.daggerexample

import javax.inject.Inject

class MemoryCard{
    init {
        println("Memory Card Constructed")
    }

    fun factoryReset(){
        println("Factory Reset Done")
    }
}