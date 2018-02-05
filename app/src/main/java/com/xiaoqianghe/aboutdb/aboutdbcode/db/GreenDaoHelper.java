package com.xiaoqianghe.aboutdb.aboutdbcode.db;

import android.content.Context;
import android.text.StaticLayout;
import android.util.Log;

import com.xiaoqianghe.aboutdb.aboutdbcode.data.DaoMaster;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.DaoSession;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.StudentMsgBean;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.StudentMsgBeanDao;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Author：Wq
 * Date：2018/2/5 14:34
 * Description：//todo
 */

public class GreenDaoHelper {

    private String DB_NAME;
    private static GreenDaoHelper instance;
    private DaoSession mDaoSession;





    public static GreenDaoHelper getInstance(Context mContext) {
        if (instance == null) {
            synchronized (RealmHelper.class) {
                if (instance == null)
                    instance = new GreenDaoHelper(mContext);
            }
        }
        return instance;
    }


    public GreenDaoHelper(Context mContext) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(mContext, "student.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        mDaoSession= daoMaster.newSession();

    }


    private DaoSession getDaoSession(){
        return mDaoSession;
    }



    public void initGreenDaoData(Context context){

        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(context, "student.db", null);
        DaoMaster daoMaster = new DaoMaster(devOpenHelper.getWritableDb());
        DaoSession daoSession = daoMaster.newSession();
    }


    //添加数据
    public void addData(){
        StudentMsgBeanDao msgBeanDao = getDaoSession().getStudentMsgBeanDao();
        StudentMsgBean studentMsgBean = new StudentMsgBean();
        studentMsgBean.setName("zone");
        studentMsgBean.setStudentNum("123456");
        msgBeanDao.insert(studentMsgBean);
    }


    //删除数据
    public void deletedData(){
        List<StudentMsgBean> list = getDaoSession().getStudentMsgBeanDao().queryBuilder()
                .build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber: " + list.get(i).getStudentNum());
            Log.d("zoneLog", "name: " + list.get(i).getName());
            if (i == 0) {
                getDaoSession().getStudentMsgBeanDao().deleteByKey(list.get(0).getId());//通过 Id 来删除数据
//                        msgBeanDao.delete(list.get(0));//通过传入实体类的实例来删除数据
            }

        }
    }



    //修改数据
    public void modifyData(){
        List<StudentMsgBean> list = getDaoSession().getStudentMsgBeanDao().queryBuilder()
                .build().list();
        for (int i = 0; i < list.size(); i++) {
            Log.d("zoneLog", "studentNumber: " + list.get(i).getStudentNum());
            Log.d("zoneLog", "name: " + list.get(i).getName());
            if (i == 0) {
                list.get(0).setName("zone==========>");
                getDaoSession().getStudentMsgBeanDao().update(list.get(0));
            }
        }
    }


    public  void queryData(){
        List<StudentMsgBean> list = getDaoSession().getStudentMsgBeanDao().queryBuilder()
                .offset(1)//偏移量，相当于 SQL 语句中的 skip
                .limit(3)//只获取结果集的前 3 个数据
                .orderAsc(StudentMsgBeanDao.Properties.StudentNum)//通过 StudentNum 这个属性进行正序排序
                .where(StudentMsgBeanDao.Properties.Name.eq("zone"))//数据筛选，只获取 Name = "zone" 的数据。
                .build()
                .list();

    }









}
