package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class AdminRemoveUser extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_remove_user);



        //get on screen objects
        final TextView usrToRemove = findViewById(R.id.eTUserToRemove);
        Button removeUserButton = findViewById(R.id.bAdminRemoveUser);

        //set on click
        removeUserButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //check if input has been made
                String userName = usrToRemove.getText().toString();
                if(userName.isEmpty()){
                    dialogIssueFound("no username entered", "Please try again");
                }
                else{
                    //check if user exists
                    //get user list
                    List<UserAccount> users = MainActivity.database.accountDao().getAccounts();
                    UserAccount userToRemove = null;
                    boolean userNameExists = false;
                    for(UserAccount user : users){
                        if (user.getUserName().equals(userName)) {
                            userNameExists = true;
                            userToRemove = user;
                            break;
                        }
                        else
                            userNameExists = false;
                    }
                    //if does not exist error
                    if(!userNameExists){
                        dialogIssueFound("User does not exist", "Please try again");
                    }
                    else{
                        //santiy check, if user = null do nothign and throw error
                        //this shold not be hit and always go to else
                        if (userToRemove == null){
                            dialogIssueFound("user does not exists in database", "Please try again");
                        }
                        //remove user from db
                        else{
                            MainActivity.database.accountDao().delete(userToRemove);
                            dialogComplete(userName);
                        }

                    }



                }
            }
        });

    }





    private void dialogIssueFound(String message, String title) {
        // Instantiate

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(AdminRemoveUser.this);
        // Set characteristics
        builder.setMessage(message)
                .setTitle(title);
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
        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(AdminRemoveUser.this);
        // Set characteristics
        builder.setMessage(user + " Removed from database")
                .setTitle("User Removed");
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