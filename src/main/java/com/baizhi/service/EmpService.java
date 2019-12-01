package com.baizhi.service;


import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpService {
    List<Emp> findAll();

    void tianJia(Emp emp);

    void shanChu(int id);

    void xiuGai(Emp emp);

    Emp findOne(int id);
}
