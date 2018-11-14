package com.example.user.loginmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : LiuYang
 * @date : 2018/11/13
 */

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.login)
    Button mLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.login)
    public void onViewClicked() {
        startActivity(new Intent(this, LoginActivity.class));
    }
}
