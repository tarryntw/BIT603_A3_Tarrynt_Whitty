package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class AdminUserList extends AppCompatActivity {




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_user_list);


        //get onscreen object
        final ListView listview = findViewById(R.id.userList);

        //create a list of all our users
        List<UserAccount> users = MainActivity.database.accountDao().getAccounts();
        //create array with all the strings we wish to display
        final ArrayList<String> userlist = new ArrayList<>();
        for(UserAccount user : users) {
            userlist.add(user.getEmployeeNumber() + ": " + user.getUserName() + " " + user.getBirthDay());
        }
        //do some Adapter stuff for the list view
        ArrayAdapter<String> arr = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,userlist);
        listview.setAdapter(arr);



    }
}