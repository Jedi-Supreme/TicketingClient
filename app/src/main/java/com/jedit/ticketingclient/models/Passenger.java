package com.jedit.ticketingclient.models;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = Passenger.TABLE, indices = {@Index(value = Passenger.COLUMN_FIRE_ID, unique = true)})

public class Passenger {

    public static final String TABLE = "PASSENGER";
    public static final String COLUMN_FIRE_ID = "firebase_id";
    public static final String COLUMN_FIRSTNAME = "firstname";
    public static final String COLUMN_LASTNAME = "lastname";
    public static final String COLUMN_PHONE_NUMBER = "phone_number";
    public static final String COLUMN_EMAIL = "email";


    @PrimaryKey(autoGenerate = true)
    private int id;

    @NonNull
    @ColumnInfo(name = COLUMN_FIRE_ID)
    private String fireBase_id;

    @ColumnInfo(name = COLUMN_FIRSTNAME)
    private String firstName;

    @ColumnInfo(name = COLUMN_LASTNAME)
    private String lastName;

    @ColumnInfo(name = COLUMN_PHONE_NUMBER)
    private String phone_number;

    @ColumnInfo(name = COLUMN_EMAIL)
    private String email;

    public Passenger(@NonNull String fireBase_id, String firstName, String lastName, String phone_number, String email) {
        this.fireBase_id = fireBase_id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.email = email;
    }

    @NonNull
    public String getFireBase_id() {
        return fireBase_id;
    }

    public void setFireBase_id(@NonNull String fireBase_id) {
        this.fireBase_id = fireBase_id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
