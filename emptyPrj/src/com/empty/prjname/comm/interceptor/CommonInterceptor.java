package com.empty.prjname.comm.interceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CommonInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        log.debug(request.getRequestURL().toString());
//        if (handler instanceof HandlerMethod) {
//            HandlerMethod method = (HandlerMethod) handler;
//            CheckAuth auth = method.getMethodAnnotation(CheckAuth.class);
//
//            /* 로그인 처리 */
//            if(auth != null){
//                LoginRes loginRes = CookieUtil.getLoginInfo(request);
//                if(loginRes == null){
//                    throw new CommonException(ErrorCodeConstants.NEED_LOGIN, null);
//                }
//            }
//        }

        /* 로그인 쿠키 유지시간 연장 */
        Cookie[] cookies = request.getCookies();

        if(cookies != null){
            // 쿠키에서 로그인 쿠키 추출
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("OPPF_MEMBER")) {
                    log.debug("========================= CookieTimeReset ===========================");
                    cookie.setPath("/");
                    cookie.setMaxAge(60*10);
                    response.addCookie(cookie);
                }
            }
        }

        log.debug("========================= preHandle =======================================");
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.debug("========================= postHandle =======================================");
    }
}
