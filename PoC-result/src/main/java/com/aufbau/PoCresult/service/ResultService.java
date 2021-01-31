package com.aufbau.PoCresult.service;

import com.aufbau.PoCresult.dao.ResultDao;
import com.aufbau.PoCresult.models.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultService {

    private final ResultDao resultDao;

    //Dependency injection to choose the implementation of ResultDao
    @Autowired
    public ResultService(@Qualifier("fakeResults") ResultDao resultDao) {  //Uses fakeResults dao
        this.resultDao = resultDao;
    }

    //Autowiring will ensure that the correct implementation of ResultDao gets called
    public List<Result> getResults() {
        return resultDao.getResult();
    }
}
