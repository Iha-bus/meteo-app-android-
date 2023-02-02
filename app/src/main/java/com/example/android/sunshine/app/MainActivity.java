package com.example.android.sunshine.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayList<String> forecastList = new ArrayList<>();
        private ArrayAdapter<String> adapter;
        private ListView listView;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

            forecastList.add("Mon 6/23 - Sunny - 31");
            forecastList.add("Tue 6/24 - Foggy - 21");
            forecastList.add( "Mon 6/23 - Sunny - 31/17");
            forecastList.add( "Tue 6/24 - Foggy - 21/8");
            forecastList.add( "Wed 6/25 - Cloudy - 22/17");
            forecastList.add( "Thurs 6/26 - Rainy - 18/11");
            forecastList.add( "Fri 6/27 -Foggy - 21/10");
            forecastList.add( "Sat 6/28 -TRAPPED IN WEATHERSTATION- 23/18");
            forecastList.add( "Sun 6/29 - Sunny - 20/7");

            adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, forecastList);
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            listView=  rootView.findViewById(R.id.listview_forecast);
             listView.setAdapter(adapter);
            return rootView;
        }
    }
}
