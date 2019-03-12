package com.guschaor.factory.impl;

import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.factory.IEmployeeFactory;

public class EmployeeFactoryHourlyImpl implements IEmployeeFactory {

  public EmployeeDTO getEmployee(EmployeeDTO employee){
    employee.setAnnualSalary(120 * employee.getHourlySalary() * 12);
    return employee;
  }
}
