package com.example.logonpflocal.weartophone

import android.app.IntentService
import android.content.Intent
import android.media.MediaPlayer

class HadoukenService : IntentService("HadoukenService") {
    override fun onHandleIntent(intent: Intent?) {
        val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.faustao)
        mediaPlayer.start()
    }
}
