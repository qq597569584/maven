package com.baizhi.service;


import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> findAll();

    void tianJia(Department department);

    void xiuGai(Department department);

    void shanChu(int id);

    Department findOne(int id);
}
