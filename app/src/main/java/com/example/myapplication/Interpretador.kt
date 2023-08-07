package com.example.myapplication

class Interpretador {

    fun esunNumero(caracter:Char):Boolean{
        when (caracter){
            '+','-','*','/','^','(',')' -> return false
            else -> return true
        }
    }

    fun interpretarEntrada (operacion:String,calculadora:Calculadora):Double{
        var operando = ""
        val stack = ArrayDeque<Double>()
        for (caracter in operacion){
            if (this.esunNumero(caracter) && caracter!= ' '){
                operando += caracter
            }
            else if (caracter == ' ' && operando != ""){ //si es un espacio vacio hacemos esto.

                stack.addLast(operando.toDouble())
                operando = "" //reiniciamos el operando
            }
            else if (!this.esunNumero(caracter) && caracter!= ' '){
                var operando1 = stack.removeLastOrNull()
                var operando2 = stack.removeLastOrNull()
                //realizamos la operacion correspondiente
                stack.addLast(calculadora.calcular(operando1!!.toDouble(),operando2!!.toDouble(),caracter))
            }


        }
        val calculado =stack.removeLastOrNull()!!
        calculadora.operationrecent(calculado)
        return calculado
    }
}