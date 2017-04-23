package mybatis.entities;

/**
 * Created by LaiDaShen on 2016/12/29.
 */
public class Key {

    private int id;
    private String keyName;

    public Key(){}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKeyName() {
        return keyName;
    }

    public void setKeyName(String keyName) {
        this.keyName = keyName;
    }

    @Override
    public String toString() {
        return "Key{" +
                "id=" + id +
                ", keyName='" + keyName + '\'' +
                '}';
    }
}
