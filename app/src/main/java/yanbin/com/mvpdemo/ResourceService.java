package yanbin.com.mvpdemo;

import android.content.Context;
import android.support.annotation.StringRes;

public interface ResourceService {

    void init(Context context);

    String getString(@StringRes int res);

    String getString(@StringRes int res, Object... formatArgs);
}
