package mybatis.entities;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public class Lock {

    private int id;
    private String lockName;
    private Key key;

    public Lock() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLockName() {
        return lockName;
    }

    public void setLockName(String lockName) {
        this.lockName = lockName;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return "Lock{" +
                "id=" + id +
                ", lockName='" + lockName + '\'' +
                ", key=" + key +
                '}';
    }
}
