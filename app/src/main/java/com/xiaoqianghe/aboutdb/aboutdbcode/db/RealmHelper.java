package com.xiaoqianghe.aboutdb.aboutdbcode.db;

import com.xiaoqianghe.aboutdb.aboutdbcode.data.User;

import java.util.List;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Author：Wq
 * Date：2018/2/2 17:35
 * Description：//todo
 *
 *
 *
 */

public class RealmHelper implements  DBHelper{

    private String DB_NAME="wq_realm";

    private static RealmHelper instance;

    private Realm mRealm;




    public static RealmHelper getInstance() {
        if (instance == null) {
            synchronized (RealmHelper.class) {
                if (instance == null)
                    instance = new RealmHelper();
            }
        }
        return instance;
    }


    public RealmHelper() {
        mRealm = Realm.getInstance(new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .name(DB_NAME)
                .build());
    }


    public Realm getRealm() {
        if (mRealm == null || mRealm.isClosed())
            mRealm = Realm.getDefaultInstance();
        return mRealm;
    }

    /****************************************************************/

    /**
     * 增加 收藏记录
     *
     * @param bean
     */
    public void insertCollection(User bean) {
        getRealm().beginTransaction();
        getRealm().copyToRealm(bean);
        getRealm().commitTransaction();
    }


    /**
     * 删除
     *
     * @param id
     */
    public void deleteCollection(String id) {
        User data = getRealm().where(User.class).equalTo("id", id).findFirst();
        getRealm().beginTransaction();
        data.deleteFromRealm();
        getRealm().commitTransaction();
    }

    /**
     * 清空
     */
    public void deleteAllCollection() {
        getRealm().beginTransaction();
        getRealm().delete(User.class);
        getRealm().commitTransaction();
    }


    /**
     * 查询 收藏记录
     *
     * @param id
     * @return
     */
    public boolean queryCollectionId(String id) {
        RealmResults<User> results = getRealm().where(User.class).findAll();
        for (User item : results) {
            if (item.getId().equals(id)) {
                return true;
            }
        }
        return false;
    }


    /**
     *  列表
     *
     * @return
     */
    public List<User> getCollectionList() {
        //使用findAllSort ,先findAll再result.sort排序
        RealmResults<User> results = getRealm().where(User.class).findAllSorted("time", Sort.DESCENDING);
        return getRealm().copyFromRealm(results);
    }



    /**
     * @// TODO: 2018/2/5  修改
     * */
    public void modifyCollection(String id,String newName){
        User user = getRealm().where(User.class).equalTo("id", id).findFirst();
        mRealm.beginTransaction();
        user.setName(newName);
        mRealm.commitTransaction();
    }


    /**
     *
     * @todo 数据迁移问题
     *
     *
     *
     * */


    //删除原来的数据库
    public void deletedDB1(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .deleteRealmIfMigrationNeeded()
                .build();
    }

    //数据库字段的迁移
    public void deletedDB2(){
        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2) // Must be bumped when the schema changes
                .migration(new Migration()) // Migration to run instead of throwing an exception
                .build();
    }










}
