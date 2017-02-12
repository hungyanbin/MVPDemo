package yanbin.com.mvpdemo;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements LoginContract.View{

    private TextInputEditText edtAccount;
    private TextInputEditText edtPassword;
    private Button btnLogin;
    private LoginContract.Presenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setViews();
        presenter = new LoginPresenter(this, new LoginApiImp());
    }

    private void setViews(){
        edtAccount = (TextInputEditText) findViewById(R.id.edtAccount);
        edtPassword = (TextInputEditText) findViewById(R.id.edtPassword);
        btnLogin = (Button) findViewById(R.id.btnLogin);
        btnLogin.setOnClickListener(v -> presenter.onLoginClicked(edtAccount.getText().toString(), edtPassword.getText().toString()));
    }

    @Override
    public void showLoginSuccess() {
        Toast.makeText(this, "success!!", Toast.LENGTH_LONG).show();
    }

    @Override
    public void showLoginFail(String errorMsg) {
        Toast.makeText(this, errorMsg, Toast.LENGTH_LONG).show();
    }
}
