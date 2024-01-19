package kg.mega.shop.models;

import java.util.Date;

public class Category {
    private int id;
    private String name;
    private boolean isActive;
    private Date createDate;

    public Category(int id,String name, boolean isActive) {
        this.id = id;
        this.name = name;
        this.isActive = isActive;
        this.createDate = new Date();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date creatDate) {
        this.createDate = creatDate;
    }

    @Override
    public String toString() {
        return getName();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
