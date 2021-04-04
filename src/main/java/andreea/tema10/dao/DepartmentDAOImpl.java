package andreea.tema10.dao;

import andreea.tema10.model.Department;
import lombok.extern.log4j.Log4j2;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Log4j2
public class DepartmentDAOImpl implements DepartmentDAO{

    @Override
    public List<Department> findAll() {
        List<Department> employeeList = new ArrayList<>();
        String sql = "SELECT * FROM dept";
        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            connection.setAutoCommit(false);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Department department = Department.builder()
                        .departmentNumber(resultSet.getInt("DEPTNO"))
                        .departmentName(resultSet.getString("DNAME"))
                        .city(resultSet.getString("CITY"))
                        .build();
                employeeList.add(department);
            }

            try {
                connection.commit();
            } catch (SQLException e){
                connection.rollback();
            }
        } catch (SQLException ex) {

            log.error(ex);
        }

        return employeeList;
    }

    @Override
    public void createDepartment(Department department) {
        try (Connection connection = getConnection()) {
            String sql = "INSERT INTO dept (DEPTNO, DNAME, CITY) VALUES\n" +
                    "(?, ?, ?)";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, department.getDepartmentNumber());
            preparedStatement.setString(2, department.getDepartmentName());
            preparedStatement.setString(3, department.getCity());

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public Department findDepartmentByNumber(int deptNumber) {
        try (Connection connection = getConnection()) {
            String sql = "SELECT DEPTNO, DNAME, CITY FROM dept e WHERE e.DEPTNO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, deptNumber);

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                System.out.println(Department.builder()
                        .departmentNumber(resultSet.getInt("DEPTNO"))
                        .departmentName(resultSet.getString("DNAME"))
                        .city(resultSet.getString("CITY"))
                        .build());
            }
        } catch (SQLException ex) {
            log.error(ex);
        }
        return null;
    }

    @Override
    public void updateDepartmentCity( String City,int deptNo) {
        try (Connection connection = getConnection()) {
            String sql = " UPDATE DEPT SET CITY=? WHERE DEPTNO=?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, City);
            preparedStatement.setInt(2, deptNo);

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);
        } catch (SQLException ex) {
            log.error(ex);
        }
    }

    @Override
    public void deleteDepartmentByNumber(int no) {

        try (Connection connection = getConnection()) {
            String sql = "DELETE FROM DEPT WHERE DEPTNO = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, no);

            int affectedRows = preparedStatement.executeUpdate();

            System.out.println(affectedRows);

        } catch (SQLException ex) {
            log.error(ex);
        }
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
