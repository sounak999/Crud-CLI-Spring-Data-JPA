package com.command.crudcli.dao;

import com.command.crudcli.entity.Student;

public interface StudentDAO {
    void save(Student student);

    Student findById(Integer id);
}
