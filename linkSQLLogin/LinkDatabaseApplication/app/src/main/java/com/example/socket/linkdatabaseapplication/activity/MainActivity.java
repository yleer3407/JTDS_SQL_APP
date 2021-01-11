package com.example.socket.linkdatabaseapplication.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.example.socket.linkdatabaseapplication.DbUtil;
import com.example.socket.linkdatabaseapplication.EnviromentQrder;
import com.example.socket.linkdatabaseapplication.MyAdapter;
import com.example.socket.linkdatabaseapplication.R;
import com.example.socket.linkdatabaseapplication.zxing.android.CaptureActivity;

import static com.example.socket.linkdatabaseapplication.DbUtil.typeLocationList;
/*
  --------------------------------------���ݲ�ѯ��ʾ��ҳ����---------------------------------
 */
public class MainActivity extends AppCompatActivity  {
    private static final String DECODED_CONTENT_KEY = "codedContent";
    private static final String DECODED_BITMAP_KEY = "codedBitmap";
    private static final int REQUEST_CODE_SCAN = 0x0000;
    private ListView list;
    private Button btnscan;
    private Button btnSearch;
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


//new DownloadDataThread().start();//�����߳�
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
        btnSearch = findViewById(R.id.btnTestSql);
        btnscan = findViewById(R.id.btnScan);

        btnscan.setOnClickListener(getClickEvent());
        btnSearch.setOnClickListener(getClickEvent());
        ListView listView = findViewById(R.id.list);
        //�����λ
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                EnviromentQrder enviromentQrder=typeLocationList.get(position);
//                Toast.makeText(MainActivity.this,enviromentQrder.getNum(),Toast.LENGTH_LONG).show();
                Intent intent=new Intent(MainActivity.this,MainActivity2.class);
                intent.putExtra("floNum",enviromentQrder.getNum());
                startActivity(intent);
            }
        });
    }

    private View.OnClickListener getClickEvent() {
        return new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch (view.getId()){
                    case R.id.btnScan:
                        //��̬Ȩ������
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        } else {
                            goScan();
                        }
                        break;
                    case R.id.btnTestSql:
                        new DownloadDataThread().start();//�����߳�
                        break;
                }
            }
        };
    }

    /**
     * ��ת��ɨ�����ɨ��
     */
    private void goScan() {
        Intent intent = new Intent(MainActivity.this, CaptureActivity.class);
        startActivityForResult(intent, REQUEST_CODE_SCAN);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case 1:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    goScan();
                } else {
                    Toast.makeText(this, "��ܾ���Ȩ�����룬�����޷������ɨ��Ӵ��", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    /**
     *ɨ��������
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                //���ص��ı�����
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //���ص�BitMapͼ��
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
                EditText editText = findViewById(R.id.editSearch);
                editText.setText(content);
                new DownloadDataThread().start();//�����߳�
               // tv_scanResult.setText("��ɨ�赽�������ǣ�" + content);
            }
        }
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
