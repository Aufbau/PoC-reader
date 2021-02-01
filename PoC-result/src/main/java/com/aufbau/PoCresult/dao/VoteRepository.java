package com.aufbau.PoCresult.dao;

import com.aufbau.PoCresult.models.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository("postgres")
public interface VoteRepository extends JpaRepository<Vote, String> {

    /*
        For example, let's have in the table votes
        SELECT * FROM votes

        client_id       vote_option
        100023          Apple
        867263          Apple
        133023          Mango
        876263          Mango
        189023          Orange
        862263          Mango

        We do
        SELECT vote_option, COUNT(client_id) FROM votes GROUP BY vote_option
        Which gives:

        vote_option     votes
        Apple           2
        Mango           3
        Orange          1

        As this returns 3 results(for 3 vote_options, we need to return a List<Object[]>
        Object[0] is the String voteOption (ex. Mango)
        Object[1] is the Number countOfVoteOption (ex. 2)

        List<Object[]> contains the Object[] for every vote option.
        Here:
        List[0] is Object = {Apple, 2}
        List[1] is Object = {Mango, 3}
        List[2] is Object = {Orange, 1}
     */

    @Query("select voteOption, count(clientId) from Vote group by voteOption")
    List<Object[]> countVotes();
}
