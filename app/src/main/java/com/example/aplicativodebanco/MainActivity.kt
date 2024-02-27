package com.example.aplicativodebanco

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    val COD_TELA = 2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun pix(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarPixActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == COD_TELA && resultCode == Activity.RESULT_OK) {
            val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
            val sSaldo = data!!.getStringExtra("sSaldo")
            txtSaldo.setText(sSaldo)
        }
    }

    fun pagar(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarPagamentoActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun transferir(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarTransfActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

    fun depositar(view: View) {
        val txtSaldo = findViewById<TextView>(R.id.txtSaldo)
        val saldo = txtSaldo.text.toString()
        val intent = Intent(this, MostrarDepositoActivity::class.java).apply {
            putExtra("sSaldo", saldo)
        }
        startActivityForResult(intent, COD_TELA)
    }

}