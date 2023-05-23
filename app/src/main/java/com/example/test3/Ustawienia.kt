package com.example.test3

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class Ustawienia : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_ustawienia)

        loguj("Początek")


        odczytDoUstawien()

        val callback_ustawienia = findViewById<Button>(R.id.ustawienia_btn_back)
        callback_ustawienia.setOnClickListener()
        {
            finish()
        }

        val btnUstawienia: Button = findViewById(R.id.ustawienia_btn_save)
        btnUstawienia.setOnClickListener()
        {
            loguj("ZAPIS")
            var cenaZaPaczke = findViewById<EditText>(R.id.ustawienia_txt_cenaZaPaczke)
            var cenaZaPaczke1 = cenaZaPaczke.text
            var iloscSztuk = findViewById<EditText>(R.id.ustawienia_txt_iloscWPaczce)
            var iloscSztuk1 = iloscSztuk.text

            loguj("Zapisuje ustawienia.")
            loguj(" Ile wynosi cena za paczke: $cenaZaPaczke1")
            loguj(" Ile wynosi cena za paczke: $iloscSztuk1")
            operFiles.dodajDoListyUstawienia(cenaZaPaczke1.toString(), iloscSztuk1.toString())
            loguj("Koniec Zapisanych.")
// okno dialogowe
            val builder = AlertDialog.Builder(this)
            builder.setTitle("INFORMACJA")
            builder.setMessage("Dane zostały zapisane")
            builder.setPositiveButton(android.R.string.ok) { dialog, which ->
                Toast.makeText(
                    applicationContext,
                    android.R.string.ok, Toast.LENGTH_SHORT
                ).show()
            }
            builder.show()
        }
    }

    fun odczytDoUstawien() {
        //var zmienna0 = listaZczytana[0]
        var zmienna1 = listaZczytana[1]
        loguj("Pokaz element listy 1: " + listaZczytana[1])
        var zmienna2 = listaZczytana[2]
        loguj("Pokaz element listy 2: " + listaZczytana[2])
        //var zmienna3 = listaZczytana[3]
        var cenaZaPaczke = findViewById<EditText>(R.id.ustawienia_txt_cenaZaPaczke)
        cenaZaPaczke.setText(zmienna1)
        var iloscSztuk = findViewById<EditText>(R.id.ustawienia_txt_iloscWPaczce)
        iloscSztuk.setText(zmienna2)

    }

    private fun loguj(s: String) {
        Log.d("Ustawienia", s)

    }
}