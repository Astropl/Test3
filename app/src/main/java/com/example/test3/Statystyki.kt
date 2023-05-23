package com.example.test3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode

var cenaZaSztukeWszystkie = 0.00
var cenaZaSztukeWszystkie1 =
    cenaZaSztukeWszystkie.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
var iloscSpalonychWszystkich =0

class Statystyki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statystyki)

        loguj("Początek")
        spaloneNonVisible()
        ileZaFajke()
        wyswietlStatystyki()
        operFiles.zsumujSpalone()
        loguj("Początek: po")

        val callback = findViewById<Button>(R.id.statystyki_btn_back)
        callback.setOnClickListener()
        {
            finish()
        }

        val btnSpalone = findViewById<Button>(R.id.statystyki_btn_spalone)
        btnSpalone.setOnClickListener()
        {

            spaloneVisible()

        }
        val btnKasa = findViewById<Button>(R.id.statystyki_btn_kasa)
        btnKasa.setOnClickListener()
        {
            spaloneNonVisible()
        }
        val btnNiewiem = findViewById<Button>(R.id.statystyki_btn_NIEWIEM)
        btnNiewiem.setOnClickListener()
        {
            spaloneNonVisible()
        }
    }

    private fun loguj(s: String) {
        Log.d("Statystyki", s)
    }

    fun wyswietlStatystyki() {
        var ustawTxt1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        var ustawTxt2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        loguj("wyswietlStatystyki: 1")
        operFiles.zsumujSpalone()
        loguj("wyswietlStatystyki: 2")
        ustawTxt1.setText("Spaliłem już za " + cenaZaSztukeWszystkie1)
        loguj("wyswietlStatystyki: 3")
        ustawTxt2.setText(iloscSpalonychWszystkich.toString())
        loguj("wyswietlStatystyki: 4")

        //skodo do operfiles.
        // wczytac wszytskie pliki i zsumowac wszytsko na pierwszej pozycji
        //zrzucić tutasj
        operFiles.zsumujWszystkieSpalone()
       var zmienna1 = operFiles.dodajZListyPlikow(iloscSpalonychWszystkich.toString())
        loguj("wyswietlStatystyki: zmienna1 to: $zmienna1")
        ustawTxt2.setText(zmienna1)

    }

    fun ileZaFajke() {
        //pobierz cene z pliku
        loguj("Ile za fajke: poczatek")
        operFiles.odczytajDane()
        var ilosc = listaZczytana[0].toInt()
        var cena = listaZczytana[1].toDouble()
        var sztukRazem = listaZczytana[2].toInt()
        var cenaZaSztuke = (cena / sztukRazem)
        loguj("Cena za sztuke to: $cenaZaSztuke")
        var cenaZaSztukeNaDzien = (cenaZaSztuke * ilosc)
        cenaZaSztukeWszystkie1 =
            ((cenaZaSztuke * ilosc).toBigDecimal().setScale(2, RoundingMode.UP).toDouble())
        loguj("Spaliłem już za: $cenaZaSztukeWszystkie1")
        //oblicz ile za jedna fajke

    }

    fun spaloneVisible() {
        val statystyki_txt_spaloneInfo = findViewById<TextView>(R.id.statystyki_txt_spaloneInfo)
        val statystyki_txt_spalone1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        val statystyki_txt_spalone2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        statystyki_txt_spaloneInfo.visibility = View.VISIBLE
        statystyki_txt_spalone1.visibility = View.VISIBLE
        statystyki_txt_spalone2.visibility = View.VISIBLE
    }

    fun spaloneNonVisible() {
        val statystyki_txt_spaloneInfo = findViewById<TextView>(R.id.statystyki_txt_spaloneInfo)
        val statystyki_txt_spalone1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        val statystyki_txt_spalone2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        statystyki_txt_spaloneInfo.visibility = View.INVISIBLE
        statystyki_txt_spalone1.visibility = View.INVISIBLE
        statystyki_txt_spalone2.visibility = View.INVISIBLE
    }
}
