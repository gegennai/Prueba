package com.curso.android.app.practica.proyectog

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat.getSystemService
import androidx.core.widget.addTextChangedListener
import com.curso.android.app.practica.proyectog.databinding.MainlayoutBinding


class MainActivity : AppCompatActivity(){

    private lateinit var binding: MainlayoutBinding
    private val mainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainlayoutBinding.inflate(layoutInflater)
        setContentView(binding.root)

        mainViewModel.comparacion.observe(this){
            //println("nuevo valor de comparacion. $it")

            if(it as Boolean) binding.resultados.text = getString(R.string.textos_iguales )
            else  binding.resultados.text = getString(R.string.textos_no_iguales )
        }
        binding.botonComparar.setOnClickListener {
            mainViewModel.compararTextos()
        }

        binding.editTextText1.addTextChangedListener {
            mainViewModel.update_texto1(binding.editTextText1.text)
            println("nuevo valor de texto1")
            binding.resultados.text = getString(R.string.esperando_comparar )
        }

        binding.editTextText2.addTextChangedListener {
            mainViewModel.update_texto2(binding.editTextText2.text)
            println("nuevo valor de texto2")
            binding.resultados.text = getString(R.string.esperando_comparar )
        }



    }
}






