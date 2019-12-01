package com.baizhi.service;


import com.baizhi.entity.Admin;

public interface AdminService {
    Admin findByUsernameAndPassword(String username, String password);

    void tianJia(Admin admin);
}
