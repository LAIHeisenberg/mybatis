package mybatis.test;

import mybatis.dao.CatMapper;
import mybatis.dao.PersonDaoMapper;
import mybatis.entities.Cat;
import mybatis.entities.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;


import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public class HelloMybatis {

    private SqlSessionFactory sqlSessionFactory = null;

    @Test
    public void testAdd() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        Person person = new Person();
        person.setName("陈奕迅");
        person.setAge(41);
        person.setRegisteredDate(new Date());
        mapper.addPerson(person);
        System.out.println(person.getId());
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void testSelect() throws IOException {

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        Person person = mapper.getPersonById(9);
        System.out.println(person);
    }

    @Test
    public void testSelectMap() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("name","zhao6");
        paramMap.put("age",31);
        Person person = mapper.getPersonByMap(paramMap);
        System.out.println(person.getId());
    }

    @Test
    public void testSelectAll() throws IOException{
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        List<Person> persons = mapper.getAllPerson();
        for (Person person : persons){
            System.out.println(person.getName());
        }
    }

    @Test
    public void testRemove() throws IOException{
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        mapper.removePerson(3);
        sqlSession.commit();
    }
    
    @Test
    public void testUpdate()throws IOException{
        
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        PersonDaoMapper mapper = sqlSession.getMapper(PersonDaoMapper.class);
        Person person = new Person();
        person.setName("CC");
        person.setAge(66);
        person.setId(1);
        person.setRegisteredDate(null);
        mapper.updatePerson(person);
        sqlSession.commit();
    }

    @Test
    public void testGetCat() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat cat = mapper.getCatById(2);
        System.out.println(cat.getDescription());
    }

    @Test
    public void testUpdateCat() throws IOException {
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CatMapper mapper = sqlSession.getMapper(CatMapper.class);
        Cat whiteCat = new Cat();
        whiteCat.setDescription("white_cat");
        whiteCat.setId(1);
        Cat blackCat = new Cat();
        blackCat.setDescription("black_cat");
        blackCat.setId(2);
        mapper.updateCat(blackCat);
        mapper.updateCat(whiteCat);
        sqlSession.commit();
        sqlSession.close();
    }

}
