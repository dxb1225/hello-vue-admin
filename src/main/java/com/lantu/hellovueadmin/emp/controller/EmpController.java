package com.lantu.hellovueadmin.emp.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.lantu.hellovueadmin.common.vo.Result;
import com.lantu.hellovueadmin.emp.entity.Emp;
import com.lantu.hellovueadmin.emp.service.IEmpService;
import com.lantu.hellovueadmin.emp.vo.EmpQuery;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author dxb
 * @since 2023-03-21
 */
@Api(tags = {"员工模块接口"})
@RestController
@RequestMapping("/emp")
public class EmpController {
    @Autowired
    private IEmpService empService;

    @ApiOperation("分页查询员工列表")
    @GetMapping("/list")
    public Result<Map<String,Object>> getEmpList(EmpQuery param){
        Page page = empService.getEmpList(param);
        Map<String,Object> data = new HashMap<>();
        data.put("total", page.getTotal());
        data.put("rows", page.getRecords());
        return Result.success(data);
    }

    @ApiOperation("新增员工")
    @PostMapping
    public Result<Emp> addEmp(@RequestBody Emp emp){
        empService.save(emp);

        return Result.success("新增成功!");
    }
    @ApiOperation("修改员工")
    @PutMapping
    public Result<Emp> updateEmp(@RequestBody Emp emp){
        empService.updateById(emp);

        return Result.success("修改成功!");
    }

    @ApiOperation("删除员工")
    @DeleteMapping("/{id}")
    public Result<Emp> deleteEmp(@PathVariable("id")Integer id){
        empService.removeById(id);
        return Result.success("删除成功!");
    }


    @ApiOperation("根据id查询员工")
    @GetMapping("/{id}")
    public Result<Emp> getEmpById(@PathVariable("id") Integer id){
        Emp emp = empService.getById(id);

        return Result.success(emp);
    }
}
