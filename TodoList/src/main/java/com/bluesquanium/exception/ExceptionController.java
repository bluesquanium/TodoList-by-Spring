package com.bluesquanium.exception;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice // 모든 Controller에 함께 포함됨. -> 1. Global Exception handling, 2. Global Initail binder 역할. 여기서는 1번 역할만 수행.
public class ExceptionController {

    private Log logger = LogFactory.getLog(ExceptionController.class);

    @ExceptionHandler(value = Exception.class)
    public String handleException(HttpServletRequest request, Exception ex) {
        logger.error("Requset " + request.getRequestURL() + "Threw an Exception", ex);
        return "error";
    }
}
