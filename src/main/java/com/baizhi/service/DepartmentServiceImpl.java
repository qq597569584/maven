package com.baizhi.service;

import com.baizhi.dao.DepartmentDao;
import com.baizhi.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    @Autowired
    DepartmentDao departmentDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public List<Department> findAll() {
        return departmentDao.selectAll();
    }

    @Override
    @Log(name = "添加部门")
    public void tianJia(Department department) {
        departmentDao.insert(department);
    }

    @Override
    @Log(name = "修改部门信息")
    public void xiuGai(Department department) {
        departmentDao.update(department);
    }

    @Override
    @Log(name = "删除部门信息")
    public void shanChu(int id) {
        departmentDao.delete(id);
    }

    @Override
    @Transactional(propagation = Propagation.SUPPORTS)
    public Department findOne(int id) {
        return departmentDao.selectOne(id);
    }
}
