package com.xiaoqianghe.aboutdb.aboutdbcode;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmCollection;
import io.realm.RealmConfiguration;

/**
 * Author：Wq
 * Date：2018/2/1 15:36
 * Description：//todo
 */

public class BaseApplication extends Application{





    @Override
    public void onCreate() {
        super.onCreate();

        initReleam();

    }

    private void initReleam() {


        // The Realm file will be located in Context.getFilesDir() with name "myrealm.realm"
        RealmConfiguration config = new RealmConfiguration.Builder()
                .name("myrealm.realm")
//                .encryptionKey(getKey())
                .schemaVersion(42)
//                .modules(new MySchemaModule())
//                .migration(new MyMigration())
                .build();
// Use the config
        Realm realm = Realm.getInstance(config);
    }


}


