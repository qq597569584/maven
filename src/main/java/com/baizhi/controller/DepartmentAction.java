package com.baizhi.controller;

import com.baizhi.entity.Department;
import com.baizhi.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/department")
public class DepartmentAction {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping("/chaXunAll")
    public String chaXunAll(HttpServletRequest request) {
        List<Department> list = departmentService.findAll();
        HttpSession session = request.getSession();
        session.setAttribute("nb", list);
        return "departments";
    }

    @RequestMapping("/tianJia")
    public String tianJia(Department department) {
        departmentService.tianJia(department);
        return "redirect:/department/chaXunAll";
    }

    @RequestMapping("/huiXian")
    public String huiXian(int id, HttpServletRequest request) {
        Department one = departmentService.findOne(id);
        request.setAttribute("one", one);
        return "updateDepartment";
    }

    @RequestMapping("/xiuGai")
    public String xiuGai(Department department) {
        departmentService.xiuGai(department);
        return "redirect:/department/chaXunAll";
    }

    @ResponseBody
    @RequestMapping("/ygTianJia")
    public List<Department> ygTianJia() {
        List<Department> all = departmentService.findAll();
        return all;
    }
}
