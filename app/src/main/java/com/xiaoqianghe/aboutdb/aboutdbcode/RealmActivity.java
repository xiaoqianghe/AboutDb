package com.xiaoqianghe.aboutdb.aboutdbcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.xiaoqianghe.aboutdb.aboutdbcode.data.User;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class RealmActivity extends AppCompatActivity {

    private Realm mRealm;

    private Button bt_add,bt_del,bt_modify,bt_squery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_realm);
    }

    private void initRealm() {

//        Realm.init(this);
//        Realm mRealm = Realm.getDefaultInstance();

        //

        RealmConfiguration config=new RealmConfiguration.Builder()
                .name("myrealm.realm")
                .schemaVersion(0)
                .build();

        mRealm = Realm.getInstance(config);

    }



    public void addData(){

    mRealm.executeTransaction(new Realm.Transaction() {
        @Override
        public void execute(Realm realm) {
            User user=mRealm.createObject(User.class);
            user.setName("HAHA");
            user.setAge("22");
        }
    });
    }

    public void queryData(){
        RealmResults<User> userList = mRealm.where(User.class).findAll();//查询所有的

//        RealmResults<User> userList = mRealm.where(User.class)
//                .endsWith("name","Gavin")
//                .findAllAsync();
//
//        User user2 = mRealm.where(User.class).findFirst();


    }

    public void deleteData(){
//
//        使用 deleteFromRealm()
        //先查询数据
        //
        final  RealmResults<User> userList=mRealm.where(User.class).findAll();

    }

    //版本升级


}
