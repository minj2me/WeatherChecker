package weathercheckter.johnnyzhao.com.weathercheckter.project.components.weatherdetailmodule

import io.reactivex.Single
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.BaseSchedulerProvider

class WeatherDetailRepository(private val baseSchedulerProvider: BaseSchedulerProvider) {

    fun getWeatherDetail(cityId: String): Single<WeatherDetail>? {
        return null
    }
}