package weathercheckter.johnnyzhao.com.weathercheckter.project.fragment.currentcity

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_current_city.*
import timber.log.Timber
import weathercheckter.johnnyzhao.com.weathercheckter.R
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.WeatherDetail
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.SchedulerProvider
import java.lang.StringBuilder

class CurrentCityFragment : Fragment(), CurrentCityContract.View {

    companion object {
        const val TAG="CurrentCityFragment"
    }

    override fun onNetworkError(errorMessage: String) {
        Snackbar.make(tvText, errorMessage, Snackbar.LENGTH_LONG).show()
    }

    private val schedulerProvider:SchedulerProvider by lazy {
        SchedulerProvider.instance
    }

    private val currentCityRepository:CurrentCityRepository by lazy {
        CurrentCityRepository(schedulerProvider)
    }

    private val currentCityPresenter:CurrentCityPresenter by lazy {
        CurrentCityPresenter(schedulerProvider,currentCityRepository)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val inflate = inflater.inflate(R.layout.fragment_current_city, container, false)
        setHasOptionsMenu(true)
        currentCityPresenter.attachView(this)
        lifecycle.addObserver(currentCityPresenter)
        //get data,hardcode for gz
        Timber.d("fragment onCreateView")
        currentCityPresenter.loadWeatherDetail("101280101")
        return inflate
    }

    override fun onWeatherDetailLoad(weatherDetail: WeatherDetail) {
        val cityInfo = weatherDetail.cityInfo
        tvText.setText("Last updated: "+cityInfo?.updateTime)
        val weatherDetailData = weatherDetail.weatherDetailData
        val sb = StringBuilder()
        sb.append("Temperature: "+weatherDetailData?.temperature)
        sb.append("\n")
        sb.append("Humidity: "+weatherDetailData?.humidity)
        sb.append("\n")
        sb.append("PM25: "+weatherDetailData?.pm25)
        sb.append("\n")
        sb.append("PM10: "+weatherDetailData?.pm10)
        sb.append("\n")
        sb.append("Quality:"+weatherDetailData?.quality)
        sb.append("\n\n")
        sb.append(weatherDetailData?.coldNotice)
        tvText2.setText(sb.toString())
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}