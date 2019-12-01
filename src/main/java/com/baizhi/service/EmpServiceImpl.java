package com.baizhi.service;

import com.baizhi.dao.EmpDao;
import com.baizhi.entity.Emp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class EmpServiceImpl implements EmpService {
    @Autowired
    EmpDao empDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Emp> findAll() {
        return empDao.selectAll();
    }

    @Override
    @Log(name = "添加员工")
    public void tianJia(Emp emp) {
        empDao.insert(emp);
    }

    @Override
    @Log(name = "删除员工")
    public void shanChu(int id) {
        empDao.delete(id);
    }

    @Override
    @Log(name = "修改员工")
    public void xiuGai(Emp emp) {
        empDao.update(emp);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Emp findOne(int id) {
        return empDao.selectOne(id);
    }
}
