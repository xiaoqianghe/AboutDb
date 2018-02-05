package com.xiaoqianghe.aboutdb.aboutdbcode.data;

import io.realm.RealmObject;

/**
 * Author：Wq
 * Date：2018/2/1 17:20
 * Description：//todo
 */

public class Dog extends RealmObject {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
