package andreea.tema10;

import andreea.tema10.dao.DepartmentDAO;
import andreea.tema10.dao.DepartmentDAOImpl;
import andreea.tema10.dao.EmployeeDAO;
import andreea.tema10.dao.EmployeeDAOImpl;
import andreea.tema10.model.Department;
import andreea.tema10.model.Employee;

import java.sql.Date;
import java.time.LocalDate;

public class EmployeeDAOmain {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = new EmployeeDAOImpl();
        employeeDAO.findAll().forEach(System.out::println);
//        employeeDAO.createEmployee(new Employee("DESIGNER","JACK",7945,0,750,120,20, Date.valueOf("2021-05-03")));
        employeeDAO.delete(7945);
        employeeDAO.createEmployee(new Employee("DESIGNER","JACK",7945,7902,750,120,20, Date.valueOf("2021-05-03")));
        employeeDAO.findEmployeeByNameContaining("JACK");
        employeeDAO.updateEmployeeSalary(3000,7945);

        DepartmentDAO departmentDAO = new DepartmentDAOImpl();
        departmentDAO.findAll().forEach(System.out::println);
        departmentDAO.createDepartment(new Department(50,"IT","BUCURESTI"));
        departmentDAO.findDepartmentByNumber(20);
        departmentDAO.updateDepartmentCity("BRASOV",50);
        departmentDAO.deleteDepartmentByNumber(50);



    }



}
