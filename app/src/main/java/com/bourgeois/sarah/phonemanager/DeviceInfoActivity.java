package com.bourgeois.sarah.phonemanager;

import android.app.ListActivity;
import android.os.Bundle;
import java.util.Map;
import ViewAdaptateur.DeviceInfoViewAdaptator;
import model.DeviceIdentityChecker;


/**
 * Display device general information with a listview
 */
public class DeviceInfoActivity extends ListActivity {

    DeviceIdentityChecker info = new DeviceIdentityChecker();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Map<String, String > map = info.buildDeviceInfo(this);
        map.put(this.getResources().getString(R.string.imei),info.getImei(this));

        // add custom view adaptator and add list into the view
        DeviceInfoViewAdaptator adapter = new DeviceInfoViewAdaptator(map);
        setListAdapter(adapter);

        //TODO : organiser les item comme je veux dans la map. Ca ne s'affiche pas dans un ordre pertinent


    }


}
