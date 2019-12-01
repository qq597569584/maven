package com.baizhi.controller;

import com.baizhi.entity.Admin;
import com.baizhi.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("/admin")
public class AdminAction {
    @Autowired
    AdminService adminService;


    @RequestMapping("/dengLu")
    public String dengLu(String name, String pwd, HttpServletRequest request) {
        System.out.println("denglu");
        HttpSession session = request.getSession();
        Admin admin = adminService.findByUsernameAndPassword(name, pwd);
        System.out.println(admin);
        session.setAttribute("fl", admin.getUsername());
        return "redirect:/department/chaXunAll";

    }


    @RequestMapping("/zheCe")
    public String zhuCe(Admin admin) {
        adminService.tianJia(admin);
        return "login";
    }
}

