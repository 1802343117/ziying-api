package com.example.ziying.exception;

import com.example.ziying.common.ResultCode;

/**
 * @ClassName JwtException
 * @Description 自定义异常
 * @Author wl_sun
 * @Date 2020/4/15
 * @Version 1.0
 */
public class JwtException extends RuntimeException {

    protected ResultCode resultCode;

    public JwtException(String msg, ResultCode resultCode) {
        super(msg);
        this.resultCode = resultCode;
    }

    public ResultCode getResultCode() {
        return resultCode;
    }
}