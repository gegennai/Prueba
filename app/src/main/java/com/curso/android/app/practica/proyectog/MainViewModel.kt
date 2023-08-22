package com.curso.android.app.practica.proyectog

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.sql.Date

class MainViewModel() : ViewModel() {

    val comparacion: LiveData<Boolean> get()=_comparacion

    private var _comparacion = MutableLiveData<Boolean> (true)
    private var _textos = MutableLiveData<Textos>(Textos("",""))
    //var _comparacion = MutableLiveData<Boolean> (true)        // SOLO PARA TEST
    //var _textos = MutableLiveData<Textos>(Textos("",""))     // SOLO PARA TEST


    fun compararTextos() {
       val uno = (_textos.value?.texto1 ?: 0).toString()
       val dos = (_textos.value?.texto2 ?: 0).toString()
       _comparacion.value =  false
       if( uno==dos) _comparacion.value = true
    }

    fun update_texto1 (texto1: CharSequence){
        val x  =  (_textos.value?.texto2 ?: 0)
        _textos.value = Textos (texto1, x as CharSequence)
    }

    fun update_texto2 (texto2: CharSequence){
        val x  =  (_textos.value?.texto1 ?: 0)
        _textos.value = Textos (x as CharSequence, texto2)
    }

}