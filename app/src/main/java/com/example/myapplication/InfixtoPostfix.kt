package com.example.myapplication
import java.util.Stack
import kotlin.math.pow

class InfixToPostfix {
    fun esunNumero(caracter:Char):Boolean{
        when (caracter){
            '+','-','*','/','^','(',')' -> return false
            else -> return true
        }
    }

    fun precedencia (operador:Char):Int{
        var precedencia = 0
        precedencia = when (operador){
            '+' -> 1
            '-' -> 1
            '/' -> 2
            '*' -> 2
            '^' -> 3
            '%' -> 2
            else -> 0
        }
        return precedencia
    }

    fun infixtoPostfix (cadena:String):String{

        var postfix:String = ""
        val stack = ArrayDeque<Char>()

        for (caracter in cadena) {
            //si es un numero
            if (this.esunNumero(caracter)){
                postfix += caracter
            }
            else if (caracter == '('){
                stack.addLast(caracter)
            }
            else if (caracter == ')'){
                while ((!stack.isEmpty())&&(stack.last() != '(')){
                    postfix += " " + stack.removeLastOrNull()
                }
                stack.removeLastOrNull()
            }
            else {
                while ((!stack.isEmpty()) && (this.precedencia(caracter)<= this.precedencia(stack.last()!!))){
                   postfix += " ${stack.removeLastOrNull()}"
                }
                stack.addLast(caracter)
                postfix += " "
            }

        }

        postfix += " "
        while (!stack.isEmpty()){
            if (stack.last() == '('){
                return "Error de Syntaxis"
            }
            postfix += stack.removeLastOrNull()!! + " "
        }
        return postfix.trim()
    }



}



