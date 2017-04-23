package mybatis.entities;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public class Cat {

    private int id;
    private String description;

    public Cat(){

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "id=" + id +
                ", cat_desc='" + description + '\'' +
                '}';
    }
}
