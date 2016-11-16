package jp.takke.realmandroid23issuesample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Realm
        Realm.init(this);

        final RealmConfiguration configuration = new RealmConfiguration.Builder()
                .name("sample.db")
                .schemaVersion(2)
                .build();

        final Realm realm = Realm.getInstance(configuration);


    }
}
