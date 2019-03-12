package com.guschaor.repository;

import com.guschaor.common.dto.EmployeeDTO;
import java.util.List;
import java.util.Optional;

public interface IEmployeeRepository {

  public Optional<List<EmployeeDTO>> getAllEmployes();

}
