import 'package:device_setting/device_setting.dart';
import 'package:flutter/foundation.dart';
import 'package:flutter/services.dart';

String requestType({required SettingName settingName}) {
  String _returnType;
  switch (settingName) {
    case SettingName.mainSetting:
     _returnType = AppConstant.serviceName;
      break;
    case SettingName.bluetoothSetting:
      _returnType =  AppConstant.openBluetoothSetting;
      break;
    case SettingName.locationSetting:
      _returnType =  AppConstant.openLocationSetting;
      break;
    case SettingName.networkSetting:
      _returnType =  AppConstant.openNetworkSetting;
      break;
    case SettingName.soundSetting:
      _returnType =   AppConstant.openSoundSetting;
      break;
    case SettingName.batterySetting:
      _returnType =  AppConstant.openBatterySetting;
      break;
    case SettingName.displaySetting:
      _returnType =  AppConstant.openDisplaySetting;
      break;
    case SettingName.storageSetting:
      _returnType = AppConstant.openMemoryCardSetting;
      break;
    case SettingName.lockScreenSetting:
      _returnType = AppConstant.openLockScreenSetting;
      break;
    case SettingName.passwordSetting:
      _returnType = AppConstant.openPasswordSetting;
      break;
    case SettingName.hotspotSetting:
      _returnType = AppConstant.openHotspotSetting;
      break;
    case SettingName.wifiSetting:
      _returnType = AppConstant.openWifiSetting;
      break;
    default:
      _returnType =  AppConstant.serviceName;
      break;
  }
  return  _returnType;
}

/*Method Channel Call*/
Future<void> openDeviceSetting({required SettingName settingName }) async {
   const MethodChannel _platform = MethodChannel(AppConstant.methodChannelServiceName);
  try {
    final String value = requestType(settingName: settingName);
    await _platform.invokeMethod(value);
  } on PlatformException catch (e) {
    if(kDebugMode){
      print("Error ::: $e");
    }
    rethrow;
  }catch(e){
    rethrow;
  }
}