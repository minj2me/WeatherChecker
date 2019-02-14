package weathercheckter.johnnyzhao.com.weathercheckter.project.components.weatherdetailmodule

import weathercheckter.johnnyzhao.com.weathercheckter.project.BasePresenter
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.BaseSchedulerProvider

class WeatherDetailPresenter(
    private val schedulerProvider: BaseSchedulerProvider,
    private val weatherDetailRepository: WeatherDetailRepository
) : BasePresenter<WeatherDetailContract.View>(), WeatherDetailContract.Presenter {

    override fun getDetails(cityId: String) {
    }
}