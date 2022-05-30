package com.example.bit603_a3_tarrynt_whitty;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class UserInventoryStatus extends AppCompatActivity {


    int index = 0;
    int currentPage= 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_inventory_status);

        //get onscreen object
        final TextView itemlist = findViewById(R.id.tStockList);
        Button nextitems = findViewById(R.id.bNext);
        Button previtems = findViewById(R.id.bPrev);

        //create a list of all our stock
        List<StockList> stock = MainActivity.database.stockDao().getstock();
        //get number of times in list
        int itemCount = stock.size();
        //work out the number of pages we will need
        int pages = itemCount / 5;
        currentPage= 0;
        index = 0;

        //check if we have no stock, print so and disable buttons
        if(itemCount == 0){
            itemlist.setText("No items in stock");
            previtems.setAlpha(.5f);
            previtems.setEnabled(false);
            nextitems.setAlpha(.5f);
            nextitems.setEnabled(false);
        }//if we have items do as normal
        else{
            //disable prev items as we are on page 1
            previtems.setAlpha(.5f);
            previtems.setEnabled(false);
            String outstring = "";
            //make our first page for string
            for(int i = index; i <= index + 4; i++){
                outstring = outstring + stock.get(i).getStockName() + " " + stock.get(i).getStockLevel() + " " + stock.get(i).getStockType() + "\n";
            }
            currentPage++;
            //add our page number to end
            outstring = outstring + "Page: " + currentPage + "/" + pages;




            //display first 5 entrys
            itemlist.setText(outstring);
        }


        previtems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //if index 0 do nothing
                if(index == 0){

                }//else display the next page
                else{
                    //update index
                    index = index - 5;
                    if(index <= 0){
                        index = 0;
                    }

                    String outstring = "";
                    //make our next page
                    for(int i = index; i <= index + 4; i++){
                        outstring = outstring + stock.get(i).getStockName() + " " + stock.get(i).getStockLevel() + " " + stock.get(i).getStockType() + "\n";
                    }

                    //add our page number to end
                    currentPage--;
                    if(currentPage <= 1){
                        currentPage = 1;
                    }

                    outstring = outstring + "Page: " + currentPage + "/" + pages;


                    //update text
                    itemlist.setText(outstring);

                    //check if on last page. if so disable this button
                    if(currentPage == 1 ){
                        previtems.setAlpha(.5f);
                        previtems.setEnabled(false);
                    }


                    //check on any page other then last, enable next button
                    if(currentPage != pages ){
                        nextitems.setAlpha(1f);
                        nextitems.setEnabled(true);
                    }
                }

            }
        });


        nextitems.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //if index too high do nothing
                if(index >= itemCount - 5){

                }//else display the next page
                else{
                    //update index
                    index = index + 5;

                    String outstring = "";
                    //make our next page
                    for(int i = index; i <= index + 4; i++){
                        outstring = outstring + stock.get(i).getStockName() + " " + stock.get(i).getStockLevel() + " " + stock.get(i).getStockType() + "\n";
                    }

                    //add our page number to end
                    currentPage++;

                    outstring = outstring + "Page: " + currentPage + "/" + pages;


                    //update text
                    itemlist.setText(outstring);

                    //check if on last page. if so disable this button
                    if(currentPage == pages ){
                        nextitems.setAlpha(.5f);
                        nextitems.setEnabled(false);
                    }

                }

                //if current page is not first page make prev button work
                if(currentPage != 1 ) {
                    previtems.setAlpha(1f);
                    previtems.setEnabled(true);
                }
            }
        });





    }
}