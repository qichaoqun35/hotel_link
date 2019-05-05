package com.example.qichaoqun.amerilink.bean;

import android.text.Editable;

/**
 * @author qichaoqun
 * @date 2018/9/4
 */
public class Passenger {
    public Passenger(){}
    private String sex;

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getType() {
        return type;
    }

    public Passenger(String sex, String lastName, String firstName, String age, String type) {
        this.sex = sex;
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
        this.type = type;
    }

    public void setType(String type) {
        this.type = type;

    }

    //名字
    private String lastName;
    //姓氏
    private String firstName;
    private String age;
    private String type;
}
