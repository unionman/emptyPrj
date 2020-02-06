package com.empty.prjname.web.sample.controller;

import java.util.List;

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
        
        List datas = sampleService.selectSampleInfo();
        log.debug("test == {}", datas.size() );
        
        
        model.addAttribute("currentTimeStamp", DateUtil.getCurrentTimeStamp() );
        model.addAttribute("datas", datas );

        return "/sample_page";
    }
}
