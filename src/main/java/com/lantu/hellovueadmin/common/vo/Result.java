package com.lantu.hellovueadmin.common.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author:邓湘标
 * @Package:com.lantu.hellovueadmin.common.vo
 * @DESCRIPTION:
 * @DATE: 2023/3/20 11:32
 * @Version:1.0
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;

    public static <T> Result<T> success(){
        return new Result<>(20000,"success",null);
    }

    public static <T> Result<T> success(String message){
        return new Result<>(20000,message,null);
    }

    public static <T> Result<T> success(String message,T data){
        return new Result<>(20000,message,data);
    }

    public static <T> Result<T> success(T data){
        return new Result<>(20000,"success",data);
    }


    public static <T> Result<T> fail(){
        return new Result<>(20001,"fail",null);
    }

    public static <T> Result<T> fail(Integer code){
        return new Result<>(code,"fail",null);
    }
    public static <T> Result<T> fail(Integer code,String message){
        return new Result<>(code,message,null);
    }

    public static <T> Result<T> fail(String message){
        return new Result<>(20001,message,null);
    }
}
