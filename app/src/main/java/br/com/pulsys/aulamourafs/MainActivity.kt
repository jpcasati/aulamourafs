package br.com.pulsys.aulamourafs

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore

class MainActivity : AppCompatActivity() {

    val db = Firebase.firestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botaoSalvar = findViewById<Button>(R.id.btnSalvar)

        botaoSalvar.setOnClickListener {

            val dados = hashMapOf(
                "nome" to findViewById<EditText>(R.id.edtNome).text.toString(),
                "idade" to findViewById<EditText>(R.id.edtIdade).text.toString(),
                "email" to findViewById<EditText>(R.id.edtEmail).text.toString(),
                "cidade" to findViewById<EditText>(R.id.edtCidade).text.toString()
            )

            db.collection("teste").add(dados).addOnSuccessListener { documentReference ->
                Toast.makeText(this, "Adicionado: ${documentReference.id}", Toast.LENGTH_LONG).show()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Erro!", Toast.LENGTH_LONG).show()
                }

        }

    }
}