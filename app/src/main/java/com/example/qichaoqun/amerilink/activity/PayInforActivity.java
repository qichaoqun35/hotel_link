package com.example.qichaoqun.amerilink.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.example.qichaoqun.amerilink.R;

public class PayInforActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar mToolbar;
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pay_infor_layout);
        setToolBar();
        mButton = (Button) findViewById(R.id.sure_pay);
        mButton.setOnClickListener(this);
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.pay_infor_bar);
        mToolbar.setTitle(getResources().getString(R.string.pay_infor));
        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.sure_pay:
                Intent intent = new Intent(this,OrderSuccess.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
