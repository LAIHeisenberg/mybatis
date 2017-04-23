package mybatis.test;

import mybatis.entities.Person;
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
 * Created by LaiDaShen on 2016/12/28.
 */
public class TestNativeMethod {

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
        Person person = (Person)sqlSession.selectOne("mybatis.dao.PersonDaoMapper.getPersonById", 1);
        System.out.println(person.getName());
    }

    @Test
    public void testSelectList(){
        List<Object> objects = sqlSession.selectList("mybatis.dao.PersonDaoMapper.getAllPerson");
        for (Object o : objects){
            Person person = (Person) o;
            System.out.println(person);
        }
    }

    @Test
    public void testInsert(){
        Person newPerson = new Person();
        newPerson.setName("WANG5");
        newPerson.setAge(15);
        sqlSession.insert("mybatis.dao.PersonDaoMapper.addPerson",newPerson);
    }

    @Test
    public void testUpdate(){

        Person person = new Person();
        person.setName("zhangsan");
        person.setAge(12);
        person.setId(1);
        sqlSession.update("mybatis.dao.PersonDaoMapper.updatePerson",person);
    }

    @Test
    public void testDelete(){

        sqlSession.delete("mybatis.dao.PersonDaoMapper.removePerson", 7);
    }
}
