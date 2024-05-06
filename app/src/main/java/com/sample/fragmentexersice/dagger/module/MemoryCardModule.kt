package com.sample.fragmentexersice.dagger.module

import com.sample.daggerexample.MemoryCard
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule(var availableMemory: String) {

    @Provides
    fun providesMemoryCard(): MemoryCard{
        println("Available memory is $availableMemory KB")
        return MemoryCard()
    }
}