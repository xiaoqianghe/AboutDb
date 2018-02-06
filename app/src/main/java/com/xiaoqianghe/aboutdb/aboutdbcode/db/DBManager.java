package com.xiaoqianghe.aboutdb.aboutdbcode.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.xiaoqianghe.aboutdb.aboutdbcode.data.DaoMaster;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.DaoSession;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.StudentMsgBean;
import com.xiaoqianghe.aboutdb.aboutdbcode.data.StudentMsgBeanDao;


import org.greenrobot.greendao.query.QueryBuilder;

import java.util.List;


/**
 * <p>Description:
 *
 * @author xzhang
 */

public class DBManager {

    private static DBManager instance ;
    private final static String dbName = "test_db";

    private Context mContext ;
////
    private DaoMaster.DevOpenHelper openHelper = null ;
////
//
    private DBManager(Context context){
        this.mContext = context ;
        openHelper = new DaoMaster.DevOpenHelper(context,dbName);
    }
//
//
//    private DaoMaster.DevOpenHelper openHelper = null ;
//
    public static DBManager getInstance(Context context){
        if(instance == null){
            synchronized (DBManager.class){
                if(instance == null){
                    instance = new DBManager(context);
                }
            }
        }
        return instance ;
    }

    private SQLiteDatabase getWriteableDatabase(){
        if(openHelper == null){
            openHelper = new DaoMaster.DevOpenHelper(mContext,dbName);
        }
        return openHelper.getWritableDatabase();
    }
    private SQLiteDatabase getRedadableDatabase(){
        if(openHelper == null){
            openHelper = new DaoMaster.DevOpenHelper(mContext,dbName);
        }
        return openHelper.getReadableDatabase() ;
    }


    //增加
    public void saveUser(StudentMsgBean user){
        DaoMaster daoMaster = new DaoMaster(getWriteableDatabase());
        DaoSession daoSession = daoMaster.newSession();


        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        //存入user对象
        userDao.save(user);

    }
// 删除
    public void saveUsers(List<StudentMsgBean> users){
        DaoMaster daoMaster = new DaoMaster(getWriteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        userDao.saveInTx(users);
    }

    public void delteUser(StudentMsgBean user){
        DaoMaster daoMaster = new DaoMaster(getWriteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        userDao.delete(user);
    }
//
    public void updateUser(StudentMsgBean user){
        DaoMaster daoMaster = new DaoMaster(getWriteableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        userDao.update(user);
    }

    public List<StudentMsgBean> queryUser(){
        DaoMaster daoMaster = new DaoMaster(getRedadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        QueryBuilder<StudentMsgBean> qb = userDao.queryBuilder();
        List<StudentMsgBean> list = qb.list();
        return list ;
    }

    public List<StudentMsgBean> queryUser(int age){
        DaoMaster daoMaster = new DaoMaster(getRedadableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        StudentMsgBeanDao userDao = daoSession.getStudentMsgBeanDao();
        QueryBuilder<StudentMsgBean> qb = userDao.queryBuilder();
        //添加查询条件
        qb.where(StudentMsgBeanDao .Properties.Age.eq(age));
        List<StudentMsgBean> list = qb.list();
        return list ;
    }
//



}
