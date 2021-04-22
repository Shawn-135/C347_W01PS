package com.myapplicationdev.android.sgholidaysps;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class HolidayAdapter extends ArrayAdapter {

    private ArrayList<Holiday> holidays;
    private Context context;
    private TextView tvHolidayName;
    private ImageView ivNewYear;

    public HolidayAdapter(Context context, int resource, ArrayList<Holiday> objects) {
        super(context, resource, objects);
        holidays = objects;
        this.context = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.row, parent, false);
        tvHolidayName = (TextView) rowView.findViewById(R.id.tvHolidayName);
        tvHolidayDate = (TextView) rowView.findViewById(R.id.tvHolidayDate);
        ivNewYear = (ImageView) rowView.findViewById(R.id.ivNewYear);

        tvHolidayName.setText(currentHoliday.getName());
        if(currentHoliday.isNewYear()) {
            ivNewYear.setImageResource(R.drawable.new_year);
        }
        else {
            ivLabourDay.setImageResource(R.drawable.labour_day);
        }
        return rowView;
    }
}
