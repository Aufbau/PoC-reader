package com.aufbau.PoCresult.dao;

import java.util.Hashtable;

/*
    Interface for a data access object. Has only one method as
    requirements indicate need to only read the tally of votes
    from database.
 */

public interface ResultDao {

    Hashtable<String, Integer> getResult();

}
