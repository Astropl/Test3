package com.example.test3

import android.annotation.SuppressLint
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
var listaZczytana = mutableListOf<String>()
var pierwszaZmienna1 = "x"
var operFiless = operFiles.odczytajPierwszyPlik(pierwszaZmienna1)

var dataGlobal = ""
var localDateNow: LocalDate = LocalDate.now()
var dzisiajDzienTygodnia = localDateNow.dayOfWeek.toString()
var asd = localDateNow.dayOfMonth
var spalone5 = ""


class First : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        loguj("Początek")
        loguj("Pokaz [ierwszy dzien tygodnia: $dzisiajDzienTygodnia")

stworzListeListaZczytana()
        var iloscSztuk = 0
        val btnUstawienia: Button = findViewById(R.id.first_btn_settings)
        val btnStatystyki: Button = findViewById(R.id.first_btn_statsy)
        val imgBt: ImageButton = findViewById(R.id.imgBt)
        var txtIloscFajek: TextView = findViewById(R.id.first_txt_iloscSztuk)
        spalone5 = txtIloscFajek.text.toString()
loguj("Początek 1")
        pobierzDate()
        //loguj("Początek 1")
        operFiles.stworzPierwszyPlik()
        loguj("Początek 2.0")
        operFiles.createFileDate(localDateNow.toString())
        loguj("Początek 2.01")
        odczytPierwszej()
        loguj("Początek 2.02")
        operFiles.zmianaXnaY()
        //operFiles.createFileDate()
        loguj("Początek 2")
        odczytajDane()
        loguj("Początek 22")
        operFiles.porownajDatyNaPoczatek(localDateNow.toString())
        loguj("Początek 23")
        txtIloscFajek.setText(listaZczytana[0])
        loguj("Początek 24")

        operFiles.dodoajDoListyDateToDay(dataGlobal)
        spalone5 = txtIloscFajek.text.toString()


        loguj("dzisiaj dzien tygodnia: localDateNow.dayOfWeek $dzisiajDzienTygodnia")
        loguj("dzisiaj jest: localDateNow.dayOfMonth $asd")

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
            loguj("dodałem fajke")
            var spalone3 = txtIloscFajek.text
            // loguj("Iles spalonych masz przed? : $spalone3")
            var spalone4 = Integer.parseInt(spalone3.toString())
            // loguj("Iles spalonych masz po? : $spalone3")
            spalone4++
            // loguj("Iles spalonych masz po? : $spalone4")
            operFiles.dodajDoListySpalone(spalone4.toString())
            txtIloscFajek.setText(spalone4.toString())
            iloscSztuk++
            spalone5 = spalone4.toString()
            loguj("Bitoon click : 1 : Spalone5 : $spalone5")
        }
    }

    fun stworzListeListaZczytana()

    {
        loguj ("stworzListeListaZczytana: Start")
        //
        for (abc in 0.. 4)
        {
            listaZczytana.add(abc.toString(), "0")
            //a++
        }

        loguj ("stworzListeListaZczytana: sprawdz liste")
        for (listaZczytanas in listaZczytana)
        {
            loguj("Element na : $listaZczytanas")
        }
        loguj ("stworzListeListaZczytana: end")
    }

    @SuppressLint("SuspiciousIndentation")
    fun pobierzSpalone(spalone511: String): String {
        loguj("pobierzSpalone : 1, z Ststsów idzie: $spalone511")
        //var TextView txtIloscFajek = (TextView) findViewById(R.id.first_txt_iloscSztuk)
        //var txtIloscFajek: TextView = findViewById(R.id.first_txt_iloscSztuk)
        //var txtIloscFajek1 = findViewById<TextView>(R.id.first_txt_iloscSztuk)
        //var spalone5 = findViewById<TextView>(R.id.first_txt_iloscSztuk)
        loguj("pobierzSpalone : 2")
        //var spalone5111 = txtIloscFajek1.text.toString()
        //spalone5 = txtIloscFajek1.text.toString()
        //var spalone511 = spalone5.text.toString()
        loguj("pobierzSpalone : 3")
        loguj(" A co tutuaj: $spalone5")
        loguj("pobierzSpalone : 4")
        return spalone5.toString()
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
        loguj("odczytajDane: start")
        var txtIloscFajek: TextView = findViewById(R.id.first_txt_iloscSztuk)
        //loguj("odczytajDane: 1") //ok
        operFiles.odczytajDane()
        loguj("odczytajDane: 1.1")
        val as10 = listaZczytana[0]
        loguj("odczytajDane: 1.1.1")
        //val as11 = listaZczytana[1]
        loguj("odczytajDane: 1.1.2")
        //val as12 = listaZczytana[2]
        //val as13 = listaZczytana[3]
        loguj("odczytajDane: 2.1")
        txtIloscFajek.setText(as10)
        loguj("odczytajDane: 1.3")
        operFiles.dodajDoListySpalone((txtIloscFajek.text).toString())
        loguj("odczytajDane: end")
    }

    fun odczytPierwszej() {
        loguj("odczytPierwszej: start")

        //pierwszaZmienna1 = operFiless.toString()
        //loguj("OdczytPierwsze: " + pierwszaZmienna1)
//TODO: Odczyt pierwszej zmiennej
        sprawdzXY(pierwszaZmienna1)
        loguj("odczytPierwszej: end")
    }

    fun sprawdzXY(pierwszaZmienna1: String) {
        loguj("sprawdz XY: $pierwszaZmienna1")
        if (pierwszaZmienna1.equals("y")) {
            loguj("Plik pierwszy zrobiony")

            loguj("sprawdz XY: 1")
            listaZczytana.add(0,"0")
            listaZczytana.add(1,"0.0")
            listaZczytana.add(2,"0")
            listaZczytana.add(2, dataGlobal)
            loguj("sprawdz XY: 1.1")
        } else {
            loguj("Plik pierwszy NIE zrobiony")
            zrobPlikUstawienia()
        }
        loguj("sprawdz XY: ebd")
    }

    fun zrobPlikUstawienia() {
        //loguj("zrobPlikUstawienia: start")
        operFiles.dopiszCosNaStart()
        //loguj("zrobPlikUstawienia: start1")
        operFiles.zmianaXnaY()
        //loguj("zrobPlikUstawienia: start2")

        operFiles.dopiszCosNaStart1("0") //ilosc fajek
        listaZczytana.add(0,"0")
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1("0.0") // cena za paczke
        listaZczytana.add(1,"0.0")
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1("0")// ilosc w paczcze
        listaZczytana.add(2,"0")
        operFiles.dopiszCosNaStart1("\n")
        operFiles.dopiszCosNaStart1(dataGlobal)
        listaZczytana.add(2, dataGlobal)
        operFiles.dopiszCosNaStart1("\n")
operFiles.zmianaXnaY()

        //loguj("zrobPlikUstawienia: end")
    }

    private fun loguj(s: String) {
        Log.d("First", s)
    }
}

private fun <E> MutableList<E>.add(a: E, element: E) {

}
