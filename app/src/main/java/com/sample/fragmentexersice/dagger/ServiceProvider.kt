package com.sample.daggerexample

import javax.inject.Inject

class ServiceProvider  @Inject constructor() {
    init {
        println("Service Provider Constructed")
    }

    fun getServiceProvider(){
        println("Service provider connected")
    }
}