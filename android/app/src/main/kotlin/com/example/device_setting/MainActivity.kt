package com.example.device_setting

import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.plugin.common.MethodChannel
import java.lang.Error

class MainActivity: FlutterActivity() {
    private val channel: String = "com.device_setting/open_setting"

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    override fun configureFlutterEngine(flutterEngine: FlutterEngine) {
        super.configureFlutterEngine(flutterEngine)
        MethodChannel(
            flutterEngine.dartExecutor.binaryMessenger,
            channel
        ).setMethodCallHandler { call, result ->
            try {
                moveTaskToBack(true)
                openDeviceSetting(call.method)
            } catch (e: Error) {
                result.notImplemented()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP_MR1)
    private fun openDeviceSetting(requestName : String){
        val requestType = RequestName()
        when (requestName) {
            requestType.openNetworkSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_WIRELESS_SETTINGS))
            }
            requestType.openLocationSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS))
            }
            requestType.serviceName -> {
                startActivity(Intent(android.provider.Settings.ACTION_SETTINGS))
            }
            requestType.openBluetoothSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_BLUETOOTH_SETTINGS))
            }
            requestType.openSoundSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_SOUND_SETTINGS))
            }
            requestType.openBatterySetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_BATTERY_SAVER_SETTINGS))
            }
            requestType.openMemoryCardSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_MEMORY_CARD_SETTINGS))
            }
            requestType.openLockScreenSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_HOME_SETTINGS))
            }
            requestType.openPasswordSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_SECURITY_SETTINGS))
            }
            requestType.openHotspotSetting -> {
                val tetherSettings = Intent().apply {
                    setClassName("com.android.settings", "com.android.settings.TetherSettings")
                }
                startActivity(tetherSettings)
            }
            requestType.openDisplaySetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_DISPLAY_SETTINGS))
            }
            requestType.openWifiSetting -> {
                startActivity(Intent(android.provider.Settings.ACTION_WIFI_SETTINGS))
            }
        }
    }
}

class RequestName {
    val openNetworkSetting: String = "open_network_setting"
    val openLocationSetting: String = "open_location_setting"
    val serviceName: String = "open_device_setting"
    val openBluetoothSetting: String = "open_bluetooth_setting"
    val openSoundSetting: String = "open_sound_setting"
    val openBatterySetting: String = "open_battery_setting"
    val openMemoryCardSetting: String = "open_memory_card_setting"
    val openLockScreenSetting: String = "open_lock_screen_setting"
    val openPasswordSetting: String = "open_password_setting"
    val openHotspotSetting: String = "open_hotspot_setting"
    val openDisplaySetting: String = "open_display_setting"
    val  openWifiSetting: String = "open_wifi_setting"
}

