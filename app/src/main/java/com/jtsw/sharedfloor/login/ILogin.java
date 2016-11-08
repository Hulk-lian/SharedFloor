package com.jtsw.sharedfloor.login;

public interface ILogin {

    final int DATA_EMPTY=1;
    final int INCORRECTLOGIN=2;

    interface  msgView{
        public void setMessageError(String error,int errorCode);
    }
    interface Presenter
    {
        public void validateCredentials(String user,String pass);
    }
}
