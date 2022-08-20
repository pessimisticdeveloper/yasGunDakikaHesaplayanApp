package com.mucomarley.yashesaplama

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit
import java.util.concurrent.TimeUnit

class MainActivity : AppCompatActivity() {

    private var dTarih = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnTarih.setOnClickListener{
            tikla(it)
        }
    }
    fun tikla(view: View){
        DatePickerDialog(this,DatePickerDialog.OnDateSetListener { view, yil, ay, gun ->
            dTarih = "${yil}"+"/"+"${ay+1}"+"/"+"${gun}"
            var tarih = LocalDate.of(yil,ay+1,gun)
            val simdikiTarih = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
            val formatted = simdikiTarih.format(formatter)
            var fark = ChronoUnit.DAYS.between(tarih,simdikiTarih)
            gunSayi.setText(fark.toString()+" "+"Gündür Bu Boktan Dünyada Yaşıyorsun...")
            var yas = (fark / 365)
            yasid.setText("Ve"+" "+yas.toString()+"."+" "+"Yaşındasın...")
            var dakika = (TimeUnit.MINUTES.convert(fark,TimeUnit.DAYS))
            dakikaSayi.setText("Tebrikler"+" "+dakika.toString()+" "+"Dakikadır Hayattasın...")
        },2021,4,24).show()
    }
}