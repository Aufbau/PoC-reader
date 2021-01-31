package com.aufbau.PoCresult.service;

import com.aufbau.PoCresult.dao.ResultDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.Hashtable;

@Service
public class ResultService {

    private final ResultDao resultDao;

    //Dependency injection to choose the implementation of ResultDao
    @Autowired
    public ResultService(@Qualifier("fakeResults") ResultDao resultDao) {  //Uses fakeResults dao
        this.resultDao = resultDao;
    }

    //Autowiring will ensure that the correct implementation of ResultDao gets called
    public Hashtable<String, Integer> getResults() {
        return resultDao.getResult();
    }
}
