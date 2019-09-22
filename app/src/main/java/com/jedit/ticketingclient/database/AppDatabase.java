package com.jedit.ticketingclient.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.jedit.ticketingclient.interfaces.Ticket_DAO;
import com.jedit.ticketingclient.models.Passenger;

@Database(entities = {Passenger.class},exportSchema = false, version = 1)

public abstract class AppDatabase extends RoomDatabase {

    private static final String DB_NAME = "Ticket_DB";

    private static AppDatabase appDB_instance;

    public static AppDatabase getInstance(Context context){

        if (appDB_instance == null){

            appDB_instance = Room.databaseBuilder(context.getApplicationContext(),AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }

        return appDB_instance;
    }

    public abstract Ticket_DAO ticketDao();

}
