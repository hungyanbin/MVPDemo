package yanbin.com.mvpdemo.login;

import io.reactivex.Observable;
import yanbin.com.mvpdemo.LoginResponse;

interface LoginApi {

    Observable<LoginResponse> login(String account, String password);
}
