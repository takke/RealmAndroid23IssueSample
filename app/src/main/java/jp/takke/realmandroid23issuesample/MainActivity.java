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

        final Realm realm = Realm.getDefaultInstance(); // crashes here on 2.3.x devices

        /*
01-06 10:32:12.689 I/DEBUG   (  747): *** *** *** *** *** *** *** *** *** *** *** *** *** *** *** ***
01-06 10:32:12.689 I/DEBUG   (  747): Build fingerprint: 'google/passion/passion:2.3.6/GRK39F/189904:user/release-keys'
01-06 10:32:12.689 I/DEBUG   (  747): pid: 845, tid: 845  >>> jp.takke.realmandroid23issuesample <<<
01-06 10:32:12.689 I/DEBUG   (  747): signal 11 (SIGSEGV), code 1 (SEGV_MAPERR), fault addr de5685a7
01-06 10:32:12.689 I/DEBUG   (  747):  r0 00000007  r1 00000001  r2 800a3d68  r3 00000000
01-06 10:32:12.689 I/DEBUG   (  747):  r4 0000ce60  r5 0000abe0  r6 de5685a7  r7 00000000
01-06 10:32:12.689 I/DEBUG   (  747):  r8 0000abe0  r9 4214cb28  10 0000abe0  fp 800a5368
01-06 10:32:12.689 I/DEBUG   (  747):  ip 800a56cc  sp beef23b0  lr 8004a719  pc 8004a718  cpsr 60000030
01-06 10:32:12.699 I/DEBUG   (  747):  d0  2e746c756166652e  d1  2f73656c69662f6e
01-06 10:32:12.699 I/DEBUG   (  747):  d2  646e616d6c61656f  d3  7369333264696f74
01-06 10:32:12.699 I/DEBUG   (  747):  d4  2f73656c69662f65  d5  2e746c7561666564
01-06 10:32:12.699 I/DEBUG   (  747):  d6  616d2e6d6c616572  d7  746e656d6567616e
01-06 10:32:12.699 I/DEBUG   (  747):  d8  0000000000000000  d9  0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d10 0000000000000000  d11 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d12 0000000000000000  d13 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d14 0000000000000000  d15 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d16 beef21e4beef211c  d17 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d18 42eccefa43de3400  d19 3fbc71c71c71c71c
01-06 10:32:12.699 I/DEBUG   (  747):  d20 4008000000000000  d21 3fd99a27ad32ddf5
01-06 10:32:12.699 I/DEBUG   (  747):  d22 3fd24998d6307188  d23 3fcc7288e957b53b
01-06 10:32:12.699 I/DEBUG   (  747):  d24 3fc74721cad6b0ed  d25 3fc39a09d078c69f
01-06 10:32:12.699 I/DEBUG   (  747):  d26 0000000000000000  d27 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d28 0000000000000000  d29 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  d30 0000000000000000  d31 0000000000000000
01-06 10:32:12.699 I/DEBUG   (  747):  scr 20000012
01-06 10:32:12.699 I/DEBUG   (  747):
01-06 10:32:12.769 I/DEBUG   (  747):          #00  pc 0004a718  /system/lib/libdvm.so
01-06 10:32:12.769 I/DEBUG   (  747):          #01  lr 8004a719  /system/lib/libdvm.so
01-06 10:32:12.769 I/DEBUG   (  747):
01-06 10:32:12.769 I/DEBUG   (  747): code around pc:
01-06 10:32:12.769 I/DEBUG   (  747): 8004a6f8 21074620 fb00f008 b0049802 81f0e8bd
01-06 10:32:12.769 I/DEBUG   (  747): 8004a708 6904b570 4605460e 46202101 faf4f008
01-06 10:32:12.769 I/DEBUG   (  747): 8004a718 46286831 ff0ef7ff 46052107 f0084620
01-06 10:32:12.769 I/DEBUG   (  747): 8004a728 4628faeb bf00bd70 6904b5f7 4605460e
01-06 10:32:12.769 I/DEBUG   (  747): 8004a738 46202101 fae0f008 0307f006 2b074f16
01-06 10:32:12.769 I/DEBUG   (  747):
01-06 10:32:12.769 I/DEBUG   (  747): code around lr:
01-06 10:32:12.769 I/DEBUG   (  747): 8004a6f8 21074620 fb00f008 b0049802 81f0e8bd
01-06 10:32:12.769 I/DEBUG   (  747): 8004a708 6904b570 4605460e 46202101 faf4f008
01-06 10:32:12.769 I/DEBUG   (  747): 8004a718 46286831 ff0ef7ff 46052107 f0084620
01-06 10:32:12.769 I/DEBUG   (  747): 8004a728 4628faeb bf00bd70 6904b5f7 4605460e
01-06 10:32:12.769 I/DEBUG   (  747): 8004a738 46202101 fae0f008 0307f006 2b074f16
01-06 10:32:12.769 I/DEBUG   (  747):
01-06 10:32:12.769 I/DEBUG   (  747): stack:
01-06 10:32:12.769 I/DEBUG   (  747):     beef2370  40597a58
01-06 10:32:12.769 I/DEBUG   (  747):     beef2374  0000ce60
01-06 10:32:12.769 I/DEBUG   (  747):     beef2378  00000000
01-06 10:32:12.769 I/DEBUG   (  747):     beef237c  800aad38
01-06 10:32:12.769 I/DEBUG   (  747):     beef2380  0000abe0
01-06 10:32:12.769 I/DEBUG   (  747):     beef2384  8004aa71  /system/lib/libdvm.so
01-06 10:32:12.769 I/DEBUG   (  747):     beef2388  405973a0
01-06 10:32:12.769 I/DEBUG   (  747):     beef238c  00000000
01-06 10:32:12.769 I/DEBUG   (  747):     beef2390  beef211c
01-06 10:32:12.769 I/DEBUG   (  747):     beef2394  beef21e4
01-06 10:32:12.769 I/DEBUG   (  747):     beef2398  800aad38
01-06 10:32:12.769 I/DEBUG   (  747):     beef239c  0000ce60
01-06 10:32:12.769 I/DEBUG   (  747):     beef23a0  0000ce60
01-06 10:32:12.769 I/DEBUG   (  747):     beef23a4  0000abe0
01-06 10:32:12.769 I/DEBUG   (  747):     beef23a8  df002777
01-06 10:32:12.769 I/DEBUG   (  747):     beef23ac  e3a070ad
01-06 10:32:12.769 I/DEBUG   (  747): #00 beef23b0  002b2c50
01-06 10:32:12.769 I/DEBUG   (  747):     beef23b4  beef2418
01-06 10:32:12.769 I/DEBUG   (  747):     beef23b8  805bae10
01-06 10:32:12.769 I/DEBUG   (  747):     beef23bc  804583e1  /data/data/jp.takke.realmandroid23issuesample/lib/librealm-jni.so
01-06 10:32:12.769 I/DEBUG   (  747):     beef23c0  beef2428
01-06 10:32:12.769 I/DEBUG   (  747):     beef23c4  2020a000
01-06 10:32:12.769 I/DEBUG   (  747):     beef23c8  0000abe0
01-06 10:32:12.769 I/DEBUG   (  747):     beef23cc  4214cb28
01-06 10:32:12.769 I/DEBUG   (  747):     beef23d0  0000abe0
01-06 10:32:12.769 I/DEBUG   (  747):     beef23d4  afd13ec7  /system/lib/libc.so
01-06 10:32:12.769 I/DEBUG   (  747):     beef23d8  00000014
01-06 10:32:12.769 I/DEBUG   (  747):     beef23dc  805bae10
01-06 10:32:12.769 I/DEBUG   (  747):     beef23e0  002b29c0
01-06 10:32:12.769 I/DEBUG   (  747):     beef23e4  002b2c50
01-06 10:32:12.769 I/DEBUG   (  747):     beef23e8  beef2428
01-06 10:32:12.769 I/DEBUG   (  747):     beef23ec  00000000
01-06 10:32:12.769 I/DEBUG   (  747):     beef23f0  0000abe0
01-06 10:32:12.769 I/DEBUG   (  747):     beef23f4  4214cb28
        */

        realm.close();
    }
}
