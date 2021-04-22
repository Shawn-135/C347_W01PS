package com.myapplicationdev.android.sgholidaysps;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView lv;
    ArrayAdapter aa;
    ArrayList<Holiday> holiday;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lv = (ListView) this.findViewById(R.id.lvHolidays);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Holiday selectedHoliday = holiday.get(position);

                Toast.makeText(MainActivity.this, selectedHoliday.getName()
                                + " New Years Day Date: " + selectedHoliday.getDate(),
                        Toast.LENGTH_LONG).show();
            }
        });

        holiday = new ArrayList<Holiday>();
        holiday.add(new Holiday("New Year's Day", "1 Jan 2021"));
        holiday.add(new Holiday("Labour Day", "1 May 2021"));

        aa = new ArrayAdapter(this, R.layout.row, holiday);
        lv.setAdapter(aa);
    }
}
