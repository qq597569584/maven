package com.baizhi.dao;


import com.baizhi.entity.Emp;

import java.util.List;

public interface EmpDao {
    List<Emp> selectAll();

    void update(Emp emp);

    void insert(Emp emp);

    void delete(int id);

    Emp selectOne(int id);
}
