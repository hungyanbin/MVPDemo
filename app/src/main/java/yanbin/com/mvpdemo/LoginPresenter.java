package yanbin.com.mvpdemo;


public class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginApi loginApi;

    public LoginPresenter(LoginContract.View view, LoginApi loginApi) {
        this.view = view;
        this.loginApi = loginApi;
    }

    @Override
    public void onLoginClicked(String account, String password) {
        loginApi.login(account, password)
                .subscribe(this::onLoginDone);
    }

    private void onLoginDone(LoginResponse loginResponse){
        if(loginResponse.isSuccess()){
            view.showLoginSuccess();
        }else{
            view.showLoginFail("");
        }
    }
}
