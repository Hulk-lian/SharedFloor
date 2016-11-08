package com.jtsw.sharedfloor.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.widget.TextView;

import com.jtsw.sharedfloor.R;

public class Login_Activity extends AppCompatActivity {

    //components
    private TextView txvRegister,txvForget;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_);
        inicializeComponents();
    }

    private void inicializeComponents() {
        txvRegister=(TextView)findViewById(R.id.loginTXVRegister);
        txvForget=(TextView)findViewById(R.id.loginTXVForget);

        //links
        txvForget.setMovementMethod(LinkMovementMethod.getInstance());
        txvRegister.setMovementMethod(LinkMovementMethod.getInstance());
    }
}
