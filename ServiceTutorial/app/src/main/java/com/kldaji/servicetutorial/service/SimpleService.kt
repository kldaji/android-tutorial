package com.kldaji.servicetutorial.service

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import com.kldaji.servicetutorial.MainActivity

class SimpleService : Service() {

    companion object {
        private const val TAG = "SimpleService"
    }

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate()")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy()")
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        intent ?: return START_STICKY
        val input = intent.getStringExtra("input") ?: return START_STICKY
        Log.d(TAG, input)
        val activityIntent = Intent(this, MainActivity::class.java).apply {
            addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_SINGLE_TOP or Intent.FLAG_ACTIVITY_CLEAR_TOP)
            putExtra("input", "get from service")
        }
        startActivity(activityIntent)
        return super.onStartCommand(intent, flags, startId)
    }

    override fun onBind(intent: Intent): IBinder {
        throw UnsupportedOperationException("Not yet")
    }
}
