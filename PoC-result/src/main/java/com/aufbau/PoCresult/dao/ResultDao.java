package com.aufbau.PoCresult.dao;

import com.aufbau.PoCresult.models.Result;

import java.util.List;

/*
    Interface for a data access object. Has only one method as
    requirements indicate need to only read the tally of votes
    from database.
 */

public interface ResultDao {

    List<Result> getResult();

}
