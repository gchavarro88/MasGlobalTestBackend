package com.guschaor.repository.impl;

import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.common.enumeration.ContractTypeEnum;
import com.guschaor.factory.impl.EmployeeFactoryHourlyImpl;
import com.guschaor.factory.impl.EmployeeFactoryMonthlyImpl;
import com.guschaor.repository.IEmployeeRepository;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class EmployeeRepositoryImpl implements IEmployeeRepository {

  @Autowired
  private String employeesUrl;

  public EmployeeRepositoryImpl(@Value("${database.url}") String employeesUrl){
    this.employeesUrl = employeesUrl;
  }

  @Override
  public Optional<List<EmployeeDTO>> getAllEmployes() {
    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<List<EmployeeDTO>> response = restTemplate.exchange(
        this.employeesUrl,
        HttpMethod.GET,
        null,
        new ParameterizedTypeReference<List<EmployeeDTO>>(){});
    List<EmployeeDTO> result = response.getBody();

    if(result == null){
      return Optional.empty();
    } else {
      return Optional.of(result.stream().map(employee -> {
        if(employee.getContractTypeName().equals(ContractTypeEnum.HOURLY_SALARY_EMPLOYEE.toString())){
          return new EmployeeFactoryHourlyImpl().getEmployee(employee);
        } else {
          return new EmployeeFactoryMonthlyImpl().getEmployee(employee);
        }
      }).collect(Collectors.toList()));
    }
  }
}
