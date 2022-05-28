package com.example.bit603_a3_tarrynt_whitty;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "CakeMainActivity";
    public static CakesDatabase database;

    private static final String ADMINUSER = "Admin";
    private static final String ADMINPASSWORD = "CookieManagement84";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        database = Room.databaseBuilder(getApplicationContext(), CakesDatabase.class, "CakeDB").allowMainThreadQueries().build();


        final TextView userNameText = findViewById(R.id.eTUserName);
        final TextView passwordText = findViewById(R.id.eTPassword);
        Button logInButton = findViewById(R.id.bLogIn);

        logInButton.setOnClickListener(view -> {
            //First check if admin, we want to break normal code flow if admin
            String inputUserName = userNameText.getText().toString();
            String inputPassword = passwordText.getText().toString();
            boolean isAdminLogg = isAdmin(inputUserName, inputPassword);

            Log.d(TAG, "userName: " + inputUserName);
            Log.d(TAG, "passWord: " + inputPassword);

            if (isAdminLogg){
                Toast.makeText(getBaseContext(),"Confirmed Admin", Toast.LENGTH_SHORT).show();
                //go to admin screens
                Intent adminMenu = new Intent(getApplicationContext(), AdminMenu.class);
                startActivity(adminMenu);

            }
            else{
                //check if user exists
                boolean userExists = isAccount(database, inputUserName, inputPassword);

                //if so log in
                if(userExists){
                    Intent Menu = new Intent(getApplicationContext(), Menu.class);
                    startActivity(Menu);
                }
                else{
                    dialogIncorrectUser();
                }
            }
        });
    }

    @Override
    public void onResume(){
        super.onResume();
        final TextView userNameText = findViewById(R.id.eTUserName);
        final TextView passwordText = findViewById(R.id.eTPassword);
        userNameText.setText("");
        passwordText.setText("");

    }


    public static boolean isAdmin(String user, String pass){


        if (user.equals(ADMINUSER)){
            return pass.equals(ADMINPASSWORD);

        }
        else{
            return false;
        }
    }
    public static boolean isAccount(CakesDatabase db, String user, String pass){
        List<UserAccount> Accounts = db.accountDao().getAccounts();
        boolean anyCorrect = false;
        for (UserAccount account : Accounts) {
            if (user.equals(account.getUserName())){
                if(pass.equals(account.getPassWord())){
                    anyCorrect = true;
                    break;
                }
            }
        }

        return anyCorrect;
    }


    private void dialogIncorrectUser() {
        // Instantiate
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // Set characteristics
        builder.setMessage("Please Try again")
                .setTitle("Incorrect Information");
        //add okay button
        builder.setPositiveButton("OK", (dialog, id) -> {
            // OK button was clicked
        });
        // Get AlertDialog
        AlertDialog dialog = builder.create();

        // Show dialog
        dialog.show();
    }




}