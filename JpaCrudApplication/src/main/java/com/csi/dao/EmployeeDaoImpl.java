package com.csi.dao;

import com.csi.model.Employee;
import com.csi.repo.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class EmployeeDaoImpl {

    @Autowired
    EmployeeRepository employeeRepository;

    public Employee saveData(Employee employee){

        return  employeeRepository.save(employee);
    }

    public Optional<Employee>  getDataById(int empId){
        return employeeRepository.findById(empId);
    }

    public List<Employee> getAllData(){
        return employeeRepository.findAll();
    }

    public Employee updateData(Employee employee){

        return  employeeRepository.save(employee);

    }
    public void deleteById(int empId){
        employeeRepository.deleteById(empId);
    }

    public void deleteAllData(){
        employeeRepository.deleteAll();
    }
}
