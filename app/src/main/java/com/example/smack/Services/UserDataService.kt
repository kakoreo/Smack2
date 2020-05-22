package com.example.smack.Services

import android.graphics.Color
import java.util.*

object UserDataService {

    var id = ""
    var avatarColor = ""
    var avatarName = ""
    var name = ""
    var email = ""

    fun returnAvatarColor(rgbComponents: String) : Int {
        val strippedColor = rgbComponents
            .replace("[", "")
            .replace("]", "")
            .replace(",", "")

        var r = 0
        var g = 0
        var b = 0

        val scanner = Scanner(strippedColor)
        if (scanner.hasNext()) {
            r = (scanner.nextDouble() *255).toInt()
            g = (scanner.nextDouble() *255).toInt()
            b = (scanner.nextDouble() *255).toInt()
        }
        return Color.rgb(r, g, b)
    }

    fun logout() {
        id = ""
        name = ""
        avatarColor = ""
        avatarName = ""
        email = ""
        AuthService.authToken = ""
        AuthService.userEmail = ""
        AuthService.isLoggedIn = false
    }
}