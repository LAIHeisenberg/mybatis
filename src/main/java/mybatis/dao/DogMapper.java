package mybatis.dao;

import mybatis.entities.Dog;

import java.util.Map;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public interface DogMapper {

    void addDog(Dog dog);
    Map<String,Object> getDogInfo(Map<String,Object> paramMap);
}
