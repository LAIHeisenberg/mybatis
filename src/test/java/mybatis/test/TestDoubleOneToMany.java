package mybatis.test;

import mybatis.dao.DepartmentMapper;
import mybatis.dao.EmployeeMapper;
import mybatis.entities.Department;
import mybatis.entities.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * Created by LaiDaShen on 2017/1/3.
 */
public class TestDoubleOneToMany {

    private SqlSession sqlSession;

    @Before
    public void init() throws IOException {
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }

    @After
    public void release(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void insertDepartment(){
        Department dept1 = new Department("AAA");
        Department dept2 = new Department("BBB");
        Department dept3 = new Department("CCC");
        Department dept4 = new Department("DDD");

        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        mapper.addDepartment(dept1);
        mapper.addDepartment(dept2);
        mapper.addDepartment(dept3);
        mapper.addDepartment(dept4);
    }

    @Test
    public void insertEmployee(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee emp1 = new Employee();
        emp1.setName("laihuiying");
        emp1.setSalary(26000);
        Department dept1 = new Department();
        dept1.setDeptName("AAA");
        dept1.setId(1);
        emp1.setDepartment(dept1);
        mapper.addEmployee(emp1);

    }

    @Test
    public void testGetEmployee(){

        EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
        Employee employee = mapper.getEmployeeById(1);
        System.out.println(employee.getName());
        System.out.println("-----------------------");
        Department dept = employee.getDepartment();
        System.out.println(employee.getDepartment().getDeptName());
        System.out.println("-----------------------");
        List<Employee> employeeList = dept.getEmployeeList();
        for (Employee e : employeeList){
            System.out.println(e.getName());
        }

    }

    @Test
    public void testGetDepartment(){
        DepartmentMapper mapper = sqlSession.getMapper(DepartmentMapper.class);
        Department dept = mapper.getDepartmentById(2);
        System.out.println(dept.getDeptName());

        List<Employee> employeeList = dept.getEmployeeList();
        for (Employee employee : employeeList){
            System.out.println(employee.getId() +" : " + employee.getName());
        }
    }


}
