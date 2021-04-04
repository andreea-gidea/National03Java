package andreea.tema10.dao;

import andreea.tema10.model.Employee;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class EmployeeDAOImpl implements EmployeeDAO {
    @Override
    public List<Employee> findAll() {
        List<Employee> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM EMP";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Employee employee = Employee.builder()
                        .employeeNo(resultSet.getInt("EMPNO"))
                        .name(resultSet.getString("ENAME"))
                        .job(resultSet.getString("JOB"))
                        .employeeManager(resultSet.getInt("MGR"))
                        .hireDate(resultSet.getDate("HIREDATE"))
                        .employeeSalary(resultSet.getInt("SAL"))
                        .employeeComm(resultSet.getInt("COMM"))
                        .employeeDepartmentNo(resultSet.getInt("DEPTNO"))
                        .build();
                employeeList.add(employee);
            }

            try {
                connection.commit();
            } catch (SQLException e) {
                connection.rollback();
            }
        } catch (SQLException ex) {

            log.error(ex);
        }

        return employeeList;
    }

    @Override
    public void createEmployee(Employee employee) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO EMP (EMPNO, ENAME, JOB, MGR,HIREDATE, SAL,COMM,DEPTNO) VALUES\n" +
                    "(?, ?, ?, ?, ? , ? , ? , ? )";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employee.getEmployeeNo());
            preparedStatement.setString(2, employee.getName());
            preparedStatement.setString(3, employee.getJob());
            preparedStatement.setInt(4, employee.getEmployeeManager());
            preparedStatement.setDate(5, employee.getHireDate());
            preparedStatement.setInt(6, employee.getEmployeeSalary());
            preparedStatement.setInt(7, employee.getEmployeeComm());
            preparedStatement.setInt(8, employee.getEmployeeDepartmentNo());


            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public Employee findEmployeeByNameContaining(String s) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT EMPNO, SAL, ENAME, JOB FROM EMP e WHERE e.ENAME LIKE ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, s);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Employee.builder()
                        .employeeNo(resultSet.getInt("EMPNO"))
                        .employeeSalary(resultSet.getInt("SAL"))
                        .name(resultSet.getString("ENAME"))
                        .job(resultSet.getString("JOB"))
                        .build());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }


    @Override
    public void delete(int no) {

        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM EMP WHERE EMPNO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    //
    @Override
    public void updateEmployeeSalary(int newSal, int id) {
        try (Connection connection = getConnection()) {
            String sql = "UPDATE EMP SET SAL=? WHERE EMPNO=?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, newSal);
            preparedStatement.setInt(2, id);

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);
        } catch (SQLException ex) {
            log.error(ex);
        }
        return;
    }

    private Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/hr",
                    "root",
                    "root");

        } catch (SQLException e) {
            log.error(e);
        }
        return null;
    }
}
