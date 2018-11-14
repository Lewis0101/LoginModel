package com.example.user.loginmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author : LiuYang
 * @date : 2018/11/14
 */

public class Sign_upActivity extends AppCompatActivity {


    @BindView(R.id.setting_account)
    EditText mSettingAccount;
    @BindView(R.id.setting_password)
    EditText mSettingPassword;
    @BindView(R.id.sign_up)
    Button mSignUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.sign_up)
    public void onViewClicked() {
        if (mSettingAccount.length() == 0 || mSettingPassword.length() == 0){
            Toast.makeText(this,"账号或者密码不能为空",Toast.LENGTH_SHORT).show();
        }else {
            startActivity(new Intent(this,MainActivity.class));
        }

    }
}
