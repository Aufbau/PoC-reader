package com.aufbau.PoCresult.service;

import com.aufbau.PoCresult.dao.VoteRepository;
import com.aufbau.PoCresult.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/*
    VoteRepository (which is an interface) is auto implemented by Spring.
    That implementation provides the countVotes() function.
 */

@Service
public class VoteService {

    private final VoteRepository voteRepository;

    @Autowired
    public VoteService(VoteRepository voteRepository) {
        this.voteRepository = voteRepository;
    }

    public List<Result> countVotes() {

        /*
            VoteRepository.countVotes() return a List<Object[]>
            Object[0] is the String voteOption
            Object[1] is the Number countOfVoteOption

            List<Object[]> contains the Object[] for every vote option.
         */

        List<Object[]> lst = voteRepository.countVotes();

        List<Result> res = new ArrayList<>();

        for (Object[] o : lst) {
            Result r = new Result((String) o[0], ((Number) o[1]).intValue());
            res.add(r);
        }

        return res;
    }
}
