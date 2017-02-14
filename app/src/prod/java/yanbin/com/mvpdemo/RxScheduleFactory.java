package yanbin.com.mvpdemo;

import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class RxScheduleFactory {

    public static Scheduler mainThread() {
        return AndroidSchedulers.mainThread();
    }

    public static Scheduler computeThread(){
        return Schedulers.computation();
    }

    public static Scheduler networkThread() {
        return Schedulers.io();
    }

}
