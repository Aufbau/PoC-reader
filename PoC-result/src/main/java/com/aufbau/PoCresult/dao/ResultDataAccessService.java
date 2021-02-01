package com.aufbau.PoCresult.dao;

import com.aufbau.PoCresult.models.Result;
import com.aufbau.PoCresult.service.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/*
   DAO accesses database for results.
   Calls VoteService which in turn gets the data from VoteRepository
 */

@Repository("Results")
public class ResultDataAccessService implements ResultDao {

    private final VoteService voteService;

    @Autowired
    public ResultDataAccessService(VoteService voteService) {
        this.voteService = voteService;
    }

    @Override
    public List<Result> getResult() {
        return voteService.countVotes();
    }
}
