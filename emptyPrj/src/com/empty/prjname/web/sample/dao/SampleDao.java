package com.empty.prjname.web.sample.dao;

import java.util.List;

import com.empty.prjname.web.sample.vo.SampleVo;

public interface SampleDao {

    public List<SampleVo> selectSampleInfo() throws Exception;

    public int updateTestAge() throws Exception;
    

}
