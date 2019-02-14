package weathercheckter.johnnyzhao.com.weathercheckter.project.fragment.currentcity

import timber.log.Timber
import weathercheckter.johnnyzhao.com.weathercheckter.project.BasePresenter
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.schedulers.BaseSchedulerProvider

class CurrentCityPresenter(
    private val schedulerProvider: BaseSchedulerProvider,
    private val currentCityRepository: CurrentCityRepository
) : BasePresenter<CurrentCityContract.View>(), CurrentCityContract.Presenter {

    override fun loadWeatherDetail(cityId: String) {
        Timber.d("loadWeatherDetail")
        compositeDisposable.add(
            currentCityRepository.getWeatherDetail(cityId)
                .observeOn(schedulerProvider.ui())
                .subscribe({
                    currentView?.onWeatherDetailLoad(it)
                }, { Timber.e(it.localizedMessage) })
        )
    }
}