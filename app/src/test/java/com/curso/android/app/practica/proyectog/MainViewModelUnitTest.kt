package com.curso.android.app.practica.proyectog

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.advanceUntilIdle
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule


@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)

class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        var value = viewModel.comparacion.value ?: false
        assertTrue(value)
    }

    @Test
    fun mainViewModel_update_texto1() = runTest {
        viewModel.update_texto1("aaa")
        viewModel.update_texto2("bbb")
        val txt = viewModel._textos                 //el test requiere que _textos sea publica
        val x1  =  (txt.value?.texto1 ?: "")
        assertTrue("aaa"== x1 )
    }

    @Test
    fun mainViewModel_update_texto2() = runTest {
        viewModel.update_texto1("aaa")
        viewModel.update_texto2("bbb")
        val txt = viewModel._textos                 //el test requiere que _textos sea publica
        val x1  =  (txt.value?.texto2 ?: "")
        assertTrue("bbb"== x1 )
    }

    @Test
    fun mainViewModel_comparar() = runTest {
        viewModel.update_texto1("aaa")
        //viewModel.update_texto2("bbb")
        viewModel.update_texto2("aaa")
        launch {  viewModel.compararTextos() }

        advanceUntilIdle()
        val value = (viewModel.comparacion.value )

        //assertEquals(false, value )
        assertEquals(true, value )
    }

}

