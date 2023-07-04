/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.sony.xperia.device

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log
 
class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Starting")
    }
 
    companion object {
        private const val TAG = "XperiaParts"
    }
}