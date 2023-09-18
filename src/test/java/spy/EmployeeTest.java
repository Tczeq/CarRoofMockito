package spy;

import org.junit.Test;
import org.mockito.BDDMockito;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class EmployeeTest {


    // mocki nie maja funkcjonalnosci z klasy Employee i temu nazywa sie to jako atrapa
    // to udaje klase ale ona nie wie co jest w tej klasie
    @Test
    public void shouldReturnSalaryMock() {
        Employee employee = Mockito.mock(Employee.class);
        BDDMockito.given(employee.getBonus()).willReturn(1000.0);
        System.out.println(employee.getBonus());
        System.out.println(employee.getSalary());

        List<String> list = Mockito.mock(ArrayList.class);
        list.add("a");
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.size());
    }


    // a spy to nadali taki mock ale tutaj go uczymy tych funkcjonalnosci z klasy np. Employee
    @Test
    public void shouldReturnSalarySpy() {
        Employee employee = Mockito.spy(Employee.class);
        BDDMockito.given(employee.getBonus()).willReturn(1000.0);
        System.out.println(employee.getSalary());

        List<String> list = Mockito.spy(ArrayList.class);
        list.add("a");
        list.add("a");
        list.add("a");
        System.out.println(list.size());

    }

}