package com.example.demo.service;

import com.example.demo.dao.EmployeeRepository;
import com.example.demo.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository dao;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository dao) {
        this.dao = dao;
    }

    @Override
    public List<Employee> findAll() {
        return dao.findAll();
    }

    @Override
    public Employee findById(int id) {
        Optional<Employee> result = dao.findById(id);
        Employee theEmployee = null;

        if (result.isPresent()) {
            theEmployee = result.get();
        }
        else {
            throw new RuntimeException("Did not find employee id - " + id);
        }

        return theEmployee;
    }

    @Override
    public void save(Employee employee) {
        dao.save(employee);
    }

    @Override
    public void deleteById(int id) {
        dao.deleteById(id);
    }
}
