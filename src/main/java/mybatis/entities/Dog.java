package mybatis.entities;

/**
 * Created by LaiDaShen on 2016/12/28.
 */
public class Dog {

    private int id;
    private String dogName;
    private int dogAge;
    private String dogColor;
    private boolean dogSexy;

    public Dog(){}

    public Dog(String dogName, int dogAge, String dogColor, boolean dogSexy) {
        this.dogName = dogName;
        this.dogAge = dogAge;
        this.dogColor = dogColor;
        this.dogSexy = dogSexy;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDogName() {
        return dogName;
    }

    public void setDogName(String dogName) {
        this.dogName = dogName;
    }

    public int getDogAge() {
        return dogAge;
    }

    public void setDogAge(int dogAge) {
        this.dogAge = dogAge;
    }

    public String getDogColor() {
        return dogColor;
    }

    public void setDogColor(String dogColor) {
        this.dogColor = dogColor;
    }

    public boolean isDogSexy() {
        return dogSexy;
    }

    public void setDogSexy(boolean dogSexy) {
        this.dogSexy = dogSexy;
    }
}
