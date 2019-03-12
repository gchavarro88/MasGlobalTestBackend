package com.guschaor.controller;

import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.service.IEmployeeService;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * REST controller to get employee information.
 */
@RestController
@RequestMapping("/employee")
public class EmployeeController {

  /**
   * Employee Service.
   */
  private final IEmployeeService employeeService;

  /**
   * Constructor.
   * @param employeeService - employee service interface
   */
  @Autowired
  public EmployeeController(IEmployeeService employeeService){
    this.employeeService = employeeService;
  }

  /**
   * Get all employees of the database.
   * @return Response entity.
   */
  @GetMapping(value = "/getAllEmployees")
  public ResponseEntity<List<EmployeeDTO>> getAllEmployees() {
    return new ResponseEntity<>(new List<EmployeeDTO>, HttpStatus.OK);
  }

  /**
   * Get an specific employee of the database.
   * @return Response entity.
   */
  @GetMapping(value = "/{employeeId}")
  public ResponseEntity<EmployeeDTO> getEmployeeById() {
    return new ResponseEntity<>(new EmployeeDTO(), HttpStatus.OK);
  }

}