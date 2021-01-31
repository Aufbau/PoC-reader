package com.aufbau.PoCresult.api;

import com.aufbau.PoCresult.models.Result;
import com.aufbau.PoCresult.service.ResultService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    private final ResultService resultService;

    @Autowired
    public ResultController(ResultService resultService) {
        this.resultService = resultService;
    }

    //Returns the current tally of results
    @GetMapping
    public List<Result> getResults() {
        return resultService.getResults();
    }
}
