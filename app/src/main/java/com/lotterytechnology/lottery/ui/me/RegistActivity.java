package com.lotterytechnology.lottery.ui.me;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.blankj.utilcode.util.PhoneUtils;
import com.dd.CircularProgressButton;
import com.lotterytechnology.lottery.R;
import com.lotterytechnology.lottery.base.BaseActivity;
import com.lotterytechnology.lottery.base.BasePresenter;
import com.lotterytechnology.lottery.utils.CodeUtils;
import com.lotterytechnology.lottery.utils.Utils;
import com.lotterytechnology.lottery.widget.TopBar;

import butterknife.BindView;
import butterknife.OnClick;
import es.dmoral.toasty.Toasty;

/**
 * @author Ryder
 * create at 2018/4/23 11:41
 * package name:com.lotterytechnology.lottery.ui.me
 * description: 注册界面
 **/
public class RegistActivity extends BaseActivity implements View.OnFocusChangeListener {
    @BindView(R.id.regist_topbar)
    TopBar reistTopbar;

    @BindView(R.id.ig_regist_input_mobile)
    ImageView ig_mobile;

    @BindView(R.id.regist_input_mobile)
    EditText inputMbile;


    @BindView(R.id.ig_regist_input_password)
    ImageView ig_password;

    @BindView(R.id.regist_input_password)
    EditText inputPassword;

    @BindView(R.id.ig_regist_input_nick_name)
    ImageView ig_nick_name;

    @BindView(R.id.regist_input_nick_name)
    EditText inputNickName;

    @BindView(R.id.ig_regist_input_vercode)
    ImageView ig_vercode;
    @BindView(R.id.ig_regist_show_vercode)
    ImageView ig_show_vercode;

    @BindView(R.id.regist_input_vercode)
    EditText inputVercode;

    @BindView(R.id.regist_btn)
    CircularProgressButton btnRegist;

    @Override
    protected BasePresenter generatePresenter() {
        return null;
    }

    @Override
    protected View setTopView() {
        return reistTopbar;
    }

    @Override
    protected int getlayoutContentView() {
        return R.layout.activity_regist;
    }

    @Override
    protected void initView() {
        super.initView();
        reistTopbar.setTitle(R.string.register);
        reistTopbar.setLeftButtonListener(R.mipmap.back, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        reistTopbar.setRightTextGone();
        ig_show_vercode.setImageBitmap(CodeUtils.getInstance().createBitmap());
        btnRegist.setIndeterminateProgressMode(true);
        inputMbile.setOnFocusChangeListener(this);
        inputPassword.setOnFocusChangeListener(this);
        inputNickName.setOnFocusChangeListener(this);
        inputVercode.setOnFocusChangeListener(this);
    }


    @OnClick({R.id.ig_regist_show_vercode, R.id.regist_btn})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ig_regist_show_vercode:
                ig_show_vercode.setImageBitmap(CodeUtils.getInstance().createBitmap());
                if (btnRegist.getProgress() == 0) {
                    btnRegist.setProgress(50);
                } else if (btnRegist.getProgress() == -1) {
                    btnRegist.setProgress(0);
                } else {
                    btnRegist.setProgress(-1);
                }
                break;
            case R.id.regist_btn:
                if (TextUtils.isEmpty(inputMbile.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.mobile_empty));
                    return;
                }

                if (Utils.isPhone(inputMbile.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.mobile_error));
                    return;
                }

                if (TextUtils.isEmpty(inputPassword.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.password_empty));
                    return;
                }

                if (Utils.verifyPwdFormat(inputPassword.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.password_error));
                    return;
                }
                if (inputMbile.getText().toString().trim().equals(inputPassword.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.password_mobile));
                    return;
                }

                if (TextUtils.isEmpty(inputVercode.getText().toString().trim())){
                    Toasty.error(this,getResources().getString(R.string.vercode_empty));
                    return;
                }

                if (!inputVercode.getText().toString().trim().equalsIgnoreCase(CodeUtils.getInstance().getCode())){
                    Toasty.error(this,getResources().getString(R.string.vercode_error));
                    return;
                }

                if (btnRegist.getProgress() == 0) {
                    btnRegist.setProgress(50);
                } else if (btnRegist.getProgress() == 100) {
                    btnRegist.setProgress(0);
                } else {
                    btnRegist.setProgress(100);
                }
                break;
        }
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        switch (v.getId()) {
            case R.id.regist_input_mobile:
                if (hasFocus){
                    ig_mobile.setSelected(true);
                }else {
                    ig_mobile.setSelected(false);
                }
                break;
            case R.id.regist_input_password:
                if (hasFocus){
                    ig_password.setSelected(true);
                }else {
                    ig_password.setSelected(false);
                }
                break;
            case R.id.regist_input_nick_name:
                if (hasFocus){
                    ig_nick_name.setSelected(true);
                }else {
                    ig_nick_name.setSelected(false);
                }
                break;
            case R.id.regist_input_vercode:
                if (hasFocus){
                    ig_vercode.setSelected(true);
                }else {
                    ig_vercode.setSelected(false);
                }
                break;
        }
    }
}
