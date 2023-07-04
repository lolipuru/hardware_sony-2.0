/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.sony.xperia.device

import android.os.Bundle
import androidx.preference.*
import android.content.pm.PackageManager

import com.sony.xperia.device.R
import com.sony.xperia.device.XperiaSettingsPackage

class XperiaSettingsFragment : PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.preferences_xperia_menu, rootKey)

        val xperiaSettingsPackage = XperiaSettingsPackage(this)
        xperiaSettingsPackage.setupBatteryCareSettings()
        xperiaSettingsPackage.setupCreatorModeSettings()
    }
}