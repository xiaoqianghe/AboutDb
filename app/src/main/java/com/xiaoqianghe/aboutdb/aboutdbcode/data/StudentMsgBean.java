package com.xiaoqianghe.aboutdb.aboutdbcode.data;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;

/**
 * Author：Wq
 * Date：2018/2/5 14:23
 * Description：//todo
 */
@Entity
public class StudentMsgBean {

    @Id
    private Long id;
    @Property(nameInDb = "STUDENTNUM")
    private String studentNum;
    @Property(nameInDb = "NAME")
    private String name;

    private String age;

//    @Generated(hash = 1573154658)

    @Generated(hash = 1304458862)
    public StudentMsgBean(long Id,String studentNum, String name, String age) {
        this.id=Id;
        this.studentNum = studentNum;
        this.name = name;
        this.age = age;
    }


    @Generated(hash = 160565988)
    public StudentMsgBean() {
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStudentNum() {
        return studentNum;
    }

    public void setStudentNum(String studentNum) {
        this.studentNum = studentNum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
