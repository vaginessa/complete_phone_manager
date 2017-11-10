package ViewAdaptateur;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.bourgeois.sarah.phonemanager.R;
import java.util.ArrayList;
import java.util.Map;


/**
 * Created by SarahB on 11/10/2017.
 */
public class DeviceInfoViewAdaptator extends BaseAdapter {
    private final ArrayList mData;

    public DeviceInfoViewAdaptator(Map<String, String> map) {
        mData = new ArrayList();
        mData.addAll(map.entrySet());
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Map.Entry<String, String> getItem(int position) {
        return (Map.Entry) mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        // TODO implement you own logic with ID
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final View result;
        if (convertView == null) {
            result = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_deviceinfo, parent, false);

        } else {
            result = convertView;
        }
         Map.Entry<String, String> item = getItem(position);
        ((TextView) result.findViewById(android.R.id.text1)).setText(item.getKey());
        ((TextView) result.findViewById(android.R.id.text2)).setText(item.getValue());

        return result;
    }
}