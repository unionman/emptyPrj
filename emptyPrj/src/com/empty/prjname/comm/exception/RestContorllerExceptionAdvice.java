package com.empty.prjname.comm.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.ModelAndView;

import com.empty.prjname.comm.model.CommonHeader;
import com.empty.prjname.comm.model.DefaultJsonModelView;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class RestContorllerExceptionAdvice {

    @ExceptionHandler(ArithmeticException.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView ArithmeticException(HttpServletResponse response, ArithmeticException e) {
        ModelAndView model = new DefaultJsonModelView();
        CommonHeader commonHeader = new CommonHeader();
        commonHeader.setDescription(e.toString());

        log.info("Error Message ::::: {}", e);

        
        model.addObject("statusCode", HttpStatus.INTERNAL_SERVER_ERROR.value());
        model.addObject("reason", e.toString());
        model.addObject("commonHeader", commonHeader);
        return model;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ModelAndView exceptionHandler(HttpServletRequest request, HttpServletResponse response, Exception exception) {

        String contentType = request.getHeader("Content-Type");
        ModelAndView model = null;
        String reason = HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase();
        
        int statusCode = HttpStatus.INTERNAL_SERVER_ERROR.value();

        // Content-Type 확인, json 만 View를 따로 처리함.
//        if (contentType != null && MediaType.APPLICATION_JSON_VALUE.equals(contentType)) {
            model = new ModelAndView("jsonView");
            ResponseStatus annotation = exception.getClass().getAnnotation(ResponseStatus.class);

            if (annotation != null) {
                reason = annotation.reason();
                statusCode = annotation.value().value();
            }

//        } else {
//            // json 이 아닐경우 error page 로 이동
//            model = new ModelAndView("error.jsp");
//        }

        model.addObject("reason", reason);
        model.addObject("statusCode", statusCode);
        response.setStatus(statusCode);

        return model;
    }

}
