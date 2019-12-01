package com.baizhi.dao;


import com.baizhi.entity.Department;

import java.util.List;

public interface DepartmentDao {
    List<Department> selectAll();

    void update(Department department);

    void insert(Department department);

    void delete(int id);

    Department selectOne(int id);
}
