package weathercheckter.johnnyzhao.com.weathercheckter.project.fragment.currentcity

import weathercheckter.johnnyzhao.com.weathercheckter.project.BaseView
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail

interface CurrentCityContract {

    interface View : BaseView {
        fun onWeatherDetailLoad(weatherDetail: WeatherDetail)
    }

    interface Presenter {
        fun loadWeatherDetail(cityId: String)
    }
}