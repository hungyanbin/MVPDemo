package yanbin.com.mvpdemo.login;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import yanbin.com.mvpdemo.LoginResponse;
import yanbin.com.mvpdemo.login.LoginApi;

class LoginApiImp implements LoginApi {

    @Override
    public Observable<LoginResponse> login(String account, String password) {
        Random random = new Random();
        int errorCode = random.nextInt(4);
        boolean success = errorCode == 0;
        LoginResponse response = new LoginResponse(success, errorCode);

        return Observable.just(response)
                .delay(1, TimeUnit.SECONDS);
    }
}
