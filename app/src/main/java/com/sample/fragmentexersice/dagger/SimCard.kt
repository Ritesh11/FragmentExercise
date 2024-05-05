package com.sample.daggerexample

import javax.inject.Inject

class SimCard  @Inject constructor(serviceProvider: ServiceProvider){
    init {
        println("Sim Card Available")
    }
}