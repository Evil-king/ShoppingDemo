package com.aladingbank.sample.service.impl;

import com.aladingbank.dao.sample.ISampleDao;
import com.aladingbank.entity.sample.ShopSample;
import com.aladingbank.sample.service.SampleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    private ISampleDao sampleDao;

    @Override
    public ShopSample getAll() {
        return this.sampleDao.getAll();
    }
}
