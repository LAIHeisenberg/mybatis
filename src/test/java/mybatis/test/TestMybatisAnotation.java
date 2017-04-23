package mybatis.test;

import mybatis.dao.PersonDaoAnotation;
import mybatis.entities.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.CORBA.PERSIST_STORE;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public class TestMybatisAnotation {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();

    }
    @After
    public void after(){
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect(){

        PersonDaoAnotation mapper = sqlSession.getMapper(PersonDaoAnotation.class);
        Person person = mapper.getPersonById(1);
        System.out.println(person.getName());
    }



    @Test
    public void testInsert(){
        Person person = new Person();
        person.setName("zhao6");
        person.setAge(31);
        person.setRegisteredDate(new Date());
        PersonDaoAnotation mapper = sqlSession.getMapper(PersonDaoAnotation.class);
        mapper.addPerson(person);
    }

    @Test
    public void testUpdate() throws ParseException {

        Person person = new Person();
        person.setRegisteredDate(new SimpleDateFormat("yyyy-MM-dd").parse("2016-07-26"));
        PersonDaoAnotation mapper = sqlSession.getMapper(PersonDaoAnotation.class);
        person.setName("zhangsan");
        person.setId(1);
        mapper.updatePerson(person);
    }

    @Test
    public void testDelete(){

        PersonDaoAnotation mapper = sqlSession.getMapper(PersonDaoAnotation.class);
        mapper.removePerson(6);
    }
}
