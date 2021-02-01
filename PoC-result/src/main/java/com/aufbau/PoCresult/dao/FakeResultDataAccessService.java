package com.aufbau.PoCresult.dao;

import com.aufbau.PoCresult.models.Result;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

/*
   Fake DAO for testing.
   Uses a List of Result which will always return the same value (for now).
 */

@Repository("fakeResults")
public class FakeResultDataAccessService implements ResultDao {

    private static final List<Result> fakeResults = new ArrayList<>();

    public FakeResultDataAccessService() {
        fakeResults.add(new Result("Apple", 3));
        fakeResults.add(new Result("Mango", 5));
    }

    @Override
    public List<Result> getResult() {
        return fakeResults;
    }
}
