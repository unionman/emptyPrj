package com.empty.prjname.web.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empty.prjname.web.sample.dao.SampleDao;
import com.empty.prjname.web.sample.service.SampleService;
import com.empty.prjname.web.sample.vo.SampleVo;

@Service
public class SampleServiceImpl implements SampleService {

    @Autowired
    SampleDao sampleDao; 
    
    @Override
    public List<SampleVo> selectSampleInfo() throws Exception {
        // TODO Auto-generated method stub
        return sampleDao.selectSampleInfo();
    }

    
}
