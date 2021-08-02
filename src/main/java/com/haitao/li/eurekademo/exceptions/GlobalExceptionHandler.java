package com.haitao.li.eurekademo.exceptions;

import com.haitao.li.eurekademo.classes.LalaConstant;
import com.haitao.li.eurekademo.classes.ResultModel;
import com.haitao.li.eurekademo.util.ExceptionUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author liht
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(value = Exception.class)
    public ResultModel exceptionHandler(HttpServletRequest request, Exception e) {
        ResultModel resultModel = new ResultModel();
        logger.error("GlobalExceptionHandler exceptionHandler e{}", ExceptionUtil.getMessage(e));
        if (e instanceof BindException) {
            BindException ex = (BindException) e;
            List<ObjectError> errors = ex.getAllErrors();
            ObjectError error = errors.get(0);
            String msg = error.getDefaultMessage();
            resultModel.setMsg(msg);
            resultModel.setRet(LalaConstant.ErrorCodeEnum.PARAM_FAIL.getCode());
        } else if (e instanceof MissingServletRequestParameterException) {
            resultModel.setMsg(e.getMessage());
            resultModel.setRet(LalaConstant.ErrorCodeEnum.S_FAIL.getCode());
        } else if (e instanceof HttpRequestMethodNotSupportedException || e instanceof HttpMessageNotReadableException) {
            resultModel.setMsg(e.getMessage());
            resultModel.setRet(LalaConstant.ErrorCodeEnum.S_FAIL.getCode());
        } else if (e instanceof MethodArgumentNotValidException) {
            MethodArgumentNotValidException me = (MethodArgumentNotValidException) e;
            if (me != null && me.getBindingResult() != null) {
                StringBuilder msg = new StringBuilder();
                BindingResult bindingResult = me.getBindingResult();
                if (bindingResult.hasErrors() && bindingResult.getAllErrors() != null) {
                    for (ObjectError error : bindingResult.getAllErrors()) {
                        //((FieldError) error).getField()
                        if (error instanceof FieldError) {
                            FieldError fieldError = (FieldError) error;
                            msg.append("字段(").append(fieldError.getField()).append("):" + fieldError.getDefaultMessage()).append("\n");
                            //fieldError.getRejectedValue();
                        }
                    }
                    if (msg.length() < 1) {
                        msg.append(me.getMessage());
                    }
                    resultModel.setMsg(msg.toString());
                } else {
                    resultModel.setMsg(me.getMessage());
                }
                resultModel.setRet(LalaConstant.ErrorCodeEnum.PARAM_FAIL.getCode());
            } else {
                resultModel.setMsg(LalaConstant.ErrorCodeEnum.S_FAIL.getSummary());
                resultModel.setRet(LalaConstant.ErrorCodeEnum.S_FAIL.getCode());
            }
        } else {
            logger.info("eeeeeeeeeeeee={}", e.getMessage());
        }
        return resultModel;
    }
}
