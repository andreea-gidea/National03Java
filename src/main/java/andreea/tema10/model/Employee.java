package andreea.tema10.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.sql.Date;

@AllArgsConstructor
@Builder
@Data
public class Employee {
    private String job;
    private String name;
    private int employeeNo;
    private int employeeManager;
    private int employeeSalary;
    private int employeeComm;
    private int employeeDepartmentNo;
    private Date hireDate;
}
