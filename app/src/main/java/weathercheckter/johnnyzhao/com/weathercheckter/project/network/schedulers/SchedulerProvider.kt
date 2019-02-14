package weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class SchedulerProvider:BaseSchedulerProvider {

    private constructor(){
    }

    override fun computation(): Scheduler {
        return Schedulers.computation()
    }

    override fun io(): Scheduler {
        return Schedulers.io()
    }

    override fun ui(): Scheduler {
        return AndroidSchedulers.mainThread()
    }

    companion object {
        val instance: SchedulerProvider by lazy {
            SchedulerProvider()
        }
    }
}