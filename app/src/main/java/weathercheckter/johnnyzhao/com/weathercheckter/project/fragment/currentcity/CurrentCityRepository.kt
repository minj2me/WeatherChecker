package weathercheckter.johnnyzhao.com.weathercheckter.project.fragment.currentcity

import com.google.gson.Gson
import io.reactivex.Single
import timber.log.Timber
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.API
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.createRetrofit
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.BaseSchedulerProvider

class CurrentCityRepository (private val baseSchedulerProvider: BaseSchedulerProvider) {

    fun getWeatherDetail(cityId: String): Single<WeatherDetail> {
        Timber.tag("weathercheckter_tag")
        Timber.d("start to fetch weather detail")
        return createRetrofit.create(API::class.java)
            .getWeather(cityId)
            //subscribeOn通过接收一个Scheduler参数，来指定对数据的处理运行在特定的线程调度器Scheduler上。
            //若多次设定，则只有一次起作用。
            .subscribeOn(baseSchedulerProvider.io())
            .map {
                Timber.tag("weathercheckter_tag")
                Timber.d("weather detail fetched, parsing response")
                Gson().fromJson(it, WeatherDetail::class.java)
            }
    }
}