package com.baizhi.controller;


import com.baizhi.entity.Emp;
import com.baizhi.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/emp")
public class EmpAction {
    @Autowired
    EmpService empService;

    @RequestMapping("/chaXunAll")
    public String chaXunAll(HttpServletRequest request) {
        List<Emp> list = empService.findAll();
        request.setAttribute("list", list);
        return "emplist";
    }

    @RequestMapping("/tianJia")
    public String tianJia(Emp emp, MultipartFile upload, HttpServletRequest request) throws IOException {
        //获取保存文件的绝对路径
        String realPath = request.getSession().getServletContext().getRealPath("/pig");
        String filename = upload.getOriginalFilename();
        String newname = new Date().getTime() + "" + filename;
        System.out.println(filename);
        emp.setSrc(newname);
        empService.tianJia(emp);
        upload.transferTo(new File(realPath + "/" + newname));
        return "redirect:/emp/chaXunAll";
    }

    @RequestMapping("/shanChu")
    public String shanChu(int id) {
        empService.shanChu(id);
        return "redirect:/emp/chaXunAll";
    }

    @RequestMapping("/huiXian")
    public String huiXian(int id, HttpServletRequest request) {
        Emp emp = empService.findOne(id);
        request.setAttribute("emp", emp);
        return "updateEmp";
    }

    @RequestMapping("/xiuGai")
    public String xiuGai(Emp emp, MultipartFile upload, HttpServletRequest request) throws IOException {
        if (upload == null) {
            empService.xiuGai(emp);
        } else {
            //获取保存文件的绝对路径
            String realPath = request.getSession().getServletContext().getRealPath("/pig");
            String filename = upload.getOriginalFilename();
            String newname = new Date().getTime() + "" + filename;
            emp.setSrc(newname);
            empService.xiuGai(emp);
            upload.transferTo(new File(realPath + "/" + newname));
        }
        return "redirect:/emp/chaXunAll";
    }

}
