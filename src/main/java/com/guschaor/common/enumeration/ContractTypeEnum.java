package com.guschaor.common.enumeration;

/**
 * Enum to manage the different types of contract.
 *
 * @author guschaor 11/03/2019.
 */
public enum ContractTypeEnum {

  /**
   * Value for hourly salary.
   */
  HOURLY_SALARY_EMPLOYEE("HourlySalaryEmployee"),

  /**
   * Value for monthly salary.
   */
  MONTHLY_SALARY_EMPLOYEE("MonthlySalaryEmployee");

  /**
   * Contract type.
   */
  private String type;

  /**
   * Instantiates a new Contract Type Enum.
   *
   * @param type contract type.
   */
  ContractTypeEnum(String type) {
    this.type = type;
  }

  /* (non-Javadoc)
   * @see java.lang.Enum#toString()
   */
  @Override
  public String toString() {
    return this.type;
  }
}
