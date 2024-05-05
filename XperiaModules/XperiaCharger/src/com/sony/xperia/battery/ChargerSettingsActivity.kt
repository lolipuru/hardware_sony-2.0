/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.sony.xperia.battery

import android.os.Bundle

import com.android.settingslib.collapsingtoolbar.CollapsingToolbarBaseActivity

class ChargerSettingsActivity : CollapsingToolbarBaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fragmentManager
                .beginTransaction()
                .replace(com.android.settingslib.collapsingtoolbar.R.id.content_frame, ChargerSettingsFragment(), TAG)
                .commit()
    }

    companion object {
        private const val TAG = "AdvancedChargerSettingsActivity"
    }
}