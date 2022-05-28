package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Calendar;

public class AdminAddUser extends AppCompatActivity {

    private DatePickerDialog birthDatePicker;
    private Button dateButton;
    private String useBirthDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_adduser);
        //setup date of birth picker
        //code taken from (https://www.youtube.com/watch?v=qCoidM98zNk) thanks to "Code With Cal
        initDatePicker();
        dateButton = findViewById(R.id.datePickerButton);
        dateButton.setText(getTodaysDate());


    }

    private String getTodaysDate() {
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        month = month +1;
        int day = cal.get(Calendar.DAY_OF_MONTH);
        return makeDateString(day, month, year);
    }

    private void initDatePicker() {
        //set some cal stuff
        DatePickerDialog.OnDateSetListener dateSetListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                month = month +1;
                String date = makeDateString(day, month, year);
                dateButton.setText(date);
                useBirthDate = date;

            }
        };

        //get to days date
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //set theme
        int style = AlertDialog.THEME_HOLO_LIGHT;

        birthDatePicker = new DatePickerDialog(this, style,dateSetListener, year,month,day);
    }

    private String makeDateString(int day, int month, int year) {

        return day + " " + getMonthFormath(month)  + " " + year + " ";

    }

    private String getMonthFormath(int month) {
        if (month == 1)
            return "JAN";
        if (month == 2)
            return "FEB";
        if (month == 3)
            return "MAR";
        if (month == 4)
            return "APR";
        if (month == 5)
            return "MAY";
        if (month == 6)
            return "JUN";
        if (month == 7)
            return "JUL";
        if (month == 8)
            return "AUG";
        if (month == 9)
            return "SEP";
        if (month == 10)
            return "OCT";
        if (month == 11)
            return "NOV";
        if (month == 12)
            return "DEC";
        //we shouldnt hit this
        return "JAN";

    }

    public void openDatePicker(View view) {

        birthDatePicker.show();

    }
}