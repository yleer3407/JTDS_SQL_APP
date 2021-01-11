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
  --------------------------------------数据查询显示在页面上---------------------------------
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
                    list.setAdapter(new MyAdapter(typeLocationList,MainActivity.this));//设置数据到ListView
                    break;
            }
        }
    };


//new DownloadDataThread().start();//开启线程
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
        //点击定位
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
                        //动态权限申请
                        if (ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED) {
                            ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA}, 1);
                        } else {
                            goScan();
                        }
                        break;
                    case R.id.btnTestSql:
                        new DownloadDataThread().start();//开启线程
                        break;
                }
            }
        };
    }

    /**
     * 跳转到扫码界面扫码
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
                    Toast.makeText(this, "你拒绝了权限申请，可能无法打开相机扫码哟！", Toast.LENGTH_SHORT).show();
                }
                break;
            default:
        }
    }
    /**
     *扫码结果返回
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE_SCAN && resultCode == RESULT_OK) {
            if (data != null) {
                //返回的文本内容
                String content = data.getStringExtra(DECODED_CONTENT_KEY);
                //返回的BitMap图像
                Bitmap bitmap = data.getParcelableExtra(DECODED_BITMAP_KEY);
                EditText editText = findViewById(R.id.editSearch);
                editText.setText(content);
                new DownloadDataThread().start();//开启线程
               // tv_scanResult.setText("你扫描到的内容是：" + content);
            }
        }
    }

    private void init() {
        list=(ListView)findViewById(R.id.list);
    }




    //----------------------------去数据库加载数据-------------------------
    private class DownloadDataThread extends Thread{
        EditText edSearch = findViewById(R.id.editSearch);
        @Override
        public void run() {
            DbUtil dbUtil=new DbUtil();
            int size= dbUtil.getTypesLocation(edSearch.getText().toString().trim());
            if(size>0){//查询得到结果
                Message message=Message.obtain();
                message.what=GETDATA;
                handler.sendMessage(message);//将结果通知主线程，处理结果
            }
        }
    }
}
