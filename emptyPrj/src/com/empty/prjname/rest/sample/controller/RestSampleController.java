package com.empty.prjname.rest.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.empty.prjname.comm.DateUtil;
import com.empty.prjname.comm.exception.CustomInterfaceException;
import com.empty.prjname.comm.model.DefaultJsonModelView;
import com.empty.prjname.web.sample.service.SampleService;
import com.empty.prjname.web.sample.vo.SampleVo;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * @author unionman
 *
 */

@Slf4j
@Api(value = "/rest", description = "샘플 컨트롤러")
@RestController
public class RestSampleController {

    @Value("${profile.level}") 
    private String profileLevel;
    
    @Autowired
    SampleService sampleService;
    

    @ApiOperation(value="샘플 sample_page" ,notes="노트 영역입니다.")
    @RequestMapping(value = "/rest/sample_page", method = RequestMethod.GET)
    public String getSample_page(ModelMap model) throws Exception  {
        
        SampleVo data  = new SampleVo();
        data.setName("홍길동");
        data.setAge(27);
        data.setContry("KR");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );

        List<SampleVo> datas = sampleService.selectSampleInfo();
        model.addAttribute("datas" , datas);
        
        log.debug("data = {}", data);
        log.debug("profileLevel = {}", profileLevel);
        
        return "jsonView";
    }
    
    @RequestMapping(value = "/rest/sample_page2", method = RequestMethod.GET)
    public SampleVo getSample_page2() {
        
        ModelAndView model = new ModelAndView("jsonView");

        SampleVo data  = new SampleVo();
        data.setName("홍길순");
        data.setAge(27);
        data.setContry("EN");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );
        
        model.addObject(data);
        
        log.debug("data = {}", data);
        log.debug("profileLevel = {}", profileLevel);
        
        return data;
    }
    
    @RequestMapping(value = "/rest/sample_page22", method = RequestMethod.GET)
    public SampleVo getSample_page22(@Valid SampleVo sampleVo) {
        
        ModelAndView model = new ModelAndView("jsonView");
        
        SampleVo data  = new SampleVo();
        data.setName("홍길순");
        data.setAge(27);
        data.setContry("EN");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );
        
        model.addObject(data);
        
        log.debug("data = {}", data);
        log.debug("profileLevel = {}", profileLevel);
        
        return data;
    }
    
    @RequestMapping(value = "/rest/sample_page3", method = RequestMethod.GET)
    public DefaultJsonModelView getSample_page3() {
        
        DefaultJsonModelView model = new DefaultJsonModelView();
        
        SampleVo data  = new SampleVo();
        data.setName("홍길순");
        data.setAge(27);
        data.setContry("EN");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );
        
        model.addObject("data", data);
        
        log.debug("data = {}", data);
        log.debug("profileLevel = {}", profileLevel);
        
        return model;
    }
    
    @RequestMapping(value = "/rest/sample_page4", method = RequestMethod.GET)
    public DefaultJsonModelView getSample_page4() throws Exception {
        
        int ii =  1/0;
        DefaultJsonModelView model = new DefaultJsonModelView();
        
        List<SampleVo> datas = sampleService.selectSampleInfo();
        model.addObject("datas" , datas);
        
        log.debug("profileLevel = {}", profileLevel);
        
        return model;
    }
    
    @RequestMapping(value = "/rest/sample_page5", method = RequestMethod.GET)
    public SampleVo getSample_page5() throws Exception {
//        try {
//            int ii =  1/0;
//        } catch (Exception e) {
//            // TODO: handle exception
//            throw new CustomInterfaceException(HttpStatus.BAD_REQUEST.toString(), new String[] {"테스트 입니다. 하하하"}, "");
//        }
        
        
        SampleVo data  = new SampleVo();
        data.setName("홍길순");
        data.setAge(27);
        data.setContry("EN");
        data.setDateTime( DateUtil.getCurrentTimeStamp() );
        
        return data;
    }
    
    
}
