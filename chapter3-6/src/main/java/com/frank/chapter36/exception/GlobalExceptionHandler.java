package com.frank.chapter36.exception;

import com.frank.chapter36.dto.ErrorInfo;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by jianweilin on 2017/10/11.
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = Exception.class)
    public ModelAndView defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception{
        ModelAndView mav = new ModelAndView();
        mav.addObject("exception",e);
        mav.addObject("url",req.getRequestURL());
        mav.setViewName("error");
        return mav;
    }

    @ExceptionHandler(value = MyException.class)
    @ResponseBody
    public ErrorInfo<String> jsonErrorHandler(HttpServletRequest req, MyException e) throws Exception {
        ErrorInfo<String> r = new ErrorInfo<>();
        r.setCode(ErrorInfo.ERROR);
        r.setData("Some Data");
        r.setMessage(e.getMessage());
        r.setUrl(req.getRequestURL().toString());
        return r;
    }
}
