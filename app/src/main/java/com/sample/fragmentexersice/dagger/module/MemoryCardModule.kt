package com.sample.fragmentexersice.dagger.module

import com.sample.daggerexample.MemoryCard
import dagger.Module
import dagger.Provides

@Module
class MemoryCardModule {

    @Provides
    fun providesMemoryCard(): MemoryCard{
        return MemoryCard()
    }
}