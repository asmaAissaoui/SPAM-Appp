package com.example.serie5exo3

import android.annotation.SuppressLint
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.ContactsContract
import android.provider.Telephony
import android.telephony.SmsManager
import android.widget.Button
import android.widget.Spinner
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("Range")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spamBtn = findViewById<Button>(R.id.spamBtn)
        spamBtn.setOnClickListener{
            val contacts = contentResolver.query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null, null)
            if(contacts != null){
                while (contacts.moveToNext()){
                    var objet = SmsManager.getDefault()
//                    objet.sendTextMessage(contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER)),null, "VOUS VENEZ DE VOUS FAIRE SPAMMER !", null, null)
                    println("${contacts.getString(contacts.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER))}")
                }
            }
            else{
                showToast("YOU ARE LONELY")

            }

        }



    }
    fun Context.showToast(text:CharSequence, duration: Int = Toast.LENGTH_SHORT){
        Toast.makeText(this,text,duration).show()
    }
}