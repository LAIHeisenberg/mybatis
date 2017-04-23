package mybatis.test;

import mybatis.dao.StudentMapper;
import mybatis.entities.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public class TestDynamicSql {
    
    private SqlSessionFactory sqlSessionFactory;
    private SqlSession sqlSession;
    
    @Before
    public void init() throws IOException {
        
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();
    }
    @After
    public void release(){
        sqlSession.commit();
        sqlSession.close();
    }
    
    @Test
    public void testIfOneParam(){

        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.exerciseIfOneParam(1);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testIfMultiParams(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> students = mapper.exerciseIfMultiParam(90, 18);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testWhere() throws ParseException {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student stu = new Student();
        stu.setScore(75);
        stu.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("2000-04-21"));
        List<Student> students = mapper.exerciseWhere(stu);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testChooseWhenOtherwise(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("score",90);
        map.put("age",15);
        List<Student> students = mapper.exerciseChooseWhenOtherwise(map);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testForeach(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Map<String,Object> map = new HashMap<>();
        map.put("ages", Arrays.asList(15,16,17));
        List<Student> students = mapper.exerciseForeach(map);
        for (Student student : students){
            System.out.println(student.toString());
        }
    }

    @Test
    public void testExerciseTrim(){
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("乔梦欣");
        student.setScore(99);
        student.setAge(23);
        mapper.exerciseTrim(student);
        System.out.println(student.getId());
    }

    @Test
    public void testExerciseSet() throws ParseException {
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        Student student = new Student();
        student.setName("王祖蓝");
        student.setScore(87);
        student.setAge(34);
        student.setBirth(new SimpleDateFormat("yyyy-MM-dd").parse("1978-06-03"));
        student.setId(6);
        mapper.exerciseSet(student);
        System.out.println(student.getId());
    }



    
    
}
