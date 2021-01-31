package com.aufbau.PoCresult.dao;

import org.springframework.stereotype.Repository;

import java.util.Hashtable;

/*
   Fake DAO for testing.
   Uses a Hashtable which will always return the same value (for now).
 */

@Repository("fakeResults")
public class FakeResultDataAccessService implements ResultDao{

    private static Hashtable<String, Integer> fakeResult = new Hashtable<>();

    public FakeResultDataAccessService() {
        this.fakeResult.put("Mango", 5);
        this.fakeResult.put("Apple", 3);
    }

    @Override
    public Hashtable<String, Integer> getResult() {
        return fakeResult;
    }
}
