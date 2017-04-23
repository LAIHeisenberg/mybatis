package mybatis.dao;

import mybatis.entities.Person;
import org.apache.ibatis.annotations.*;


/**
 * Created by LaiDaShen on 2016/12/28.
 */
public interface PersonDaoAnotation {

    @Insert("insert into tbl_person(name,age,registeredDate)VALUES (#{name},#{age},#{registeredDate})")
    void addPerson(Person person);

    @Select("select `id`,`name`,`age`,`registeredDate` from tbl_person where `id` = #{id}")
    @ResultType(value = Person.class)
    Person getPersonById(int id);

    @Update("update tbl_person set `name`= #{name},`age`=#{age}, `registeredDate`=#{registeredDate} where `id`=#{id}")
    void updatePerson(Person person);

    @Delete("Delete from tbl_person where id = #{id}")
    void removePerson(int id);

}
