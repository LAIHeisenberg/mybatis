package mybatis.test;

import mybatis.dao.KeyMapper;
import mybatis.dao.LockMapper;
import mybatis.entities.Key;
import mybatis.entities.Lock;
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
public class TestOneToOne {

    SqlSessionFactory sqlSessionFactory;
    SqlSession sqlSession;

    @Before
    public void init() throws IOException {

        sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        sqlSession = sqlSessionFactory.openSession();

    }
    @After
    public void after(){
//        sqlSession.commit();
//        sqlSession.close();
    }

    @Test
    public void testGetKey(){
        KeyMapper mapper = sqlSession.getMapper(KeyMapper.class);
        Key key = mapper.getKeyById(1);
        System.out.println(key.getKeyName());
    }

    @Test
    public void testGetLock(){
        LockMapper mapper = sqlSession.getMapper(LockMapper.class);
        Lock lock = mapper.getLockById(3);
        System.out.println(lock);
    }
}
