package com.example.socket.linkdatabaseapplication.activity;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.example.socket.linkdatabaseapplication.DbUtil;
import com.example.socket.linkdatabaseapplication.MyAdapter;
import com.example.socket.linkdatabaseapplication.R;

import static com.example.socket.linkdatabaseapplication.DbUtil.typeLocationList;
/*
  --------------------------------------���ݲ�ѯ��ʾ��ҳ����---------------------------------
 */
public class MainActivity extends AppCompatActivity {

    private ListView list;
    private final int GETDATA=0;
    private Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what){
                case GETDATA:
                    list.setAdapter(new MyAdapter(typeLocationList,MainActivity.this));//�������ݵ�ListView
                    break;
            }
        }
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        Button btnSearch = findViewById(R.id.btnTestSql);
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DownloadDataThread().start();//�����߳�
            }
        });


    }

    private void init() {
        list=(ListView)findViewById(R.id.list);
    }
    //----------------------------ȥ���ݿ��������-------------------------
    private class DownloadDataThread extends Thread{
        EditText edSearch = findViewById(R.id.editSearch);
        @Override
        public void run() {
            DbUtil dbUtil=new DbUtil();
            int size= dbUtil.getTypesLocation(edSearch.getText().toString().trim());
            if(size>0){//��ѯ�õ����
                Message message=Message.obtain();
                message.what=GETDATA;
                handler.sendMessage(message);//�����֪ͨ���̣߳�������
            }
        }
    }
}
