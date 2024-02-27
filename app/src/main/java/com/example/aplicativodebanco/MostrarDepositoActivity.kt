package com.example.aplicativodebanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MostrarDepositoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mostrar_deposito)
        setSupportActionBar(findViewById(R.id.tooldeposito))
        val saldo = intent.getStringExtra("sSaldo")
        var nsaldo = saldo.toString().toDouble()
        val btdepositar = findViewById<Button>(R.id.btdeposito)
        val edtdeposito = findViewById<EditText>(R.id.edtdeposito)
        btdepositar.setOnClickListener {
            val data = Intent()
            val edtdeposito = findViewById<EditText>(R.id.edtdeposito)
            var nvalor = edtdeposito.text.toString().toDouble()
            nsaldo += nvalor
            val txtSaldo = nsaldo.toString()
            data.putExtra("sSaldo", txtSaldo)
            setResult(Activity.RESULT_OK,data)
            Toast.makeText(this, "Depósito realizado com sucesso",Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "$nsaldo", Toast.LENGTH_SHORT).show()
            edtdeposito.setText("".toString())

            finish()
        }
    }
}