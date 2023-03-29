package com.lantu.hellovueadmin.emp.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.hellovueadmin.emp.entity.Emp;
import com.lantu.hellovueadmin.emp.mapper.EmpMapper;
import com.lantu.hellovueadmin.emp.service.IEmpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lantu.hellovueadmin.emp.vo.EmpQuery;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author dxb
 * @since 2023-03-21
 */
@Service
public class EmpServiceImpl extends ServiceImpl<EmpMapper, Emp> implements IEmpService {

    @Override
    public Page getEmpList(EmpQuery param) {
        Page<Emp> page = new Page<>(param.getPageNo(),param.getPageSize());
        LambdaQueryWrapper<Emp> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(param.getId()!=null,Emp::getId,param.getId());
        wrapper.like(StringUtils.hasLength(param.getName()),Emp::getName,param.getName());
        wrapper.orderByDesc(Emp::getId);
        this.page(page,wrapper);
        return page;
    }
}
