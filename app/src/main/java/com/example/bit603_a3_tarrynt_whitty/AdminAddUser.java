package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

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

        //get onscreen objects

        final TextView newUserName = findViewById(R.id.eTNewUserName);
        final TextView newPassword = findViewById(R.id.eTNewPassword);
        final TextView employeePhone = findViewById(R.id.eTphone);
        final TextView employeeNumber = findViewById(R.id.eTEmployeeNumber);
        final TextView address = findViewById(R.id.eTAddress);

        Button addUserToDB = findViewById(R.id.bAddNewUser);

        addUserToDB.setOnClickListener(view -> {
            //get strings from text boxes
            String usrname = newUserName.getText().toString();
            String pssWord = newPassword.getText().toString();
            String emplyPhone = employeePhone.getText().toString();
            String emplyNumber = employeeNumber.getText().toString();
            String emplyAddrss = address.getText().toString();

            //check if strings are empty
            boolean detailsentered = true;


            if(usrname.isEmpty())
                detailsentered = false;
            if(pssWord.isEmpty())
                detailsentered = false;
            if(emplyPhone.isEmpty())
                detailsentered = false;
            if(emplyNumber.isEmpty())
                detailsentered = false;
            if(emplyAddrss.isEmpty())
                detailsentered = false;
            //if no details were entered, error
            if (!detailsentered){
                dialogNotComplete();
            }

            else{
                //create new user
                //grab database from MainActivity and add the new user
                UserAccount newUser = new UserAccount(Integer.parseInt(emplyNumber), usrname, pssWord,useBirthDate, emplyPhone, emplyAddrss);
                MainActivity.database.accountDao().addUser(newUser);
                dialogComplete(usrname);
                //clear all text fields
                newUserName.setText("");
                newPassword.setText("");
                employeePhone.setText("");
                employeeNumber.setText("");
                address.setText("");
            }
        });


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
        DatePickerDialog.OnDateSetListener dateSetListener = (datePicker, year, month, day) -> {
            month = month +1;
            String date = makeDateString(day, month, year);
            dateButton.setText(date);
            useBirthDate = date;
        };

        //get to days date
        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        //set theme
        int style = AlertDialog.THEME_HOLO_LIGHT;

        birthDatePicker = new DatePickerDialog(this, style,dateSetListener, year,month,day);
        birthDatePicker.getDatePicker().setMaxDate(System.currentTimeMillis());
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

    private void dialogNotComplete() {
        // Instantiate
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(AdminAddUser.this);
        // Set characteristics
        builder.setMessage("not all information filled")
                .setTitle("Please try again");
        //add okay button
        builder.setPositiveButton("OK", (dialog, id) -> {
            // OK button was clicked
        });
        // Get AlertDialog
        androidx.appcompat.app.AlertDialog dialog = builder.create();

        // Show dialog
        dialog.show();
    }
    private void dialogComplete(String user) {
        // Instantiate
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(AdminAddUser.this);
        // Set characteristics
        builder.setMessage(user + " Added to database")
                .setTitle("User Added");
        //add okay button
        builder.setPositiveButton("OK", (dialog, id) -> {
            // OK button was clicked
        });
        // Get AlertDialog
        androidx.appcompat.app.AlertDialog dialog = builder.create();

        // Show dialog
        dialog.show();
    }
}