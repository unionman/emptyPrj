package com.empty.prjname.web.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.empty.prjname.web.sample.dao.SampleDao;
import com.empty.prjname.web.sample.service.SampleService;
import com.empty.prjname.web.sample.vo.SampleVo;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleDao sampleDao; 
    
    @Transactional
    @Override
    public List<SampleVo> selectSampleInfo() throws Exception {
        // TODO Auto-generated method stub
        int resultInt = 0;
        
        resultInt += sampleDao.updateTestAge();
        resultInt += sampleDao.updateTestAge();
        
        log.debug("resultInt = {}", resultInt);
        log.debug("resultInt = {}", resultInt);
        log.debug("resultInt = {}", resultInt);
        
        
        return sampleDao.selectSampleInfo();
    }

    
}
