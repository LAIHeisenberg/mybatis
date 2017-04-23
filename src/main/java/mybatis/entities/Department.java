package mybatis.entities;

import java.util.List;

/**
 * Created by LaiDaShen on 2017/1/3.
 */
public class Department {

    private int id;
    private String deptName;
    private List<Employee> employeeList;

    public Department(){}

    public Department(String deptName){
        this.deptName = deptName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", deptName='" + deptName + '\'' +
                ", employeeList=" + employeeList +
                '}';
    }
}
