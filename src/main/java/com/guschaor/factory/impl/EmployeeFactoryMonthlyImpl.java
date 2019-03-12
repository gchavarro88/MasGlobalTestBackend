package com.guschaor.factory.impl;

import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.factory.IEmployeeFactory;

public class EmployeeFactoryMonthlyImpl implements IEmployeeFactory {

  public EmployeeDTO getEmployee(EmployeeDTO employee){
    employee.setAnnualSalary(employee.getMonthlySalary()*12);
    return employee;
  }
}
