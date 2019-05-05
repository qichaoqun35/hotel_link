package com.example.qichaoqun.amerilink.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.qichaoqun.amerilink.R;

/**
 * @author qichaoqun
 * @date 2018/8/31
 */
public class OrderSuccess extends AppCompatActivity{
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.order_success_layout);
        setToolBar();
    }

    private void setToolBar() {
        mToolbar = (Toolbar) findViewById(R.id.order_success_bar);
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
}
