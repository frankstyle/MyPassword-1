package young.home.com.mypassword.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import young.home.com.mypassword.R;
import young.home.com.mypassword.application.BaseActivity;
import young.home.com.mypassword.application.MD5;
import young.home.com.mypassword.model.SettingKey;

public class StartActivity extends BaseActivity implements TextWatcher{

    //region field
    EditText inputPwd;
    Button enterBtn;
    String pwd;
    //endregion

    //region function

    //region override
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        pwd = super.getSetting(SettingKey.LOCK_PWD, "");
        if (pwd.isEmpty()) {
            Intent intent = new Intent(this, SetPasswordActivity.class);
            startActivity(intent);
            finish();
        }

        inputPwd = (EditText) findViewById(R.id.inputPwd);
        enterBtn = (Button)findViewById(R.id.enterBtn);

        inputPwd.addTextChangedListener(this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if(inputPwd.getText().length() > 0) {
            enterBtn.setEnabled(true);
        } else {
            enterBtn.setEnabled(false);
        }
    }
    //endregion

    //region private
    public void enterClick(View v) {
        if (pwd.equals(MD5.getMD5(inputPwd.getText().toString()))) {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, R.string.wrong_password, Toast.LENGTH_SHORT).show();
        }
    }
    //endregion

    //endregion
}
