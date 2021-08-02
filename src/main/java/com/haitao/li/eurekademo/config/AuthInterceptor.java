package com.haitao.li.eurekademo.config;

import com.haitao.li.eurekademo.exceptions.NotLogInException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author liht
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    private static final  String secret = "secret";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        log.info("request--uri:{}", request.getServletPath());
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }

        String secretParam = request.getParameter(secret);
        if (StringUtils.isEmpty(secretParam)) {
            secretParam = request.getHeader(secret);
        }
        if (StringUtils.isEmpty(secretParam)) {
            throw new NotLogInException("0001", "请登录");
        }



        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("postHandle");

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        log.info("afterCompletion");
    }


}
