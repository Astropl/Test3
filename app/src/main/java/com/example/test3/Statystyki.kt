package com.example.test3

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.math.RoundingMode


var first = First()
val operDate = OperDate()
var cenaZaSztukeWszystkie = 0.00
var cenaZaSztukeWszystkie1 =
    cenaZaSztukeWszystkie.toBigDecimal().setScale(2, RoundingMode.UP).toDouble()
var iloscSpalonychWszystkich = 0
var dayOfWeek = localDateNow.dayOfWeek.name
var dzienOfTygodnia =""

class Statystyki : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statystyki)

        //loguj("Początek")
        spaloneNonVisible()
        ileZaFajke()
        wyswietlStatystyki()
        operFiles.zsumujSpalone()

        statsySpalonePodsumowanie()
        //loguj("Początek: po")
operacjaNaDatach ()

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

    fun operacjaNaDatach ()
    {
        operDate.naStart()
    }

    fun statsySpalonePodsumowanie() {
        loguj("statsySpalonePodsumowanie: START")
        //spalone4
        var spalone5 = 0
        loguj("statsySpalonePodsumowanie:1")
        var statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        //loguj("statsySpalonePodsumowanie:2")
        var spalone4 = first.pobierzSpalone(spalone5.toString())
        //loguj("statsySpalonePodsumowanie:3 Spalone 4: $spalone4 .")
        statystyki_txt_dzisiajInfo1.setText(spalone4)
        loguj("statsySpalonePodsumowanie:4")
        // W tygodniu - lecimy na tygodniowe podsumowanie
        statsyTygodniowe()
    }

    fun statsyTygodniowe() {
        loguj("StatsyTygodniowe: START")
        loguj("DayOfMonth to: $dayOfWeek")

        when (dayOfWeek) {


                "MONDAY" ->
                {loguj("Poniedziałek")
            dzienOfTygodnia = "Poniedziałek"
            }
            "TUESDAY" -> {
                loguj("Wtorek")
                dzienOfTygodnia = "Wtorek"
            }
            "WEDNESDAY" -> {
                loguj("Środa")
                dzienOfTygodnia = "Środa"
            }
            "THURSDAY" -> {
                loguj("Czwartek")
                dzienOfTygodnia = "Czwartek"
            }
            "FRIDAY" -> {
                loguj("Piątek")
                dzienOfTygodnia = "Piątek"
            }
            "SATURDAY" -> {
                loguj("Sobota")
                dzienOfTygodnia = "Sobota"
            }
            "SUNDAY" -> {
                loguj("Niedziela")
                dzienOfTygodnia = "Niedziela"
            }

            else ->
                loguj("Zadne")
        }
//
//
//

        //Monday, Tuesday, Wednesday, Thursday, Friday, Saturday and Sunday

        loguj("dzisiaj jest: localDateNow.dayOfMonth $dayOfWeek")
        loguj("dzisiaj jest: dzien tygodnia $dzienOfTygodnia")
        //Plan: sprawdzic czy Monday. Jezeloi tak załozyć nowy plik tyogodniowy.
        //jezeli Monday to skopiwoac dane z pliku wekendowego, dodac do pliku miesiecznego, skasowac stary plik zrobvic nowy

    }

    fun wyswietlStatystyki() {
        var ustawTxt1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        var ustawTxt2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        //loguj("wyswietlStatystyki: 1")
        operFiles.zsumujSpalone()
        //loguj("wyswietlStatystyki: 2")
        ustawTxt1.setText("Spaliłem już za " + cenaZaSztukeWszystkie1)
        //loguj("wyswietlStatystyki: 3")
        ustawTxt2.setText(iloscSpalonychWszystkich.toString())
        //loguj("wyswietlStatystyki: 4")

        //skodo do operfiles.
        // wczytac wszytskie pliki i zsumowac wszytsko na pierwszej pozycji
        //zrzucić tutasj
        operFiles.zsumujWszystkieSpalone()
        var zmienna1 = operFiles.dodajZListyPlikow(iloscSpalonychWszystkich.toString())
        //loguj("wyswietlStatystyki: zmienna1 to: $zmienna1")
        ustawTxt2.setText(zmienna1)

    }

    fun ileZaFajke() {
        //pobierz cene z pliku
        //loguj("Ile za fajke: poczatek")
        operFiles.odczytajDane()
        var ilosc = listaZczytana[0].toInt()
        var cena = listaZczytana[1].toDouble()
        var sztukRazem = listaZczytana[2].toInt()
        var cenaZaSztuke = (cena / sztukRazem)
        //loguj("Cena za sztuke to: $cenaZaSztuke")
        var cenaZaSztukeNaDzien = (cenaZaSztuke * ilosc)
        cenaZaSztukeWszystkie1 =
            ((cenaZaSztuke * ilosc).toBigDecimal().setScale(2, RoundingMode.UP).toDouble())
        //loguj("Spaliłem już za: $cenaZaSztukeWszystkie1")
        //oblicz ile za jedna fajke

    }

    fun spaloneVisible() {
        val statystyki_txt_spaloneInfo = findViewById<TextView>(R.id.statystyki_txt_spaloneInfo)
        val statystyki_txt_spalone1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        val statystyki_txt_spalone2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        val statystyki_txt_dzisiajInfo = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo)
        val statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        val statystyki_txt_tydzienInfo = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo)
        val statystyki_txt_tydzienInfo1 = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        val statystyki_txt_miesiacInfo = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo)
        val statystyki_txt_miesiacInfo1 = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        val statystyki_txt_wszystkieInfo = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo)
        val statystyki_txt_wszystkieInfo1 =
            findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        statystyki_txt_spaloneInfo.visibility = View.VISIBLE
        statystyki_txt_spalone1.visibility = View.VISIBLE
        statystyki_txt_spalone2.visibility = View.VISIBLE
        statystyki_txt_dzisiajInfo.visibility = View.VISIBLE
        statystyki_txt_dzisiajInfo1.visibility = View.VISIBLE
        statystyki_txt_tydzienInfo.visibility = View.VISIBLE
        statystyki_txt_tydzienInfo1.visibility = View.VISIBLE
        statystyki_txt_miesiacInfo.visibility = View.VISIBLE
        statystyki_txt_miesiacInfo1.visibility = View.VISIBLE
        statystyki_txt_wszystkieInfo.visibility = View.VISIBLE
        statystyki_txt_wszystkieInfo1.visibility = View.VISIBLE
    }

    fun spaloneNonVisible() {
        val statystyki_txt_spaloneInfo = findViewById<TextView>(R.id.statystyki_txt_spaloneInfo)
        val statystyki_txt_spalone1 = findViewById<TextView>(R.id.statystyki_txt_spalone1)
        val statystyki_txt_spalone2 = findViewById<TextView>(R.id.statystyki_txt_spalone2)
        val statystyki_txt_dzisiajInfo = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo)
        val statystyki_txt_dzisiajInfo1 = findViewById<TextView>(R.id.statystyki_txt_dzisiajInfo1)
        val statystyki_txt_tydzienInfo = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo)
        val statystyki_txt_tydzienInfo1 = findViewById<TextView>(R.id.statystyki_txt_tydzienInfo1)
        val statystyki_txt_miesiacInfo = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo)
        val statystyki_txt_miesiacInfo1 = findViewById<TextView>(R.id.statystyki_txt_miesiacInfo1)
        val statystyki_txt_wszystkieInfo = findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo)
        val statystyki_txt_wszystkieInfo1 =
            findViewById<TextView>(R.id.statystyki_txt_wszystkieInfo1)
        statystyki_txt_spaloneInfo.visibility = View.INVISIBLE
        statystyki_txt_spalone1.visibility = View.INVISIBLE
        statystyki_txt_spalone2.visibility = View.INVISIBLE
        statystyki_txt_dzisiajInfo.visibility = View.INVISIBLE
        statystyki_txt_dzisiajInfo1.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo.visibility = View.INVISIBLE
        statystyki_txt_tydzienInfo1.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo.visibility = View.INVISIBLE
        statystyki_txt_miesiacInfo1.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo.visibility = View.INVISIBLE
        statystyki_txt_wszystkieInfo1.visibility = View.INVISIBLE


    }
}
