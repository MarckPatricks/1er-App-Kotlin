package com.example.tarea5

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // obteniendo referencias a las vistas desde el archivo XML
        val editText = findViewById<EditText>(R.id.editTextText)
        val textView = findViewById<TextView>(R.id.textView2)
        val botton = findViewById<Button>(R.id.button)
        val botonSalir = findViewById<Button>(R.id.botonSalir)

        // evento de click en el boton
        botton.setOnClickListener {
            // obteniendo el valor del editText
            val textoIngresado = editText.text.toString()

            if (textoIngresado.isNotEmpty()) {
                if(cadenaValida(textoIngresado)) {
                    textView.text = "Bienvenido $textoIngresado programador de Apps"
                    editText.text.clear()
                } else {
                    // mostrando mensaje de error si hay caracteres no permitidos
                    editText.error = "Ingresa un nombre valido"
                }
            } else {
                // mostrando mensaje de error si el campo esta vacio
                editText.error = "Ingresa un nombre"
            }

        }

        botonSalir.setOnClickListener {
            // saliendo de la aplicacion
            finish()
        }
    }
    private fun cadenaValida(cadena: String): Boolean {
        // validando que la cadena solo contenga mayusculas, minusculas y espacios
        val regex = Regex("^[A-Za-z\\s]*$")
        return regex.matches(cadena)
    }
}