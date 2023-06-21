package com.csi.controller;

import com.csi.exception.RecordNotFoundException;
import com.csi.model.Employee;
import com.csi.service.EmployeeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    EmployeeServiceImpl employeeServiceImpl;

    @PostMapping("/savedata")

    public ResponseEntity<Employee>saveData(@RequestBody Employee employee){
        return new ResponseEntity(employeeServiceImpl.saveData(employee) ,HttpStatus.CREATED);
    }

    @GetMapping("/getdatabyid/{empId}")
    public ResponseEntity<Optional<Employee>> getDataById(@PathVariable int empId){
        return  ResponseEntity.ok(employeeServiceImpl.getDataById(empId));
    }

    @GetMapping ("/getalldata")
    public ResponseEntity<List<Employee>>getAllData(){
        return ResponseEntity.ok(employeeServiceImpl.getAllData());
    }

    @PutMapping("/updatedata/{empId}")

    public ResponseEntity<Employee>updateData(@PathVariable int empId, @RequestBody Employee employee) {
        //custom methods

        Employee employee1 = employeeServiceImpl.getDataById(empId).orElseThrow(() -> new RecordNotFoundException("Employee Id Does not exist"));

        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpSalary(employee.getEmpSalary());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());

        return ResponseEntity.ok(employeeServiceImpl.updateData(employee1));



    }
    @DeleteMapping("/deletebyid/{empId}")

    public ResponseEntity<String>deleteDataById(@PathVariable int empId){
        employeeServiceImpl.deleteById(empId);
        return ResponseEntity.ok("Data Deleted successfully");
    }

    @DeleteMapping("/deletealldata")

    public ResponseEntity<String>deleteAllData(){

        employeeServiceImpl.deleteAllData();
        return ResponseEntity.ok("All Data Deleted Successfully");
    }

}
