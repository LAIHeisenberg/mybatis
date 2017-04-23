package mybatis.dao;

import mybatis.entities.Employee;

import java.util.List;

/**
 * Created by LaiDaShen on 2017/1/3.
 */
public interface EmployeeMapper {

    void addEmployee(Employee employee);

    List<Employee> getEmployeeByDeptId(int deptId);

    Employee getEmployeeById(int id);


}
