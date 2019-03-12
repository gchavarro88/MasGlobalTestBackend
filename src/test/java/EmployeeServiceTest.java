import com.guschaor.common.dto.EmployeeDTO;
import com.guschaor.repository.IEmployeeRepository;
import com.guschaor.service.IEmployeeService;
import com.guschaor.service.impl.EmployeeServiceImpl;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

public class EmployeeServiceTest {
  private EmployeeDTO employeeDTO1;
  private EmployeeDTO employeeDTO2;
  private List<EmployeeDTO> listEmployees;

  @Mock
  private IEmployeeRepository  employeeRepository;

  private IEmployeeService employeeService;

  @Before
  public void init(){
    MockitoAnnotations.initMocks(this);
    employeeDTO1 = new EmployeeDTO(1L, "Juan", "HourlySalaryEmployee",
        1L, "Administrator", 60000D, 80000D);
    employeeDTO2 = new EmployeeDTO(2L, "Sebastian", "MonthlySalaryEmployee",
        1L, "Contractor", 60000D, 80000D);
    listEmployees = Arrays.asList(employeeDTO1, employeeDTO2);
    employeeService = new EmployeeServiceImpl(employeeRepository);
  }

  @Test
  public void getAllEmployeesSuccessFullTest(){
    Mockito.when(employeeRepository.getAllEmployes()).thenReturn(Optional.of(listEmployees));

    List<EmployeeDTO> result = employeeService.getAllEmployees();

    Assert.assertNotNull(result);
    Assert.assertEquals(result.size(), 2);
  }

  @Test
  public void getAllEmployeesWithOutDataTest(){
    Mockito.when(employeeRepository.getAllEmployes()).thenReturn(Optional.empty());

    List<EmployeeDTO> result = employeeService.getAllEmployees();

    Assert.assertNull(result);
  }

  @Test
  public void getEmployeeByIdSuccessFullTest(){
    Mockito.when(employeeRepository.getAllEmployes()).thenReturn(Optional.of(listEmployees));

    EmployeeDTO result = employeeService.getEmployeeById(1L);

    Assert.assertNotNull(result);
    Assert.assertEquals(listEmployees.get(0), result);
  }

  @Test(expected = NoSuchElementException.class)
  public void getEmployeesByIdWithOutDataTest(){
    Mockito.when(employeeRepository.getAllEmployes()).thenReturn(Optional.of(listEmployees));

    EmployeeDTO result = employeeService.getEmployeeById(3L);

    Assert.assertNull(result);
  }
}
