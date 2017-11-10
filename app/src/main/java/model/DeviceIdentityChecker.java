package model;

import android.content.Context;
import android.os.Build;
import android.telephony.TelephonyManager;
import com.bourgeois.sarah.phonemanager.R;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import bean.DeviceIdentity;

/**
 * Created by SarahB on 08/10/2017.
 */

public class DeviceIdentityChecker {

    private Context context;

    /**
     * retrieve Device info
     * @return
     */
    public DeviceIdentity initInfo() {
        DeviceIdentity deviceidentity = new DeviceIdentity();
        deviceidentity.setDeviceName(Build.DEVICE);
        deviceidentity.setModelName(Build.MODEL);
        deviceidentity.setDeviceBrand(Build.BRAND);
        deviceidentity.setSerialNumber(Build.SERIAL);
        deviceidentity.setDeviceID(Build.ID);
        deviceidentity.setDeviceManufacturer(Build.MANUFACTURER);
        deviceidentity.setHardware(Build.HARDWARE);
        deviceidentity.setFingerPrint(Build.FINGERPRINT);
        deviceidentity.setBootloader(getBootloader());
        return deviceidentity;
    }


    /**
     * Build map of device info
     * @param context
     * @return
     */
    public Map<String, String> buildDeviceInfo(Context context) {

        Map<String, String> map = new LinkedHashMap<>();

        map.put(context.getResources().getString(R.string.device), initInfo().getDeviceName());
        map.put(context.getResources().getString(R.string.modelName), initInfo().getModelName());
        map.put(context.getResources().getString(R.string.brand), initInfo().getDeviceBrand());
        map.put(context.getResources().getString(R.string.serialNumber), initInfo().getSerialNumber());
        map.put(context.getResources().getString(R.string.Id), initInfo().getDeviceID());
        map.put(context.getResources().getString(R.string.manufacturer), initInfo().getDeviceManufacturer());
        map.put(context.getResources().getString(R.string.fingerPrint), initInfo().getFingerPrint());
        map.put(context.getResources().getString(R.string.bootloader), initInfo().getBootloader());
       // map.put("IMEI", initInfo().getImeiNumber());
        return map;
    }


    /**
     * Get bootloader
     * @return
     */
    public String getBootloader() {
        String bootloader = Build.BOOTLOADER;
        if (bootloader.equals("unknown")) {
            return "no bootloader on this device";
        } else {
            return  bootloader;
        }
    }

    /**
     * Retrieve imei
     * @param context
     * @return
     */
    public  String getImei(Context context) {
        this.context = context;
        String imei = null;
        try {
            TelephonyManager telephonyManager = (TelephonyManager) this.context.getSystemService(Context.TELEPHONY_SERVICE);
            imei = telephonyManager.getDeviceId();
        }catch (Exception e) {
            imei = "Cannot retrieve your imei number";
            e.getMessage();
        }
      return  imei;
    }




}
