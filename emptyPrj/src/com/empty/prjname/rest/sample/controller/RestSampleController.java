package com.empty.prjname.rest.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.empty.prjname.comm.DateUtil;
import com.empty.prjname.web.sample.vo.SampleVo;

import lombok.extern.slf4j.Slf4j;

/**
 * @author unionman
 *
 */

@Slf4j
@Controller
public class RestSampleController {

    @RequestMapping(value = "/rest/sample_page", method = RequestMethod.GET)
    public String getSample_page(ModelMap model) {
        
        SampleVo data  = new SampleVo();
        data.setName("홍길동");
        data.setAge(27);
        data.setContry("KR");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );

        model.addAttribute( data);
        
        log.debug("data = {}", data);
        
        return "jsonView";
    }
    
    @RequestMapping(value = "/rest/sample_page2", method = RequestMethod.GET)
    public ModelAndView getSample_page2() {
        
        ModelAndView model = new ModelAndView("jsonView");

        SampleVo data  = new SampleVo();
        data.setName("홍길순");
        data.setAge(27);
        data.setContry("EN");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );
        
        model.addObject(data);
        
        log.debug("data = {}", data);
        
        return model;
    }
}
