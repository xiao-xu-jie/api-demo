package com.xujie.common.exception.handler;

import com.xujie.common.ResponseEntity;
import com.xujie.common.exception.BaseException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Arrays;
import java.util.Set;

/**
 * @Author: Xujie
 * @Date: 2024/7/15 21:59
 * @Description:
 **/
@RestControllerAdvice(basePackages = "com.xujie")
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler({BaseException.class})
    public ResponseEntity<?> customExceptionHandler(BaseException e) {
        return ResponseEntity.error(e.getMessage());
    }


    @ExceptionHandler({ConstraintViolationException.class, BindException.class, MethodArgumentNotValidException.class})
    public ResponseEntity<?> validateException(Exception ex, HttpServletRequest request) {
//        ex.printStackTrace();
        String msg = null;
        if (ex instanceof ConstraintViolationException) {
            ConstraintViolationException constraintViolationException =
                    (ConstraintViolationException) ex;
            Set<ConstraintViolation<?>> violations =
                    constraintViolationException.getConstraintViolations();
            ConstraintViolation<?> next = violations.iterator().next();
            msg = next.getMessage();
        } else if (ex instanceof BindException) {
            BindException bindException = (BindException) ex;
            msg = bindException.getBindingResult().getFieldError().getDefaultMessage();
        }
        return ResponseEntity.error(msg);
    }


    @ExceptionHandler({RuntimeException.class})
    public ResponseEntity<?> exceptionHandler(Exception e) {
        log.error("系统异常", e);
        int length = Math.min(e.getMessage().length(), 10);
        return ResponseEntity.error(e.getMessage().substring(0, length)+ Arrays.toString(e.getStackTrace()).substring(1, 10));
    }

    @ExceptionHandler({IllegalArgumentException.class})
    public ResponseEntity<?> illegalArgumentExceptionHandler(IllegalArgumentException e) {
        log.error("参数异常", e);
        return ResponseEntity.error(e.getMessage());
    }
}
