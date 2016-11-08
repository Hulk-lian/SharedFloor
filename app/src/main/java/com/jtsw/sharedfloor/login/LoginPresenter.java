package com.jtsw.sharedfloor.login;

import android.app.Application;

import com.jtsw.sharedfloor.R;
import com.jtsw.sharedfloor.model.User;

public class LoginPresenter implements ILogin.Presenter{

    private User user;
    private ILogin.msgView msgView;

    public LoginPresenter(ILogin.msgView view){
            this.msgView=view;
    }

    @Override
    public void validateCredentials(String user, String pass) {
        String mensRes=null;
        int codeRes=0;

        //empty user
        if(!user.isEmpty()) {
            //pass empty
            if (!pass.isEmpty()) {
                //if the credentials are correct
                if(access(user,pass)){

                }
            }

        }
        else{
            codeRes= R.id.loginEDTusername;
        }

        msgView.setMessageError(mensRes,codeRes);
    }
    private void conect(){

    }
    //comprobacion si el usuario esta registrado
    private boolean access(String user,String pass){
        return true;
    }

}
