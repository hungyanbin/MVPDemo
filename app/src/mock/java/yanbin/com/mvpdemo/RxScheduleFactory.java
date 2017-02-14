package yanbin.com.mvpdemo;

import io.reactivex.Scheduler;
import io.reactivex.schedulers.Schedulers;

public class RxScheduleFactory {

    public static Scheduler mainThread() {
        return Schedulers.trampoline();
    }

    public static Scheduler computeThread(){
        return Schedulers.trampoline();
    }

    public static Scheduler networkThread() {
        return Schedulers.trampoline();
    }

}
