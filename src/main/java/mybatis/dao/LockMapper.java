package mybatis.dao;

import mybatis.entities.Lock;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public interface LockMapper {

    Lock getLockById(int id);
}
