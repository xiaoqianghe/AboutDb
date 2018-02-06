package com.xiaoqianghe.aboutdb.aboutdbcode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.xiaoqianghe.aboutdb.aboutdbcode.data.StudentMsgBean;
import com.xiaoqianghe.aboutdb.aboutdbcode.db.DBManager;

import java.util.ArrayList;
import java.util.List;

public class GreenDaoActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_save ;
    private Button btn_getAll ;
    private Button btn_get ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greendao);


        btn_save = (Button) findViewById(R.id.btn_save);
        btn_getAll = (Button) findViewById(R.id.btn_getAll);
        btn_get = (Button) findViewById(R.id.btn_get);

        btn_save.setOnClickListener(this);
        btn_getAll.setOnClickListener(this);
        btn_get.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        int id = v.getId() ;
        switch (id){
            case R.id.btn_save:
                save();
                break;
            case R.id.btn_getAll:
                getAll();
                break ;
            case R.id.btn_get:
                get();
                break ;
        }
    }


    private void save(){
        StudentMsgBean user1 = new StudentMsgBean(1,"10","abc","12");
        StudentMsgBean user2 = new StudentMsgBean(2,"20","def","22");
        StudentMsgBean user3 = new StudentMsgBean(3,"30","ghi","32");
        StudentMsgBean user4 = new StudentMsgBean(4,"40","jkl","42");
        StudentMsgBean user5 = new StudentMsgBean(5,"50","mno","52");

        List<StudentMsgBean> list = new ArrayList<>();
        list.add(user1);
        list.add(user2);
        list.add(user3);
        list.add(user4);
        list.add(user5);

        DBManager.getInstance(this).saveUsers(list);
    }

    private void getAll(){
        List<StudentMsgBean> users = DBManager.getInstance(this).queryUser();
        for(StudentMsgBean user : users){
            Log.i("MainActivity","name:"+user.getName());
        }
    }

    private void get(){
        List<StudentMsgBean> users = DBManager.getInstance(this).queryUser(20);
        for(StudentMsgBean user : users){
            Log.i("MainActivity","name:"+user.getName());
        }
    }
}
