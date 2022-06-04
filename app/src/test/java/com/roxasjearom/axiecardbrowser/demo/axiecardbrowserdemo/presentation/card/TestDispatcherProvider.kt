package com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.presentation.card

import com.roxasjearom.axiecardbrowser.demo.axiecardbrowserdemo.utils.DispatcherProvider
import kotlinx.coroutines.CoroutineDispatcher

class TestDispatcherProvider(private val testDispatcher: CoroutineDispatcher) : DispatcherProvider {
    override val main: CoroutineDispatcher
        get() = testDispatcher
    override val io: CoroutineDispatcher
        get() = testDispatcher
    override val default: CoroutineDispatcher
        get() = testDispatcher
}
