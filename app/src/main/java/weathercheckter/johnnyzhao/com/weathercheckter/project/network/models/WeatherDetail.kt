package weathercheckter.johnnyzhao.com.weathercheckter.project.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class WeatherDetail(
    val cityInfo: CityInfo? = null,
    @field:SerializedName("data")
    val weatherDetailData: WeatherDetailData?=null
) : Parcelable