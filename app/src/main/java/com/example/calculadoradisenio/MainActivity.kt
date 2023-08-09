package com.example.calculadoradisenio

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import java.lang.Exception

class MainActivity : AppCompatActivity() {
    var mostrar:String = ""
    val infix = InfixToPostfix()
    val interpreta = Interpretador()
    val calculadora = Calculadora()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main) //cambia el activity porfa

        // los botones estan identificados asi: [Boton]

        val Boton1:Button = findViewById(R.id.boton1) // [1]
        val Boton2:Button = findViewById(R.id.boton2) // [2]
        val Boton3:Button = findViewById(R.id.boton3) // [3]
        val Boton4:Button = findViewById(R.id.boton4) // [4]
        val Boton5:Button = findViewById(R.id.boton5) // [5]
        val Boton6:Button = findViewById(R.id.boton6) // [6]
        val Boton7:Button = findViewById(R.id.boton7) // [7]
        val Boton8:Button = findViewById(R.id.boton8) // [8]
        val Boton9:Button = findViewById(R.id.boton9) // [9]
        val Boton0:Button = findViewById(R.id.boton0) // [0]
        val BotonIG:Button = findViewById(R.id.botonigual) // [=]
        val BotonMas:Button = findViewById(R.id.botonmas) // [+]
        val BotonMenos:Button = findViewById(R.id.botonmenos) // [-]
        val BotonMulti:Button = findViewById(R.id.botonmultyplica) // [*]
        val BotonDiv:Button = findViewById(R.id.botondivide) // [/]
        val BotonEleva:Button = findViewById(R.id.botoneleva) // [^]
        val BotonCE:Button = findViewById(R.id.botonac) // [CE] Este es el boton que resetea
        val BotonMod:Button = findViewById(R.id.botonmodulo) // [%] Boton modulo
        val BotonPar1:Button = findViewById(R.id.botonparent1) // [(] Boton modulo
        val BotonPar2:Button = findViewById(R.id.botonparent2) // [)] Boton modulo
        val Pantalla:TextView = findViewById(R.id.mitextView) // Este es el textView que usaste para mostrar los resultados.
        Pantalla.setText("0")


        Boton1.setOnClickListener{
            this.actualizar(Pantalla,"1")
        }
        Boton2.setOnClickListener{
            this.actualizar(Pantalla,"2")
        }
        Boton3.setOnClickListener{
            this.actualizar(Pantalla,"3")
        }
        Boton4.setOnClickListener{
            this.actualizar(Pantalla,"4")
        }
        Boton5.setOnClickListener{
            this.actualizar(Pantalla,"5")
        }
        Boton6.setOnClickListener{
            this.actualizar(Pantalla,"6")
        }
        Boton7.setOnClickListener{
            this.actualizar(Pantalla,"7")
        }
        Boton8.setOnClickListener{
            this.actualizar(Pantalla,"8")
        }
        Boton9.setOnClickListener{
            this.actualizar(Pantalla,"9")
        }
        Boton0.setOnClickListener{
            this.actualizar(Pantalla,"0")
        }
        //realizamos las operaciones.
        BotonIG.setOnClickListener{
            try{
                var conversion = this.infix.infixtoPostfix(this.mostrar)
                this.mostrar = this.interpreta.interpretarEntrada(conversion,this.calculadora).toString()
                Pantalla.setText(mostrar)}
            catch (e:Exception){
                Pantalla.setText("Error de Syntaxis")
            }
        }
        BotonMas.setOnClickListener{
            this.actualizar(Pantalla,"+")
        }
        BotonMenos.setOnClickListener{
            this.actualizar(Pantalla,"-")
        }
        BotonMulti.setOnClickListener{
            this.actualizar(Pantalla,"*")
        }
        BotonDiv.setOnClickListener{
            this.actualizar(Pantalla,"/")
        }
        BotonEleva.setOnClickListener{
            this.actualizar(Pantalla,"^")
        }
        BotonCE.setOnClickListener{
            this.mostrar = ""
            Pantalla.setText("0")
        }
        BotonMod.setOnClickListener{
            this.actualizar(Pantalla,"%")
        }
        BotonPar1.setOnClickListener{
            this.actualizar(Pantalla,"(")
        }
        BotonPar2.setOnClickListener{
            this.actualizar(Pantalla,")")
        }


    }

    fun actualizar(pantalla:TextView,valormostrar:String){

        this.mostrar += valormostrar
        pantalla.setText(mostrar)
    }

    fun reiniciar(pantalla:TextView){
        this.mostrar = ""
        pantalla.setText("0")
    }


}