/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.sony.xperia.battery

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

import com.sony.xperia.battery.ChargerUtils
 
class BootCompletedReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        Log.d(TAG, "Starting")
        ChargerUtils(context).applyOnBoot()
    }
 
    companion object {
        private const val TAG = "XperiaParts"
    }
}