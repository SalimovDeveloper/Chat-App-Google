package uz.salimovdeveloper.chatappgoogle.fragment.models

import android.annotation.SuppressLint
import java.text.SimpleDateFormat
import java.util.*

class MyMessage {
    var text:String=""
    var date:String=""
    var fromUid:String=""
    var toUid:String=""



    constructor(text: String, @SuppressLint("SimpleDateFormat") date: String = SimpleDateFormat("dd.MM.yyyy HH:mm").format(Date()), fromUid: String, toUid: String) {
        this.text = text
        this.date = date
        this.fromUid = fromUid
        this.toUid = toUid
    }

    constructor()

    override fun toString(): String {
        return "MyMessage(text='$text', date='$date', fromUid='$fromUid', toUid='$toUid')"
    }


}