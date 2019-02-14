package weathercheckter.johnnyzhao.com.weathercheckter.project.components.weatherdetailmodule

import weathercheckter.johnnyzhao.com.weathercheckter.project.BaseView
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail

interface WeatherDetailContract {

    interface View : BaseView {
        fun showDetails(weatherDetail: WeatherDetail)
    }

    interface Presenter {
        fun getDetails(cityId: String)
    }
}