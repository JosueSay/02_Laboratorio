package com.example.calculadoradisenio

import kotlin.math.pow

class Calculadora {
    var operationRecently: Double = 0.0
    fun calcular(expre1: Double, expre2: Double,operador:Char): Double {
        var resultado = when (operador){
            '+' -> expre1+expre2
            '-' -> expre2-expre1
            '/' -> expre2/expre1
            '*' -> expre1*expre2
            '^' -> expre2.pow(expre1)
            '%' -> expre1%expre2
            else -> 0.0
        }

        return resultado
    }

    // Lo que hac3e esta funcion es guardar en el ultimo resultado
    fun operationrecent(ultimoResultado:Double){
        this.operationRecently = ultimoResultado
    }

    fun resultadoReciente ():Double{
        return this.operationRecently
    }



}