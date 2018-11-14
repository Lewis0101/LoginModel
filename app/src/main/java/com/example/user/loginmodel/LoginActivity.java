package com.example.user.loginmodel;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * @author : LiuYang
 * @date : 2018/11/13
 */
public class LoginActivity extends AppCompatActivity {


    @BindView(R.id.clear_account)
    ImageView mClearAccount;
    @BindView(R.id.clear_password)
    ImageView mClearPassword;
    @BindView(R.id.user_sign_up)
    TextView mUserSignUp;
    @BindView(R.id.login)
    Button mLogin;
    @BindView(R.id.input_account)
    EditText mInputAccount;
    @BindView(R.id.input_password)
    EditText mInputPassword;
    @BindView(R.id.input_toggle)
    ImageView mInputToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        mInputAccount.addTextChangedListener(mTextWatcher);
        mInputPassword.addTextChangedListener(mTextWatcher);

        mInputPassword.setOnEditorActionListener(mOnEditorActionListener);
        mInputAccount.setOnEditorActionListener(mOnEditorActionListener);
    }

    @OnClick({R.id.clear_account, R.id.clear_password, R.id.user_sign_up, R.id.login, R.id.input_toggle})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.clear_account:
                mInputAccount.setText("");
                break;
            case R.id.clear_password:
                mInputPassword.setText("");
                break;
            case R.id.user_sign_up:
                sign_up();
                break;
            case R.id.login:
                login();
                break;
            case R.id.input_toggle:
                break;
            default:
                break;
        }
    }

    //    登录
    private void login() {
        if (mInputAccount.length() == 0) {
            Toast.makeText(this, "账号不能为空", Toast.LENGTH_SHORT).show();
        } else {
            startActivity(new Intent(LoginActivity.this, MainActivity.class));
        }

    }

    //    注册
    private void sign_up() {
        startActivity(new Intent(LoginActivity.this, Sign_upActivity.class));
    }


    //    设置监听
    private TextView.OnEditorActionListener mOnEditorActionListener = (v, actionId, event) -> {
        //软键盘上的回车也能登录（效果与Button一致）
        if (actionId == EditorInfo.IME_ACTION_UNSPECIFIED) {
            login();
            return true;
        }
        return false;
    };


    //    EditText变化监听(TextWatcher)
    private TextWatcher mTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {

        }

        @Override
        public void afterTextChanged(Editable s) {
            String account = mInputAccount.getText().toString();
            String password = mInputPassword.getText().toString();

            boolean emptyAccount = TextUtils.isEmpty(account);
            boolean emptyPassword = TextUtils.isEmpty(password);

//            设置ImageView的状态根据EditText的变化而出现
            mClearAccount.setVisibility(emptyAccount ? View.GONE : View.VISIBLE);
            mClearPassword.setVisibility(emptyAccount ? View.GONE : View.VISIBLE);

//            设置按钮是否可以点击
            mLogin.setEnabled(!(emptyAccount || emptyPassword));
        }
    };

}
