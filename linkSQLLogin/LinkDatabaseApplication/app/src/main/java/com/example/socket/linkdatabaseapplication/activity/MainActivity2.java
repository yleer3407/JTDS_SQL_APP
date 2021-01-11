package com.example.socket.linkdatabaseapplication.activity;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.socket.linkdatabaseapplication.DbUtil;
import com.example.socket.linkdatabaseapplication.EnviromentQrder;
import com.example.socket.linkdatabaseapplication.MyAdapter;
import com.example.socket.linkdatabaseapplication.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.socket.linkdatabaseapplication.DbUtil.typeLocationList;

public class MainActivity2 extends AppCompatActivity {
    String dataNum;
    private ListView list1;
    private final int GETDATA=0;
    private List<EnviromentQrder> enviromentQrderList=new ArrayList<>();
//    private Handler handler=new Handler(){
//        public void handleMessage(Message msg){
//            switch (msg.what){
//                case GETDATA:
//                    list1.setAdapter(new MyAdapter(typeLocationList,MainActivity2.this));
//                    break;
//            }
//        }
//    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Intent intent = getIntent();
        dataNum = intent.getStringExtra("floNum");
//        TextView textView = findViewById(R.id.txt1);
//        textView.setText(dataNum);
//        list1=findViewById(R.id.list1);
//        init();
//        new DownloagDataThread2().start();

        initFruits();
        TestAdapter adapter = new TestAdapter(MainActivity2.this,R.layout.adapt_item,enviromentQrderList);
        ListView listView = findViewById(R.id.list1);
        listView.setAdapter(adapter);
    }

    private void initFruits() {
        for (int i=0;i<5;i++){
            EnviromentQrder enviromentQrder = new EnviromentQrder("1","2","3","4","5","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","2","3","3","3","3","4","4","4","4","4","4","4","4","","","","","","","","");
            enviromentQrderList.add(enviromentQrder);
        }
    }

//    private void init() {
//        list1 = findViewById(R.id.list1);
//    }

//    private  class DownloagDataThread2 extends Thread{
//        public void run(){
//            DbUtil dbUtil=new DbUtil();
//            int size=dbUtil.getTypesLocation(dataNum);
//            if (size>0){
//                Message message =Message.obtain();
//                message.what=GETDATA;
//                handler.sendMessage(message);
//            }
//        }
//
//    }
}