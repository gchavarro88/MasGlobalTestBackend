package com.guschaor.service;

import com.guschaor.common.dto.EmployeeDTO;
import java.util.List;

public interface IEmployeeService {

  public List<EmployeeDTO> getAllEmployees();

  public EmployeeDTO getEmployeeById(Long employeeId);
}
