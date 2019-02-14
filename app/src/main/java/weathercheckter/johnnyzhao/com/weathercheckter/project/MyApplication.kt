package weathercheckter.johnnyzhao.com.weathercheckter.project

import android.app.Application
import android.content.Context
import com.facebook.stetho.Stetho
import io.reactivex.plugins.RxJavaPlugins
import timber.log.Timber

class MyApplication : Application() {

    companion object {
        private lateinit var appContext: Context;
        //static
        @JvmStatic
        fun getAppContext(): Context {
            return appContext;
        }
    }

    override fun onCreate() {
        super.onCreate()

        //if (BuildConfig.DEBUG) {
        Timber.plant(Timber.DebugTree())
        //Stetho.initializeWithDefaults(this)
//        } else {
//            Timber.plant(CrashReportingTree())
//        }

        // Logs all uncaught exceptions from RxJava usage and prevents default thread handling
        RxJavaPlugins.setErrorHandler { throwable -> Timber.e(throwable) }
    }
}