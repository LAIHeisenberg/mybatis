package mybatis.dao;

import mybatis.entities.Department;

/**
 * Created by LaiDaShen on 2017/1/3.
 */
public interface DepartmentMapper {

    void addDepartment(Department department);

    Department getDepartmentById(int id);

}
