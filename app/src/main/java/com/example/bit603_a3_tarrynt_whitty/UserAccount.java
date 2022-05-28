package com.example.bit603_a3_tarrynt_whitty;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "USERACCOUNT")
public class UserAccount {
    @PrimaryKey(autoGenerate = false)
    private int employeeNumber;
    @ColumnInfo(name = "UserName")
    private String userName;
    @ColumnInfo(name = "PassWord")
    private String passWord;
    //might need to be replaced
    @ColumnInfo(name = "BirthDate")
    private String birthDay;
    @ColumnInfo(name = "PhoneNumber")
    private String phoneNumber;
    @ColumnInfo(name = "Address")
    private String address;


    //DOB setter and getter, might need replacing
    public String getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }


    //setters and getters

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
