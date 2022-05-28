package com.example.bit603_a3_tarrynt_whitty;

import android.content.Context;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {UserAccount.class, StockList.class}, version = 2)
public abstract class CakesDatabase extends RoomDatabase {

    public abstract UserAccountDAO accountDao();
    public abstract StockListDAO stockDao();
}