package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class AdminMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);


        //get onscreen objects
        Button viewUsers = findViewById(R.id.bVeiwUsers);
        Button addUser = findViewById(R.id.bAddUser);
        Button removeUser = findViewById(R.id.bRemoveUser);

        addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addUserScreen = new Intent(getApplicationContext(), AdminAddUser.class);
                startActivity(addUserScreen);
            }
        });

    }
}