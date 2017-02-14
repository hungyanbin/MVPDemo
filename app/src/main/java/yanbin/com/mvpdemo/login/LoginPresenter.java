package yanbin.com.mvpdemo.login;


import yanbin.com.mvpdemo.LoginResponse;
import yanbin.com.mvpdemo.R;
import yanbin.com.mvpdemo.ResourceService;
import yanbin.com.mvpdemo.RxScheduleFactory;

class LoginPresenter implements LoginContract.Presenter {

    private LoginContract.View view;
    private LoginApi loginApi;
    private ResourceService resourceService;

    LoginPresenter(LoginContract.View view, LoginApi loginApi, ResourceService resourceService) {
        this.view = view;
        this.loginApi = loginApi;
        this.resourceService = resourceService;
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
            view.showLoginFail(resourceService.getString(R.string.error_invalid_account));
        }
    }
}
