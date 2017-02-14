package yanbin.com.mvpdemo.login;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.reactivex.Observable;
import yanbin.com.mvpdemo.Constants;
import yanbin.com.mvpdemo.LoginResponse;
import yanbin.com.mvpdemo.R;
import yanbin.com.mvpdemo.ResourceService;

import static org.mockito.Mockito.*;

public class LoginPresenterTest {

    @Mock
    private LoginContract.View view;
    @Mock
    private LoginApi loginApi;
    @Mock
    private ResourceService resourceService;

    private LoginPresenter loginPresenter;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        loginPresenter = new LoginPresenter(view, loginApi, resourceService);
    }

    @Test
    public void onLoginClicked_success() throws Exception {
        String account = "peter";
        String password = "abc123";
        LoginResponse loginResponse = new LoginResponse(true, Constants.ERROR_NON);

        when(loginApi.login(account, password)).thenReturn(Observable.just(loginResponse));

        loginPresenter.onLoginClicked(account, password);

        verify(view).showLoginSuccess();
    }

    @Test
    public void onLoginClick_fail() throws Exception {
        String account = "";
        String password = "abc123";
        String errorMessage = "errrrrrrr!";
        LoginResponse loginResponse = new LoginResponse(false, Constants.ERROR_EMPTY);

        when(loginApi.login(account, password)).thenReturn(Observable.just(loginResponse));
        when(resourceService.getString(R.string.error_invalid_account)).thenReturn(errorMessage);

        loginPresenter.onLoginClicked(account, password);

        verify(view).showLoginFail(errorMessage);

    }
}