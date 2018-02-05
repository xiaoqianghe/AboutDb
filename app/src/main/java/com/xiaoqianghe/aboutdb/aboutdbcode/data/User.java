package com.xiaoqianghe.aboutdb.aboutdbcode.data;

import io.realm.RealmObject;

/**
 * Author：Wq
 * Date：2018/2/1 15:22
 * Description：//todo
 */

public class User extends RealmObject {

    private String id;

    private String name;
    private String age;



    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
