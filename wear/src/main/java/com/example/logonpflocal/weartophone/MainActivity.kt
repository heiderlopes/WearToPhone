package com.example.logonpflocal.weartophone

import android.os.Bundle
import android.support.wearable.activity.WearableActivity
import com.google.android.gms.common.api.GoogleApiClient
import com.google.android.gms.wearable.Wearable
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : WearableActivity() {

    private lateinit var mGoogleApiClient: GoogleApiClient

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Enables Always-on
        setAmbientEnabled()

        mGoogleApiClient = GoogleApiClient.Builder(this)
                .addApi(Wearable.API)
                .build()

        mGoogleApiClient.connect()

        ivCalzabe.setOnClickListener {

            val nodes = Wearable.NodeApi.getConnectedNodes(mGoogleApiClient)
            nodes.setResultCallback { result ->
                val nodes = result.nodes
                nodes?.indices?.map { nodes[it] }?.forEach {
                    Wearable.MessageApi.sendMessage(mGoogleApiClient,
                            it.id,
                            "/CALZABE",
                            null)
                }
            }

        }
    }
}
