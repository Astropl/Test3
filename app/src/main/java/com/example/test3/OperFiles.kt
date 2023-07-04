package com.example.test3

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import java.io.*

var wp = File("/data/data/com.example.test3/files/")
var filenameFirst = "firstSetup.txt"
var outputFile1 = File(wp, filenameFirst)


//var listaZczytana = mutableListOf<String>()
var listaSpalonych = mutableListOf<String>()
var dodoajDoListyLogiPliki = mutableListOf<String>()

var wpFileName1 = File("/data/data/com.example.test3/files/firstSetup.txt")

var fileNameDate = "dateLog.txt"

var wp1 = File("/data/data/com.example.test3/files/daty")
var wpFileName = File("/data/data/com.example.test3/files/as1.txt")
var wpFileName2 = File("/data/data/com.example.test3/files/daty/asy1.txt")
var filename = "as1.txt"
var godzIMinute = ""

class OperFiles : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oper_files)

        loguj("Początek")
        finish() // Zakończ activity
    }

    fun createFileDate(localDateNow: String) {
        loguj("createFileDate: start")
        val plikDzienny = (localDateNow + ".txt")
        //val outputFile2 = File(wp1, fileNameDate)
        val outputFile2 = File(wp1, plikDzienny)

        try {
            if (!wp1.exists()) {
                wp1.mkdir()
            }
            if (!outputFile2.exists()) {
                val fos =
                    FileOutputStream(outputFile2)//loguj("stworzPierwszyPlik::sprujbjue tutaj dodac dane do pliku")
                wpFileName2.appendText(localDateNow.toString())//loguj("stworzPierwszyPlik:: Tworzy plik jezeli nie ma")
                wpFileName2.appendText("\n")
            }

        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }
         loguj("createFileDate: end")
    }

    fun stworzPierwszyPlik() {

        //loguj("Stwórz pierwszy plik: start")
        try {
            // create a File object for the parent directory
            // have the object build the directory structure, if needed.
            if (!wp.exists()) {
                wp.mkdir() //loguj("stworzPierwszyPlik::Tworze nowy katalog jezelio brakuje")
            }
            if (!outputFile1.exists()) {
                val fos =
                    FileOutputStream(outputFile1)//loguj("stworzPierwszyPlik::sprujbjue tutaj dodac dane do pliku")
                wpFileName1.appendText("x")//loguj("stworzPierwszyPlik:: Tworzy plik jezeli nie ma")

            }
            //********8tutaj się robi plik?
            //loguj(outputFile1.toString())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        //loguj("Stwórz pierwszy plik: end")
    }

    fun dodoajDoListyDateToDay(dataGlobal: String) {
        //loguj("dodoajDoListyDateToDay: start")
        //loguj("dodoajDoListyDateToDay: data przeszla? $dataGlobal")
        listaZczytana.set(3, dataGlobal)
        //loguj("dodoajDoListyDateToDay: end")

    }

    fun dodajDoListySpalone(spalone: String) {
        //listaZczytana.add(0, spalone)
        listaZczytana.set(0, spalone)
        //loguj("Dodaj do Listy spoalone: ++ : $spalone")
        zapiszNowaListe()
    }

    fun zsumujSpalone() {
        //listaspalonych
       // loguj("zsumujSpalone::odczyt")

        listaSpalonych.clear()
        var a3 = 0
        var line3: String?
        try {
            BufferedReader(FileReader(wpFileName2)).use { br ->
                while (br.readLine().also { line3 = it } != null) {
                    //println(line2)
                   //loguj("zsumujSpalone: $line3")

                    dodoajDoListySpalonych(line3.toString(), a3)
                    a3++
//
                }
//
            }
//
        } catch (e: IOException) {
            e.printStackTrace()
        }

        var iloscWpisowWliscieDnia = listaSpalonych.size
        //loguj("odczytajPierwszyPlik: rozmiar listy spalonych : $iloscWpisowWliscieDnia")
        for (listaSpalonychs in listaSpalonych) {
            loguj(listaSpalonychs)
        }
        //loguj("odczytajPierwszyPlik: end")
    }

    fun dodajZListyPlikow(iloscSpalonychWszystkich: String): String {
        //wczytac liste z nazwami dni
        //odczytac z inch wszytskie na pozycji 1
        //dodoac do siebie
        //wp1 - katalog z data
        //loguj("dodajZListyPlikow: Start")
        listaZczytana.clear()
        var b = 0
        var a = 0
        var line2: String?
       // loguj("dodajZListyPlikow: 1")
        for (listaSpalonychs in listaSpalonych) {
           // loguj("dodajZListyPlikow: 2")
            val listaSpalonychs1 = listaSpalonychs + ".txt"
            //loguj("dodajZListyPlikow: 3")
            val wp11 = File(wp1, listaSpalonychs1)//
            try {
                //loguj("dodajZListyPlikow: 4")
                BufferedReader(FileReader(wp11)).use { br ->
                    while (br.readLine().also { line2 = it } != null) {


                        try {
                            val line3: Int = line2.toString().toInt()

                            if (a == 0) {

                                b = (b + (line3))

                                a++
                            }else if (a >= 3){
                                a = 0

                            } else {

                                a++

                            }


                        } catch (nfe: NumberFormatException) {
                            //loguj("dodajZListyPlikow: ${line2.toString()} Nie zparsowane: ")
                            a++
                            if(a>=3)
                            {
                                a=0
                            }
                        }


                    }
                }
            } catch (e: IOException) {
                e.printStackTrace()
            }
        }
        //val iloscSpalonychWszystkich = b.toString()
        return b.toString()
    }

    fun dodoajDoListySpalonych(element1: String, a1: Int) {
        //loguj("dodoajDoListy::wskoczyłem dodaj do listy. poraz $a1")
       // loguj("dodoajDoListy::element1 równa sie:  $element1")
        //listaSpalonych.add(a1, element1)
        listaSpalonych.add(a1, element1)
       // loguj("dodoajDoListy::koniec dodaj do listy")
    }

    fun dodajDoListyUstawienia(cenaZaPaczke: String, iloscSztuk: String) {
        listaZczytana.set(1, cenaZaPaczke)
        listaZczytana.set(2, iloscSztuk)
        zapiszNowaListe()
    }

    fun porownajDatyNaPoczatek(localDateNow: String) {
        loguj("porownajDatyNaPoczatek: start")
        loguj("porownajDatyNaPoczatek: listaZczytana[3] dlugosc ${listaZczytana.size}")
        loguj("porownajDatyNaPoczatek: listaZczytana[3] ${listaZczytana.elementAt(0)}")
        var a =0
        for (listaZczytanas in listaZczytana) {
            loguj ("Listz z indexem : $a zawiera ${listaZczytana.elementAt(a)}")
        }
        val wczorajsza = listaZczytana[3]

        loguj("porownajDatyNaPoczatek: Data dzisiaj to: $localDateNow\n")
        loguj("porownajDatyNaPoczatek: Data zczytana to: $wczorajsza")
        // porównac date z dzisiaj lokalna i ostania zapisaną.
        if (localDateNow != wczorajsza) {
             loguj("Rózni się. wykasuj licznik fajek na dziś")
            listaZczytana.set(0, "0")
        } else {
            loguj(" Nie rózni się. nic nie rób")
        }
    }

    fun zapiszNowaListe() {
        //loguj("dodajOdczytane::dodoaje odczytaną listę i zapisuje")

        val plikDzienny = (localDateNow.toString() + ".txt")

        val outputFile2 = File(wp1, plikDzienny)

        (wpFileName).writeText("")
        (outputFile2).writeText("")

        for (listaZczytanas in listaZczytana) {
            //println("$listaZczytanas - Number of characters: ${listaZczytanas.length}")
            (wpFileName).appendText(listaZczytanas)
            //pobierz godzine
            operDate.pobierzGodzineIminuty(godzIMinute)
            (wpFileName).appendText("\n")
//pobierz godzine

            (outputFile2).appendText(listaZczytanas)

            (outputFile2).appendText("\n")

        }
    }

    private fun loguj(s: String) {
        Log.d("Operfiles", s)
    }

    fun zmianaXnaY() {
        loguj("zmianaXnaY: start")
        wpFileName1.writeText("")
        wpFileName1.writeText("y")
         loguj("zmianaXnaY: zmienione na y")
    }

    fun dodoajDoListy(element: String, a: Int) {

        listaZczytana.add(a, element)

    }

    fun odczytajDane() {
        //loguj("odczytajDane::odczyt")
        listaZczytana.clear()
        var a = 0
        var line2: String?
        try {
            BufferedReader(FileReader(wpFileName)).use { br ->

                while (br.readLine().also { line2 = it } != null) {

                    dodoajDoListy(line2.toString(), a)
                    a++

                }

            }

        } catch (e: IOException) {
            e.printStackTrace()
        }

    }

    fun odczytajPierwszyPlik(pierwszaZmienna: String): String {

        //loguj("odczytajPierwszyPlik::odczyt")

        try {
            BufferedReader(FileReader(wpFileName1)).use { br ->
                var line1: String?
                while (br.readLine().also { line1 = it } != null) {
                    println(line1)
                    pierwszaZmienna1 = line1.toString()
                    //loguj("odczytajPierwszyPlik: 1,  $pierwszaZmienna1")
                }
                //loguj("odczytajPierwszyPlik: 2,  $pierwszaZmienna1")
            }
            //loguj("odczytajPierwszyPlik: 3,  $pierwszaZmienna1")
        } catch (e: IOException) {
            e.printStackTrace()
        }

        //loguj("odczytajPierwszyPlik: $pierwszaZmienna1")
        return pierwszaZmienna1
    }

    fun dopiszCosNaStart() {

        //loguj("stworzKatalog::Stwórz katalog1")
        val outputFile = File(wp, filename)

        try {
            // create a File object for the parent directory
            // have the object build the directory structure, if needed.
            if (!wp.exists()) {
                wp.mkdir()
                //loguj("dodaj::Tworze nowy katalog jezelio brakuje")
            }
//
            if (!outputFile.exists()) {
                val fos = FileOutputStream(outputFile)

                //loguj("dodaj::sprujbjue tutaj dodac dane do pliku")


                //checkIsFileExist = 1
                //loguj("dodaj:: Tworzy plik jezeli nie ma")
            }

            //********8tutaj się robi plik?
            //loguj(outputFile.toString())
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        //loguj("stworzKatalog::katalog stworzony w " + outputFile.toString())
//TODO $dates$ dgfdsgsf
    }

    fun zsumujWszystkieSpalone() {
        //asy1.txt
       // loguj("odczytajDane::odczyt")
        dodoajDoListyLogiPliki.clear()
        var a5 = 0
        var line4: String?
        try {
            BufferedReader(FileReader(wpFileName2)).use { br ->

                while (br.readLine().also { line4 = it } != null) {
                    //println(line2)
                    //loguj("Odczytaj linie: fdhgdhghfgj")

                    zsumujWszystkieSpaloneDodaj(line4.toString())
                    a5++
                    //loguj("odczytajPierwszyPlik: 1,  $line2")
                    //loguj("odczytajPierwszyPlik, linia: 1,  $a")
                }
                //loguj("odczytajPierwszyPlik: 2,  $line2")
            }
            //loguj("odczytajPierwszyPlik: 3,  $line2")f
        } catch (e: IOException) {
            e.printStackTrace()
        }
        //loguj("odczytajPierwszyPlik: $line2")
    }

    fun zsumujWszystkieSpaloneDodaj(spalone: String) {
        //listaZczytana.add(0, spalone)
        //dodoajDoListyLogiPliki.set(0, spalone)
        dodoajDoListyLogiPliki.add(spalone)
        //loguj("Dodaj do Listy spoalone: ++ : $spalone")
        //zapiszNowaListe()
    }

    fun dopiszCosNaStart1(test: String) {
        try {
            //loguj("dopiszCosNaStart1::dodjaj2")
            //loguj("abradakaka : $test,: $wpFileName")
            wpFileName.appendText(test)
            // wpFileName.appendText(test)
            //loguj("dopiszCosNaStart::dodjaje na start dane do pliku")
        } catch (e: FileNotFoundException) {
            e.printStackTrace()
        }

        //loguj("dopiszCosNaStart::koniec dodaj2")
    }
}

