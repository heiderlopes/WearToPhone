package com.example.logonpflocal.weartophone

import android.content.Intent
import android.media.MediaPlayer
import android.util.Log
import com.google.android.gms.wearable.MessageEvent
import com.google.android.gms.wearable.WearableListenerService

class DataLayerListenerService : WearableListenerService() {


    override fun onMessageReceived(p0: MessageEvent?) {
        super.onMessageReceived(p0)
        when(p0?.path) {
            "/CALZABE" -> {
                Log.i("WEAR", "BOTAO CLICADO")
                //startService(Intent(this, HadoukenService::class.java))
                val mediaPlayer = MediaPlayer.create(applicationContext, R.raw.risada_calzabe)
                mediaPlayer.start()
            }
        }
    }
}