package com.guschaor.common.dto;

public class EmployeeDTO {

  /** Employee Id*/
  private Long id;

  /** Employee Name*/
  private String name;

  /** Type of Contract*/
  private String contractTypeName;

  /** Role Id*/
  private Long roleId;

  /** Role Name*/
  private String roleName;

  /** Hourly Salary Value*/
  private Double hourlySalary;

  /** Monthly Salary Value*/
  private Double monthlySalary;

  /** Annual Salary Value*/
  private Double AnnualSalary;

  public EmployeeDTO(){}

  public EmployeeDTO(Long id, String name, String contractTypeName, Long roleId, String roleName,
                     Double hourlySalary, Double monthlySalary) {
    this.id = id;
    this.name = name;
    this.contractTypeName = contractTypeName;
    this.roleId = roleId;
    this.roleName = roleName;
    this.hourlySalary = hourlySalary;
    this.monthlySalary = monthlySalary;
  }

  /** Employee Id*/
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  /** Employee Name*/
  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  /** Type of Contract*/
  public String getContractTypeName() {
    return contractTypeName;
  }

  public void setContractTypeName(String contractTypeName) {
    this.contractTypeName = contractTypeName;
  }

  /** Role Id*/
  public Long getRoleId() {
    return roleId;
  }

  public void setRoleId(Long roleId) {
    this.roleId = roleId;
  }

  /** Role Name*/
  public String getRoleName() {
    return roleName;
  }

  public void setRoleName(String roleName) {
    this.roleName = roleName;
  }

  /** Hourly Salary Value*/
  public Double getHourlySalary() {
    return hourlySalary;
  }

  public void setHourlySalary(Double hourlySalary) {
    this.hourlySalary = hourlySalary;
  }

  /** Monthly Salary Value*/
  public Double getMonthlySalary() {
    return monthlySalary;
  }

  public void setMonthlySalary(Double monthlySalary) {
    this.monthlySalary = monthlySalary;
  }

  /** Annual Salary Value*/
  public Double getAnnualSalary() {
    return AnnualSalary;
  }

  public void setAnnualSalary(Double annualSalary) {
    AnnualSalary = annualSalary;
  }

  @Override
  public String toString() {
    return "EmployeeDTO{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", contractTypeName='" + contractTypeName + '\'' +
        ", roleId=" + roleId +
        ", roleName='" + roleName + '\'' +
        ", hourlySalary=" + hourlySalary +
        ", monthlySalary=" + monthlySalary +
        ", AnnualSalary=" + AnnualSalary +
        '}';
  }
}
