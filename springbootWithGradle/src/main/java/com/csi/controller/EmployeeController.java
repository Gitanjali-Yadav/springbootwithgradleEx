package com.csi.controller;

import com.csi.entity.Employee;
import com.csi.exception.RecordNotFoundException;
import com.csi.service.IEmployeeService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/employees")
@Slf4j
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;

    @PostMapping("/signup")
    public ResponseEntity<Employee> signUp(@Valid @RequestBody Employee employee) {

        log.info("########Signing_up for employee : " + employee.getEmpName());
        return new ResponseEntity<>(iEmployeeService.signUp(employee), HttpStatus.CREATED);
    }

    @GetMapping("/signin/{empEmailId}/{empPassword}")
    public ResponseEntity<Boolean> signIn(@PathVariable String empEmailId, @PathVariable String empPassword) {
        return new ResponseEntity<>(iEmployeeService.signIn(empEmailId, empPassword), HttpStatus.OK);
    }

    @GetMapping("/finbyid/{empId}")
    public ResponseEntity<Optional<Employee>> findbyId(@PathVariable int empId) {
        return new ResponseEntity<>(iEmployeeService.findById(empId), HttpStatus.OK);
    }

    @GetMapping("/findbyname/{empName}")
    public ResponseEntity<List<Employee>> findByName(@PathVariable String empName){
        return new ResponseEntity<>(iEmployeeService.findByName(empName), HttpStatus.OK);
    }

    @GetMapping("/findall")
    public ResponseEntity<List<Employee>> findAll(){
        return new ResponseEntity<>(iEmployeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/sortbyname")
    public ResponseEntity<List<Employee>> sortByName(){
        return new ResponseEntity<>(iEmployeeService.findAll().stream().sorted(Comparator.comparing(Employee::getEmpName)).toList(), HttpStatus.OK);
    }

    @PutMapping("/update/{empId}")
    public ResponseEntity<Employee> update(@PathVariable int empId , @Valid @RequestBody Employee employee){
        Employee employee1 = iEmployeeService.findById(empId).orElseThrow(()-> new RecordNotFoundException("Employee Id Does not Exist !!"));

        employee1.setEmpEmailId(employee.getEmpEmailId());
        employee1.setEmpAddress(employee.getEmpAddress());
        employee1.setEmpDOB(employee.getEmpDOB());
        employee1.setEmpName(employee.getEmpName());
        employee1.setEmpContactNumber(employee.getEmpContactNumber());
        employee1.setEmpPassword(employee.getEmpPassword());

        return new ResponseEntity<>(iEmployeeService.update(employee1), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletebyid/{empId}")
    public ResponseEntity<String> deleteById(@PathVariable int empId){
        iEmployeeService.deleteById(empId);
        return new ResponseEntity<>("Data deleted successfully !!", HttpStatus.OK);
    }

    @DeleteMapping("/deleteall")
    public ResponseEntity<String> deleteAll(){
        iEmployeeService.deleteAll();
        return new ResponseEntity<>(" All Data deleted successfully !!", HttpStatus.OK);
    }
}
