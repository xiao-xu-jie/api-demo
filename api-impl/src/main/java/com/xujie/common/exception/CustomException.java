package com.xujie.common.exception;


import com.xujie.common.enums.ResponseCodeEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Author: Xujie
 * @Date: 2024/7/15 21:58
 * @Description: 业务异常
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomException extends BaseException {

    private Integer code;
    private String message;

    public CustomException(ResponseCodeEnum baseResultEnum) {
        this.code = baseResultEnum.getCode();
        this.message = baseResultEnum.getMessage();
    }

    public CustomException(String s) {
        this.message = s;
        this.code = ResponseCodeEnum.ERROR.getCode();
    }
}
