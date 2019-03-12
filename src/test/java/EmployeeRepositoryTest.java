import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.repository.IEmployeeRepository;
import com.guschaor.repository.impl.EmployeeRepositoryImpl;
import com.guschaor.service.IEmployeeService;
import com.guschaor.service.impl.EmployeeServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

public class EmployeeRepositoryTest {

  private EmployeeDTO employeeDTO1;
  private EmployeeDTO employeeDTO2;
  private List<EmployeeDTO> listEmployees;
  private String CORRECT_URL = "http://masglobaltestapi.azurewebsites.net/api/employees";
  private String FAIL_URL = "http://masglobaltestapi.azurewebsites.net/api/";
  private IEmployeeRepository  employeeRepository;

  @Before
  public void init(){
    MockitoAnnotations.initMocks(this);
    employeeDTO1 = new EmployeeDTO(1L, "Juan", "HourlySalaryEmployee",
        1L, "Administrator", 60000D, 80000D);
    employeeDTO2 = new EmployeeDTO(2L, "Sebastian", "MonthlySalaryEmployee",
        2L, "Contractor", 60000D, 80000D);
    employeeDTO1.setAnnualSalary(86400000D);
    employeeDTO2.setAnnualSalary(960000D);
    listEmployees = Arrays.asList(employeeDTO1, employeeDTO2);
  }

  @Test
  public void getAllEmployesTest(){
    employeeRepository = new EmployeeRepositoryImpl(CORRECT_URL);
    Optional<List<EmployeeDTO>> result = employeeRepository.getAllEmployes();
    if(result.isPresent()){
      Assert.assertNotNull(result.get());
      Assert.assertEquals(result.get().get(0).getId(), listEmployees.get(0).getId());
      Assert.assertEquals(result.get().get(0).getName(), listEmployees.get(0).getName());
      Assert.assertEquals(result.get().get(0).getRoleName(), listEmployees.get(0).getRoleName());
      Assert.assertEquals(result.get().get(0).getRoleId(), listEmployees.get(0).getRoleId());
      Assert.assertEquals(result.get().get(0).getHourlySalary(), listEmployees.get(0).getHourlySalary());
      Assert.assertEquals(result.get().get(0).getMonthlySalary(), listEmployees.get(0).getMonthlySalary());
      Assert.assertEquals(result.get().get(0).getAnnualSalary(), listEmployees.get(0).getAnnualSalary());

      Assert.assertEquals(result.get().get(1).getId(), listEmployees.get(1).getId());
      Assert.assertEquals(result.get().get(1).getName(), listEmployees.get(1).getName());
      Assert.assertEquals(result.get().get(1).getRoleName(), listEmployees.get(1).getRoleName());
      Assert.assertEquals(result.get().get(1).getRoleId(), listEmployees.get(1).getRoleId());
      Assert.assertEquals(result.get().get(1).getHourlySalary(), listEmployees.get(1).getHourlySalary());
      Assert.assertEquals(result.get().get(1).getMonthlySalary(), listEmployees.get(1).getMonthlySalary());
      Assert.assertEquals(result.get().get(1).getAnnualSalary(), listEmployees.get(1).getAnnualSalary());
    }
  }

  @Test(expected = Exception.class)
  public void getAllEmployesTestNotPresent(){
    employeeRepository = new EmployeeRepositoryImpl(FAIL_URL);
    Optional<List<EmployeeDTO>> result = employeeRepository.getAllEmployes();
    Assert.assertEquals(Optional.empty(), result);
  }
}
