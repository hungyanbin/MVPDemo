package yanbin.com.mvpdemo;

public class LoginResponse {

    private boolean success;
    private int errorCode;

    public LoginResponse(boolean success, int errorCode) {
        this.success = success;
        this.errorCode = errorCode;
    }

    public boolean isSuccess() {
        return success;
    }

    public int getErrorCode() {
        return errorCode;
    }
}
