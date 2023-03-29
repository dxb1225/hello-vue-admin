package com.lantu.hellovueadmin.emp.vo;

import com.lantu.hellovueadmin.common.vo.MyPage;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author:邓湘标
 * @Package:com.lantu.hellovueadmin.common.vo
 * @DESCRIPTION:
 * @DATE: 2023/3/21 10:26
 * @Version:1.0
 */
@Data
public class EmpQuery extends MyPage implements Serializable {

    private String name;
    private Long id;

}
