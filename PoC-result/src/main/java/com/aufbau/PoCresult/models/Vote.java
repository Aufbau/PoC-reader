package com.aufbau.PoCresult.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/*
    Entity Class for a single vote, modelling the votes table
    from the database. Only used in voteRepository to model
    JPQL Query.
 */

@Entity
@Table(name = "votes")
public class Vote {

    @Id
    @Column(name = "client_id")
    private final String clientId;

    @Column(name = "vote_option")
    private final String voteOption;

    public Vote(String clientId, String voteOption) {
        this.clientId = clientId;
        this.voteOption = voteOption;
    }

    public Vote() {
        this.clientId = "";
        this.voteOption = "";
    }

    public String getClientId() {
        return clientId;
    }

    public String getVoteOption() {
        return voteOption;
    }

}
