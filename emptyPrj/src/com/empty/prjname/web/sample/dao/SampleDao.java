package com.empty.prjname.web.sample.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.empty.prjname.web.sample.vo.SampleVo;

@Mapper
public interface SampleDao {

    public List<SampleVo> selectSampleInfo() throws Exception;

    public int updateTestAge() throws Exception;
    

}
