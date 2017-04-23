package mybatis.test;

import com.sun.deploy.resources.Deployment_pt_BR;
import mybatis.dao.DogMapper;
import mybatis.entities.Dog;
import mybatis.entities.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public class TestDog {

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
    public void testAddDog(){

        DogMapper mapper = sqlSession.getMapper(DogMapper.class);

        mapper.addDog(new Dog("旺财",3,"棕色",true));
        mapper.addDog(new Dog("闹闹",4,"白色",true));
        mapper.addDog(new Dog("哮天犬",3,"金色",false));
        Dog qiuqiu = new Dog("球球",5,"褐色",false);
        mapper.addDog(qiuqiu);

    }

    @Test
    public void testDogInfo(){

        Map<String,Object> paramMap = new HashMap<>();
        paramMap.put("dogAge",3);
        paramMap.put("dogSexy",true);
        DogMapper mapper = sqlSession.getMapper(DogMapper.class);
        Map<String, Object> dogInfoMap = mapper.getDogInfo(paramMap);
        Set<Map.Entry<String, Object>> entries = dogInfoMap.entrySet();
        for (Map.Entry<String,Object> entry : entries){
            System.out.println(entry.getKey() + " --- "+ entry.getValue());
        }
    }
}
