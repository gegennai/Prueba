package com.curso.android.app.practica.proyectog

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
//import org.junit.jupiter.api.Assertions.*
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4::class)

//internal class MainActivityTest {
class MainActivityTest {

    @get: Rule
    var rule = ActivityScenarioRule(MainActivity::class.java)

//    @org.junit.jupiter.api.BeforeEach
    @Before
    fun setUp() {

    }


 //   @org.junit.jupiter.api.AfterEach
    @After
    fun tearDown() {
    }
/*
    @Test
    fun mainActivity_verResultado(){
        Espresso.onView(
            ViewMatchers.withId(R.id.resultados)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos SI son iguales")
            )
        )
    }


    @Test
    fun mainActiviy_texto1(){
        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText1)
        ).perform(
            ViewActions.typeText("aaa")
        )
    }

    @Test
    fun mainActiviy_texto2(){
        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.typeText("bbb")
        )
    }
*/

    @Test
    fun mainActivity_comparar(){

        Espresso.onView(
            ViewMatchers.withId(R.id.resultados)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos SI son iguales")
            )
        )


        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText1)
        ).perform(
            ViewActions.typeText("aaa")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.editTextText2)
        ).perform(
            ViewActions.typeText("bbb")
            //ViewActions.typeText("aaa")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.resultados)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Esperando para comparar")
            )
        )



        //Click en el boton
        Espresso.onView(
            ViewMatchers.withId(R.id.boton_comparar)
        ).perform(
            ViewActions.click()
        )
        //Verificacion del resultado
        Espresso.onView(
            ViewMatchers.withId(R.id.resultados)
            ).check(
                ViewAssertions.matches(
                    ViewMatchers.withText("Los textos NO son iguales")
                    //ViewMatchers.withText("Los textos SI son iguales")
                )
            )

    }

}