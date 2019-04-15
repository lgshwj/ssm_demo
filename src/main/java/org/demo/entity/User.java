package org.demo.entity;

/**
 * Created with IDEA
 * author:ligang
 * Date:2019/4/15
 * Time:11:27
 * Description:
 */
public class User {

    private int id;//id

    private String userName;//用户名

    private String password;//密码

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
