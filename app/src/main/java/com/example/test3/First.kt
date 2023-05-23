package com.example.test3

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.format.DateTimeFormatter

var operFiles = OperFiles()
var pierwszaZmienna1 = ""
var operFiless = operFiles.odczytajPierwszyPlik(pierwszaZmienna1)

var dataGlobal = ""
var localDateNow: LocalDate = LocalDate.now()

class First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        loguj("Początek")


        var iloscSztuk = 0
        val btnUstawienia: Button = findViewById(R.id.first_btn_settings)
        val btnStatystyki: Button = findViewById(R.id.first_btn_statsy)
        val imgBt: ImageButton = findViewById(R.id.imgBt)
        var txtIloscFajek: TextView = findViewById(R.id.first_txt_iloscSztuk)


        pobierzDate()
        //loguj("Początek 1")
        operFiles.stworzPierwszyPlik()
        //loguj("Początek 2")
        operFiles.createFileDate(localDateNow.toString())
        odczytPierwszej()
        operFiles.zmianaXnaY()
        //operFiles.createFileDate()

        odczytajDane()
        operFiles.porownajDatyNaPoczatek(localDateNow.toString())
        txtIloscFajek.setText(listaZczytana[0])
        operFiles.dodoajDoListyDateToDay(dataGlobal)



        btnUstawienia.setOnClickListener()
        {
            loguj("Z First na Ustawienia")
            startActivity(Intent(this, Ustawienia::class.java))
        }

        btnStatystyki.setOnClickListener()
        {
            loguj("Z First na Statystki")
            startActivity(Intent(this, Statystyki::class.java))
        }

        imgBt.setOnClickListener()
        {
            //loguj("dodałem fajke")
            var spalone3 = txtIloscFajek.text
           // loguj("Iles spalonych masz przed? : $spalone3")
            var spalone4 = Integer.parseInt(spalone3.toString())
           // loguj("Iles spalonych masz po? : $spalone3")
            spalone4++
           // loguj("Iles spalonych masz po? : $spalone4")
            operFiles.dodajDoListySpalone(spalone4.toString())
            txtIloscFajek.setText(spalone4.toString())
            iloscSztuk++
        }
    }

    fun pobierzDate() {
        //loguj("pobierz date: start")
        //loguj("pobierz date: dzisiaj data to: $localDateNow")

        var dataAktualna = findViewById<TextView>(R.id.first_txt_dzisiaj1)
        //loguj("pobierz date: 1")
        var formatters: DateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/uuuu")
        //loguj("pobierz date: 2")
        var text: String = localDateNow.format(formatters)
        //loguj("pobierz date: 3")
        var parsedDate: LocalDate = LocalDate.parse(text, formatters)
        dataAktualna.setText(parsedDate.toString())
        dataGlobal = parsedDate.toString()
        //loguj("Pobierz Datę. Data aktualna to: $dataGlobal")

//stworz plik z data dzisiaj jezeli nie ma

        //jezeli jest to go nadpisz

        //operFiles.dodoajDoListyDateToDay(dataGlobal)
        //loguj("pobierz date: end")
    }

    fun odczytajDane() {
        //loguj("odczytajDane: start")
        var txtIloscFajek: TextView = findViewById(R.id.first_txt_iloscSztuk)
        //loguj("odczytajDane: 1") //ok
        operFiles.odczytajDane()
        //loguj("odczytajDane: 1.1")
        val as10 = listaZczytana[0]
        val as11 = listaZczytana[1]
        val as12 = listaZczytana[2]
        val as13 = listaZczytana[3]

        txtIloscFajek.setText(as10)
        operFiles.dodajDoListySpalone((txtIloscFajek.text).toString())
        //loguj("odczytajDane: end")
    }

    fun odczytPierwszej() {


        pierwszaZmienna1 = operFiless.toString()
        //loguj("OdczytPierwsze: " + pierwszaZmienna1)

        sprawdzXY(pierwszaZmienna1)
    }

    fun sprawdzXY(pierwszaZmienna1: String) {
        //loguj("sprawdz XY: $pierwszaZmienna1")
        if (pierwszaZmienna1.equals("y")) {
            //loguj("Plik pierwszy zrobiony")



        } else {
            //loguj("Plik pierwszy NIE zrobiony")
            zrobPlikUstawienia()
        }

    }

    fun zrobPlikUstawienia() {
        //loguj("zrobPlikUstawienia: start")
        operFiles.dopiszCosNaStart()
        //loguj("zrobPlikUstawienia: start1")
        operFiles.zmianaXnaY()
        //loguj("zrobPlikUstawienia: start2")

        operFiles.dopiszCosNaStart1("0") //ilosc fajek
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1("0.0") // cena za paczke
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1("0")// ilosc w paczcze
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1(dataGlobal)
        operFiles.dopiszCosNaStart1("\n")
        //loguj("zrobPlikUstawienia: end")
    }

    private fun loguj(s: String) {
        Log.d("First", s)
    }
}