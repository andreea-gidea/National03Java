package andreea.tema10.dao;

import andreea.tema10.model.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
    void createEmployee(Employee employee);
    Employee findEmployeeByNameContaining(String name);
    void updateEmployeeSalary(int newSal, int id );
    void delete(int no);
}
