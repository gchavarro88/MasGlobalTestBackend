package com.guschaor.service.impl;

import com.guschaor.service.IEmployeeService;
import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.repository.IEmployeeRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements IEmployeeService {

  /**
   * Employee repository.
   **/
  private final IEmployeeRepository employeeRepository;

  @Autowired
  public EmployeeServiceImpl(IEmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Override
  public List<EmployeeDTO> getAllEmployees() {
    Optional<List<EmployeeDTO>> data =  employeeRepository.getAllEmployes();
    List<EmployeeDTO> result = null;
    if(data.isPresent()){
      result = data.get();
    }
    return result;
  }

  @Override
  public EmployeeDTO getEmployeeById(Long employeeId) {
    Optional<List<EmployeeDTO>> data =  employeeRepository.getAllEmployes();
    EmployeeDTO result = null;
    if(data.isPresent()){
      result = data.get().stream().filter(employeer -> employeer.getId()
          .equals(employeeId)).findFirst().get();
    }
    return result;
  }
}
