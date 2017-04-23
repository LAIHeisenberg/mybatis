package mybatis.dao;

import mybatis.entities.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public interface StudentMapper {

    //if 单入参练习
    List<Student> exerciseIfOneParam(@Param("id") int id);
    //if 单入参练习
    List<Student> exerciseIfMultiParam(@Param("score") int score, @Param("age") int age);

    List<Student> exerciseWhere(Student student);

    List<Student> exerciseChooseWhenOtherwise(Map<String,Object> paramMap);

    List<Student> exerciseForeach(Map<String,Object> paramMap);

    void exerciseTrim(Student student);

    void exerciseSet(Student student);
}
