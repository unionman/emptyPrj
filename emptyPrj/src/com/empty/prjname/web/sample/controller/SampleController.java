package com.empty.prjname.web.sample.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.empty.prjname.comm.DateUtil;
import com.empty.prjname.web.sample.service.SampleService;

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
        log.debug("test == {}", sampleService.selectSampleInfo().size() );
        model.addAttribute("currentTimeStamp", DateUtil.getCurrentTimeStamp() );

        return "/sample_page";
    }
}
