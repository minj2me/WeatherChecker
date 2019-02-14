package weathercheckter.johnnyzhao.com.weathercheckter.project.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import weathercheckter.johnnyzhao.com.weathercheckter.project.network.models.Forecast

@Parcelize
open class WeatherDetailData(
    val pm25: Int? = null,
    val pm10: Int? = null,
    val quality: String? = null,
    @field:SerializedName("wendu")
    val temperature: String? = null,
    @field:SerializedName("shidu")
    val humidity: String? = null,
    //感冒提醒
    @field:SerializedName("ganmao")
    val coldNotice: String? = null,
    val yesterday: Forecast? = null,
    val forecast: Array<Forecast>? = null
) : Parcelable