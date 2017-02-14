package yanbin.com.mvpdemo;

import android.app.Application;

public class MyApplication extends Application{

    @Override
    public void onCreate() {
        super.onCreate();
        ResourceService resourceService = Injection.getResourceService();
        resourceService.init(this);
    }
}
