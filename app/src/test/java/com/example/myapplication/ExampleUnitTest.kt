package com.example.myapplication

import org.junit.Test

import org.junit.Assert.*
import com.example.myapplication.Calculadora
/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun testCalculadora() {
        val resultado:Double = 4.0
        val calculadora = Calculadora()
        val result:Double = calculadora.calcular(2.0,2.0,"+")
        assertEquals(resultado,result)
    }
}