package yanbin.com.mvpdemo.login;

interface LoginContract {

    interface View{
        void showLoginSuccess();
        void showLoginFail(String errorMsg);
    }

    interface Presenter{
        void onLoginClicked(String account, String password);
    }
}
