package weathercheckter.johnnyzhao.com.weathercheckter.project.components.weatherdetailmodule

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import weathercheckter.johnnyzhao.com.weathercheckter.R
import weathercheckter.johnnyzhao.com.weathercheckter.project.components.Module
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.BaseSchedulerProvider
import java.lang.StringBuilder

class WeatherDetailModule(
    private val schedulerProvider: BaseSchedulerProvider
    ) : Module() ,WeatherDetailContract.View{

    override fun showDetails(weatherDetail: WeatherDetail) {
    }

    override fun onNetworkError(errorMessage: String) {
    }

    private val weatherDetailRepository:WeatherDetailRepository by lazy {
        WeatherDetailRepository(schedulerProvider)
    }

    private val weatherDetailPresenter:WeatherDetailPresenter by lazy {
        WeatherDetailPresenter(schedulerProvider,weatherDetailRepository)
    }

    override fun init(layoutInflater: LayoutInflater, viewGroup: ViewGroup): View {
        val view = layoutInflater.inflate(R.layout.weather_detail_module, viewGroup, false)
        weatherDetailPresenter.attachView(this)
        return view
    }

    override fun cleanUp() {
        weatherDetailPresenter.detachView()
    }
}
