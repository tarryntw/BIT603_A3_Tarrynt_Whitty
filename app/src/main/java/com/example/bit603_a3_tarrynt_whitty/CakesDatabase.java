package com.example.bit603_a3_tarrynt_whitty;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {UserAccount.class,StockList.class}, version = 1)
public abstract class CakesDatabase extends RoomDatabase {

    public abstract UserAccountDAO accountDao();
    public abstract StockListDAO stockDao();



}
