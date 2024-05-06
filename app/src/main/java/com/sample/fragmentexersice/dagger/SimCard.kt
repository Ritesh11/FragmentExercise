package com.sample.daggerexample

import javax.inject.Inject

class SimCard  @Inject constructor(private val serviceProvider: ServiceProvider){
    init {
        println("Sim Card Available")
    }

    fun getConnection(){
        serviceProvider.getServiceProvider()
    }
}