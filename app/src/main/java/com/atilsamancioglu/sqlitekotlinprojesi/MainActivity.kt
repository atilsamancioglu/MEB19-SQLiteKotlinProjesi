package com.atilsamancioglu.sqlitekotlinprojesi

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // try - catch
        try {

            val veritabani = this.openOrCreateDatabase("Kullanici", Context.MODE_PRIVATE,null)
            veritabani.execSQL("CREATE TABLE IF NOT EXISTS kullanicilar (id INTEGER PRIMARY KEY, isim VARCHAR, yas INT)")
            //veritabani.execSQL("INSERT INTO kullanicilar (isim, yas) VALUES ('Atil', 33)")
            //veritabani.execSQL("INSERT INTO kullanicilar (isim, yas) VALUES ('Osman', 43)")
            //veritabani.execSQL("INSERT INTO kullanicilar (isim, yas) VALUES ('Mahmut', 53)")
            //veritabani.execSQL("INSERT INTO kullanicilar (isim, yas) VALUES ('Zeynep', 30)")

            //veritabani.execSQL("UPDATE kullanicilar SET yas = 44 WHERE isim = 'Osman'")
            //veritabani.execSQL("UPDATE kullanicilar SET isim = 'Mehmet' WHERE id = 3")

            //veritabani.execSQL("DELETE FROM kullanicilar WHERE isim = 'Mehmet'")

            //val cursor = veritabani.rawQuery("SELECT * FROM kullanicilar WHERE id = 4",null)
            val cursor = veritabani.rawQuery("SELECT * FROM kullanicilar WHERE isim LIKE '%p'",null)

            //val cursor = veritabani.rawQuery("SELECT * FROM kullanicilar",null)


            val idKolonIndex = cursor.getColumnIndex("id")
            val isimKolonIndex = cursor.getColumnIndex("isim")
            val yasKolonIndex = cursor.getColumnIndex("yas")

            while (cursor.moveToNext()){
                println("ID: " + cursor.getInt(idKolonIndex))
                println("Isim: " + cursor.getString(isimKolonIndex))
                println("Yas: " + cursor.getInt(yasKolonIndex))
            }

            cursor.close()

        } catch (e : Exception) {
            e.printStackTrace()
        }


    }
}