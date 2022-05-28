package com.example.bit603_a3_tarrynt_whitty;


import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@androidx.room.Dao
public interface UserAccountDAO {

    @Insert
    void addUser(UserAccount account);

    @Query("SELECT * FROM USERACCOUNT")
    List<UserAccount> getAccounts();

    @Delete
    void delete(UserAccount account);

    @Update
    void updateUsers(UserAccount account);

}
