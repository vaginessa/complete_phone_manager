package com.bourgeois.sarah.phonemanager;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import ViewAdaptateur.MenuGenericView;


public class MainActivity extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MenuGenericView menu = new MenuGenericView();
        menu.test();
    }
/*
    @Override
    public boolean onOptionsItemSelected( MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
}

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case (R.id.id_menudevice) :
                Intent intent = new Intent(
                        MainActivity.this,
                        DeviceInfoActivity.class);
                startActivity(intent);
                break;

            case (R.id.id_menudashboard) :
                Toast.makeText(getApplicationContext(), "Accès au dashboard", Toast.LENGTH_LONG).show();
                break;

            case (R.id.id_menuram) :
                Toast.makeText(getApplicationContext(), "Accès au menu ram", Toast.LENGTH_LONG).show();
                break;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

*/
    /**
     * Init action listener for the navigaion bar
     */
    /*
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.id_navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }
    */
}
