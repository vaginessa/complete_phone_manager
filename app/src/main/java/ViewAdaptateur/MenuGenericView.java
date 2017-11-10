package ViewAdaptateur;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Toast;
import com.bourgeois.sarah.phonemanager.DeviceInfoActivity;
import com.bourgeois.sarah.phonemanager.R;


/**
 * Created by SarahB on 17/10/2017.
 */

public class MenuGenericView extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private DrawerLayout mDrawerlayout;
    private ActionBarDrawerToggle mToogle;

    public void test() {
        mDrawerlayout = (DrawerLayout) findViewById(R.id.id_drawermain);
        mToogle = new ActionBarDrawerToggle(this, mDrawerlayout, R.string.open, R.string.close);
        mDrawerlayout.addDrawerListener(mToogle);
        mToogle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setNavigationViewListner(); // add action listener
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mToogle.onOptionsItemSelected(item)) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Activity activity = new Activity();

        switch (item.getItemId()) {
            case (R.id.id_menudevice) :
                Intent intent = new Intent(
                        activity,
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

    /**
     * Init action listener for the navigaion bar
     */
    private void setNavigationViewListner() {
        NavigationView navigationView = (NavigationView) findViewById(R.id.id_navigation);
        navigationView.setNavigationItemSelectedListener(this);
    }
}
