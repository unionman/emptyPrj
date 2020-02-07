package com.empty.prjname.comm.exception;

import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.empty.prjname.comm.model.CommonHeader;

@RestControllerAdvice
public class RestContorllerExceptionAdvice {

//    @ExceptionHandler(ArithmeticException.class)
//    public CommonHeader ArithmeticException(HttpServletResponse response, ArithmeticException e) {
//        CommonHeader commonHeader = new CommonHeader();
//        commonHeader.setDescription(e.toString());
//        
//        return commonHeader;
//    }

}
