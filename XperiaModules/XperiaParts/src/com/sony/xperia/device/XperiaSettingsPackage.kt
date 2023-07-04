/*
 * Copyright (C) 2022 The LineageOS Project
 * SPDX-License-Identifier: Apache-2.0
 */

package com.sony.xperia.device

import android.os.Bundle
import android.content.Intent
import android.content.pm.PackageManager
import androidx.preference.*
import androidx.core.content.pm.PackageInfoCompat
 
import com.sony.xperia.device.R
 
class XperiaSettingsPackage(private val fragment: PreferenceFragmentCompat) {
    private val pm = fragment.activity?.packageManager
    private val batteryPackageName = "com.sony.xperia.battery"
    private val batteryClassName = "com.sony.xperia.battery.ChargerSettingsActivity"
    private val displayPackageName = "com.sony.xperia.display"
    private val displayClassName = "com.sony.xperia.display.DisplaySettingsActivity"

    fun setupBatteryCareSettings() {
        try {
            val packageInfo = pm?.getPackageInfo(batteryPackageName, PackageManager.GET_ACTIVITIES)
            if (packageInfo != null && PackageInfoCompat.getLongVersionCode(packageInfo) >= 1) {
                // Package exists and has a version code greater than or equal to 1, set preference to visible
                fragment.findPreference<Preference>("advanced_charger_settings")?.isVisible = true
                val intent = Intent().apply {
                    setClassName(batteryPackageName, batteryClassName)
                }
                fragment.findPreference<Preference>("advanced_charger_settings")?.intent = intent
            } else {
                // Package does not exist or has a version code less than 1, set preference to hidden
                val category = fragment.findPreference<PreferenceCategory>("c")
                fragment.findPreference<Preference>("advanced_charger_settings")?.isVisible = false
                category?.isVisible = false
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Package does not exist, set preference to hidden
            val category = fragment.findPreference<PreferenceCategory>("c")
            fragment.findPreference<Preference>("advanced_charger_settings")?.isVisible = false
            category?.isVisible = false
        }
    }

    fun setupCreatorModeSettings() {
        try {
            val packageInfo = pm?.getPackageInfo(displayPackageName, PackageManager.GET_ACTIVITIES)
            if (packageInfo != null && PackageInfoCompat.getLongVersionCode(packageInfo) >= 1) {
                // Package exists and has a version code greater than or equal to 1, set preference to visible
                fragment.findPreference<Preference>("advanced_disp_settings")?.isVisible = true
                val intent = Intent().apply {
                    setClassName(displayPackageName, displayClassName)
                }
                fragment.findPreference<Preference>("advanced_disp_settings")?.intent = intent
            } else {
                // Package does not exist or has a version code less than 1, set preference to hidden
                val category = fragment.findPreference<PreferenceCategory>("d")
                fragment.findPreference<Preference>("advanced_disp_settings")?.isVisible = false
                category?.isVisible = false
            }
        } catch (e: PackageManager.NameNotFoundException) {
            // Package does not exist, set preference to hidden
            val category = fragment.findPreference<PreferenceCategory>("d")
            fragment.findPreference<Preference>("advanced_disp_settings")?.isVisible = false
            category?.isVisible = false
        }
    }
}