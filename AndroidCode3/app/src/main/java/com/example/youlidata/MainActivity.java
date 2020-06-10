package com.example.youlidata;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText edtxt;
    private View btnTest;
    private View btnClean;
    private TextView tvTestResult;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnTest=findViewById(R.id.btnTestSql);
        btnClean=findViewById(R.id.btnClean);
        edtxt = findViewById(R.id.editSearch);
        tvTestResult = (TextView)findViewById(R.id.tvTestResult);

        btnTest.setOnClickListener(getClickEvent());
        btnClean.setOnClickListener(getClickEvent());
    }

    private View.OnClickListener getClickEvent(){
        return new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                tvTestResult.setText("...");
                if(v==btnTest){
                    test();

                }
            }
        };
    }
    private void test()
    {
        Runnable run = new Runnable()
        {
            @Override
            public void run()
            {
                String strEdt = "";
                strEdt = edtxt.getText().toString();
                String ret = DBUtil.QuerySQL(strEdt);
                Message msg = new Message();
                msg.what=1001;
                Bundle data = new Bundle();
                data.putString("result", ret);
                msg.setData(data);
                mHandler.sendMessage(msg);
            }
        };
        new Thread(run).start();

    }

    Handler mHandler = new Handler(){
        public void handleMessage(android.os.Message msg) {
            switch (msg.what)
            {
                case 1001:
                    String str = msg.getData().getString("result");
                    tvTestResult.setText(str);
                    break;

                default:
                    break;
            }
        };
    };

}
