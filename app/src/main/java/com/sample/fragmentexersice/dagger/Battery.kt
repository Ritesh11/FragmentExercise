package com.sample.daggerexample

import javax.inject.Inject

class Battery @Inject constructor(){
    init {
        println("Battery is 100% charged")
    }
}