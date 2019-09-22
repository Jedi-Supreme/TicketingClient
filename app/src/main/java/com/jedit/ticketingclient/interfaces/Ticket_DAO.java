package com.jedit.ticketingclient.interfaces;

import androidx.room.Dao;
import androidx.room.Insert;

import com.jedit.ticketingclient.models.Passenger;

@Dao
public interface Ticket_DAO {

    @Insert()
    void add_Passenger(Passenger passenger);

}
