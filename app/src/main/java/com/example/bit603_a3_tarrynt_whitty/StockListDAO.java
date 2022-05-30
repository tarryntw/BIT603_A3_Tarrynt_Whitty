package com.example.bit603_a3_tarrynt_whitty;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@androidx.room.Dao
public interface StockListDAO {
    @Insert
    public void addStock(StockList stock);

    @Query("SELECT * FROM STOCKLIST")
    public List<StockList> getstock();

    @Delete
    void delete(StockList stock);

    @Update
    public void updateStock(StockList stock);
}
