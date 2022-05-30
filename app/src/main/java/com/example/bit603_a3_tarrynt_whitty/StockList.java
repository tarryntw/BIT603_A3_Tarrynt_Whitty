package com.example.bit603_a3_tarrynt_whitty;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "STOCKLIST")
public class StockList {
    @PrimaryKey(autoGenerate = true)
    private int StockID;
    @ColumnInfo
    private String StockName;
    @ColumnInfo
    private int StockLevel;


    @ColumnInfo
    private String stockType;

    public StockList(String stockName, int stockLevel, String stockType) {
        StockName = stockName;
        StockLevel = stockLevel;
        this.stockType = stockType;
    }

    public StockList() {

    }


    public int getStockID() {
        return StockID;
    }

    public void setStockID(int stockID) {
        StockID = stockID;
    }

    public String getStockName() {
        return StockName;
    }

    public void setStockName(String stockName) {
        StockName = stockName;
    }

    public int getStockLevel() {
        return StockLevel;
    }

    public void setStockLevel(int stockLevel) {
        StockLevel = stockLevel;
    }

    public String getStockType() {
        return stockType;
    }

    public void setStockType(String stockType) {
        this.stockType = stockType;
    }
}
