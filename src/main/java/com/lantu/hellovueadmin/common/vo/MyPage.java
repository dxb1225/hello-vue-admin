package com.lantu.hellovueadmin.common.vo;

import lombok.Data;

import java.io.Serializable;

/**
 * @Author:邓湘标
 * @Package:com.lantu.hellovueadmin.common.vo
 * @DESCRIPTION:
 * @DATE: 2023/3/21 10:29
 * @Version:1.0
 */
@Data
public class MyPage implements Serializable {
    private Long pageNo;
    private Long pageSize;

}
