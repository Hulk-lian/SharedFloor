package com.jtsw.sharedfloor.login;

import android.content.Intent;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.Selector_activity;

public class Login_Activity extends AppCompatActivity implements ILogin.msgView {

    //presenter
    private ILogin.Presenter mLoginPresenter;
    //components
    private TextView mtxvRegister,mtxvForget;
    private Button mbtnOk;
    private TextInputLayout mtilPassword,mtilUser;
    private EditText medtUser,medtPass;
    private CheckBox mchbRemember;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        mLoginPresenter= new LoginPresenter(this);

        inicializeComponents();
    }

    private void inicializeComponents() {
        mtxvRegister=(TextView)findViewById(R.id.loginTXVRegister);
        mtxvForget=(TextView)findViewById(R.id.loginTXVForget);
        mbtnOk=(Button)findViewById(R.id.loginBTNbtnOK);

        //links
        mtxvForget.setMovementMethod(LinkMovementMethod.getInstance());
        mtxvRegister.setMovementMethod(LinkMovementMethod.getInstance());

        //click button
        mbtnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               mLoginPresenter.validateCredentials(medtUser.getText().toString(),medtPass.getText().toString());
            }
        });
    }

    private void login(){
        Intent intent = new Intent(this, Selector_activity.class);
        startActivity(intent);
        finish();

    }

    @Override
    public void setMessageError(String error, int errorCode) {
        switch (errorCode) {
            case R.id.loginEDTusername: // User Incorrecto
                mtilUser.setError(error);
                break;
            case R.id.loginEDTpassword: // Pass Incorreta
                mtilPassword.setError(error);
                break;
            case 0: //Login Correcto
                Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                login();
                break;
        }

    }
}
