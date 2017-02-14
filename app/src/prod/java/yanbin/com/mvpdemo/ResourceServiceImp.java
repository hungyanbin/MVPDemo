package yanbin.com.mvpdemo;

import android.content.Context;
import android.support.annotation.StringRes;

public class ResourceServiceImp implements ResourceService{

    private Context context;

    @Override
    public void init(Context context) {
        this.context = context;
    }

    @Override
    public String getString(@StringRes int res) {
        return context.getString(res);
    }

    @Override
    public String getString(@StringRes int res, Object... formatArgs) {
        return context.getString(res, formatArgs);
    }
}
