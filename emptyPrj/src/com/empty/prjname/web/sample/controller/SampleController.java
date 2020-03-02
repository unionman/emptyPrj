package com.empty.prjname.web.sample.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empty.prjname.comm.DateUtil;
import com.empty.prjname.web.sample.service.SampleService;
import com.empty.prjname.web.sample.vo.SampleVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

/**
 * @author "unionman"
 *
 */

@Slf4j
@Controller
public class SampleController {

    @Autowired
    SampleService sampleService;
    
    /**
     * @return
     */
    @RequestMapping(value = "/sample_page", method = RequestMethod.GET)
    public String getHello(ModelMap model) throws Exception {
        
//        ModelAndView model = new ModelAndView();
        log.debug("loggggggggggggg");
        
        List datas = sampleService.selectSampleInfo();
        log.debug("test == {}", datas.size() );
        
        
        model.addAttribute("currentTimeStamp", DateUtil.getCurrentTimeStamp() );
        model.addAttribute("datas", datas );

        ObjectMapper objectMapper = new ObjectMapper();
        SampleVo sampleVo = new SampleVo();
        sampleVo.setAge(2);
        sampleVo.setName("샘플");
        
        String jsonSampleVoStr = objectMapper.writeValueAsString(sampleVo);
        log.debug(jsonSampleVoStr);
        
        String sampleVoJsonStr = "[{ \"id\":0,\"name\":\"샘플\",\"age\":2 },{ \"id\":0,\"name\":\"샘플\",\"age\":2 }]";
        List<SampleVo> sampleVo2s = new ArrayList<SampleVo>();
        sampleVo2s = objectMapper.readValue(sampleVoJsonStr, new TypeReference<List<SampleVo>>() {});
        log.debug("{}", sampleVo2s.toString());        
        
        
        return "/sample_page";
    }
}
