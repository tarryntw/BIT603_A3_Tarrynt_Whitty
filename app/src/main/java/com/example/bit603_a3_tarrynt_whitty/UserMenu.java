package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.List;

public class UserMenu extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_menu);


        //get on screen objects
        Button inventoryStatus = findViewById(R.id.bInventoryStatus);
        Button addItem = findViewById(R.id.bAddItem);
        Button addTestItems = findViewById(R.id.bAddTest);
        Button clearTestItems = findViewById(R.id.bClearTest);

        //go to inventory screen
        inventoryStatus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent inventoryStatus = new Intent(getApplicationContext(), UserInventoryStatus.class);
                startActivity(inventoryStatus);
            }
        });

        //go to add item screen
        addItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addItemscreen = new Intent(getApplicationContext(), UserAddItem.class);
                startActivity(addItemscreen);
            }
        });

        //add test items
        addTestItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // add 20 items
                for(int i = 0; i < 20 ; i++){
                    StockList itemToAdd = new StockList("test item"+ (i + 1), 1,"other");
                    MainActivity.database.stockDao().addStock(itemToAdd);

                }
                dialog("Added Test Items", "Test Ran");
            }
        });
        //remove test items
        clearTestItems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //find all test items and remove them
                List<StockList> items = MainActivity.database.stockDao().getstock();
                //loop over all the stock and remove the test items
                for(StockList item : items){
                    if(item.getStockName().contains("test item")){
                        MainActivity.database.stockDao().delete(item);
                    }
                }
                //refresh the stock list for >reasons
                items = MainActivity.database.stockDao().getstock();
                dialog("Removed test items", "Test Ran");
            }
        });

    }




    private void dialog(String message, String title) {
        // Instantiate

        androidx.appcompat.app.AlertDialog.Builder builder = new androidx.appcompat.app.AlertDialog.Builder(UserMenu.this);
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