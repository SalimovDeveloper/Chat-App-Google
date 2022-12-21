package uz.salimovdeveloper.chatappgoogle.fragment.models

import java.io.Serializable

class Users : Serializable{
    var displayName: String = ""
    var imageLink: String = ""
    var uid:String = ""

    constructor()

    constructor(displayName: String, imageLink: String, uid: String) {
        this.displayName = displayName
        this.imageLink = imageLink
        this.uid = uid
    }

    override fun toString(): String {
        return "Users(displayName='$displayName', imageLink='$imageLink', uid='$uid')"
    }


}

