package yanbin.com.mvpdemo;

import io.reactivex.Observable;

public interface LoginApi {

    Observable<LoginResponse> login(String account, String password);
}
