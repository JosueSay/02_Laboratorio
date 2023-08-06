package com.example.myapplication

class Calculadora {

    fun sum(expre1: Double, expre2: Double,operador:String): Double {
        var resultado = when (operador){
            "+" -> expre1+expre2
            "-" -> expre1-expre2
            "/" -> expre1/expre2
            "*" -> expre1*expre2
            else -> 0.0
        }
        return resultado
    }


}