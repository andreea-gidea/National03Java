package andreea.tema10.dao;

import andreea.tema10.model.Department;
import andreea.tema10.model.Employee;

import java.util.List;

public interface DepartmentDAO {
    List<Department> findAll();
    void createDepartment(Department department);
    Department findDepartmentByNumber(int deptNumber);
    void updateDepartmentCity( String city , int deptNumber);
    void deleteDepartmentByNumber(int no);
}
