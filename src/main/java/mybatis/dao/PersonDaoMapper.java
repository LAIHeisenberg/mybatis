package mybatis.dao;

import mybatis.entities.Person;

import java.util.List;
import java.util.Map;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public interface PersonDaoMapper {

    void addPerson(Person person);
    Person getPersonById(int id);
    Person getPersonByMap(Map<String,Object> paramMap);
    void updatePerson(Person person);
    void removePerson(int id);
    List<Person> getAllPerson();


}
