package com.example.test3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

var localDateNow1: LocalDate = LocalDate.now()
var godzina: LocalDateTime = LocalDateTime.now()
class OperDate : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oper_date)

        loguj("Początek")
        finish() // Zakończ activity


    }

    fun naStart() {
        loguj("na start: START")
        //loguj("Data to: $localDateNow1")

        loguj("na start: END")
    }

    fun pobierzGodzineIminuty(godzIMinute: String): String {

        loguj("na start: START")
        loguj("Godzina ze statystykto : $godzIMinute")
        loguj("Godzina to: $godzina")
        //========================\
        var formatters1: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss") //yyyy-MM-dd HH:mm:ss
        loguj("pobierzGodzineIminuty: 1")

        var textGodzina: String = godzina.format(formatters1)
       // godzIMinute = godzina.format(formatters1)
        loguj("pobierzGodzineIminuty: 2 : $textGodzina")

        //var parsedGodzina: LocalDateTime = LocalDateTime.parse(text, formatters1)
        loguj("pobierzGodzineIminuty: 3")
        //dataAktualna.setText(parsedDate.toString())
        //dataGlobal = parsedDate.toString()
        //loguj("Godzina sparsowana to: $parsedGodzina")
        //=======================\
//godzIMinute = text
        loguj("na start: END")
        return textGodzina
    }

    private fun loguj(s: String) {
        Log.d("OperDate", s)
    }
}