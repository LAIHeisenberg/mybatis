package mybatis.dao;

import mybatis.entities.Cat;


/**
 * Created by LaiDaShen on 2016/12/28.
 */
public interface CatMapper {

    Cat getCatById(int id);
    void updateCat(Cat cat);

}
