package com.lantu.hellovueadmin.emp.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.hellovueadmin.emp.entity.Emp;
import com.baomidou.mybatisplus.extension.service.IService;
import com.lantu.hellovueadmin.emp.vo.EmpQuery;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author dxb
 * @since 2023-03-21
 */
public interface IEmpService extends IService<Emp> {

    Page getEmpList(EmpQuery param);
}
