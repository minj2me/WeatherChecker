package weathercheckter.johnnyzhao.com.weathercheckter.project.network.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * cityInfo: {
city: "天津市",
cityId: "101030100",
parent: "天津",
updateTime: "12:38"
},
 * */
@Parcelize
data class CityInfo(
    val city: String? = null,
    val cityId: String? = null,
    val parent: String? = null,
    val updateTime: String? = null
) : Parcelable