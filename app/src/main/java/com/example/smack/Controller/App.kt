package com.example.smack.Controller

import android.app.Application
import com.example.smack.Utility.SharedPreferences

class App: Application() {

    companion object {
        lateinit var prefs: SharedPreferences
    }

    override fun onCreate() {
        prefs = SharedPreferences(applicationContext)
        super.onCreate()
    }
}