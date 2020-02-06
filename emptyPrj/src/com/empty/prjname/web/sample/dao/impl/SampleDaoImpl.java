package com.empty.prjname.web.sample.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.empty.prjname.web.sample.dao.SampleDao;
import com.empty.prjname.web.sample.vo.SampleVo;

@Repository
public class SampleDaoImpl implements SampleDao {

    
    @Autowired
    private SqlSession sqlSession;
    
    private static final String Namespace = "mapper.SampleDao";
    
    @Override
    public List<SampleVo> selectSampleInfo() throws Exception {
 
        return sqlSession.selectList(Namespace+".selectSampleInfo");
    }

    @Override
    public int updateTestAge() throws Exception {
        // TODO Auto-generated method stub
        return sqlSession.update(Namespace+".updateTestAge");
    }

}
