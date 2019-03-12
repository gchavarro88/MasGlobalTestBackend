package com.guschaor.factory;

import com.guschaor.common.dto.EmployeeDTO;

public interface IEmployeeFactory {

  public EmployeeDTO getEmployee(EmployeeDTO employee);
}
