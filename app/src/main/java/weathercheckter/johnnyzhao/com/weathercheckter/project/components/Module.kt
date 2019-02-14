package weathercheckter.johnnyzhao.com.weathercheckter.project.components

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

abstract class Module {
    abstract fun init(layoutInflater: LayoutInflater, viewGroup: ViewGroup): View
    abstract fun cleanUp()
}