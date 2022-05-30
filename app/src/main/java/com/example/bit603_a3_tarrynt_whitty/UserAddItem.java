package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;

import org.w3c.dom.Text;

public class UserAddItem extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_add_item);

        // get on screen items
        final TextView itemToAdd = findViewById(R.id.eTItemtoadd);
        final TextView itemAmmountToAdd = findViewById(R.id.eTammounttoadd);
        RadioButton biscuit = findViewById(R.id.rBBiscuit);
        RadioButton cookie = findViewById(R.id.rBCookie);
        RadioButton cake = findViewById(R.id.rBCake);
        RadioButton ingredient = findViewById(R.id.rBIgredient);
        RadioButton other = findViewById(R.id.rBOther);
        Button addItem = findViewById(R.id.Badditemtodb);

        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //check if name empty
                if(itemToAdd.getText().toString().isEmpty()){
                    dialog("please enter item name", "Please try again");
                }
                else{
                    String itemBeingadded = itemToAdd.getText().toString();
                    //check if ammount empty
                    if(itemAmmountToAdd.getText().toString().isEmpty()){
                        dialog("Please enter ammount", "Please try again");
                    }
                    else{
                        int itemAmount = Integer.parseInt(itemAmmountToAdd.getText().toString());
                        //get type, if no type selected error
                        String itemtype = "";

                        boolean somethingSelected;

                        if(biscuit.isChecked()){
                            itemtype = "Biscuit";
                            somethingSelected = true;
                        }
                        else if(cookie.isChecked()){
                            itemtype = "Cookie";
                            somethingSelected = true;
                        }
                        else if(cake.isChecked()){
                            itemtype = "Cake";
                            somethingSelected = true;
                        }
                        else if(ingredient.isChecked()){
                            itemtype = "Ingredient";
                            somethingSelected = true;
                        }
                        else if(other.isChecked()){
                            itemtype = "Other";
                            somethingSelected = true;
                        }
                        else{
                            somethingSelected = false;
                        }

                        if(somethingSelected){
                            StockList item = new StockList(itemBeingadded, itemAmount, itemtype);
                            MainActivity.database.stockDao().addStock(item);
                            dialog(item.getStockName() +" Added", "Success");

                        }
                        else{
                            dialog("please select item type", "Please try again");
                        }

                    }

                }






            }
        });



    }

    private void dialog(String message, String title) {
        // Instantiate

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(UserAddItem.this);
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

}