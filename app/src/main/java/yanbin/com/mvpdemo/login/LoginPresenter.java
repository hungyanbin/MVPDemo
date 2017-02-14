package yanbin.com.mvpdemo.login;


import yanbin.com.mvpdemo.LoginResponse;
import yanbin.com.mvpdemo.RxScheduleFactory;

class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginApi loginApi;

    LoginPresenter(LoginContract.View view, LoginApi loginApi) {
        this.view = view;
        this.loginApi = loginApi;
    }

    @Override
    public void onLoginClicked(String account, String password) {
        loginApi.login(account, password)
                .subscribeOn(RxScheduleFactory.networkThread())
                .observeOn(RxScheduleFactory.mainThread())
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
