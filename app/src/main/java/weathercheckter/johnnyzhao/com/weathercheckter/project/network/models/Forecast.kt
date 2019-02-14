package weathercheckter.johnnyzhao.com.weathercheckter.project.network.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

/**
 * date: "02",
sunrise: "07:19",
high: "高温 4.0℃",
low: "低温 -2.0℃",
sunset: "17:32",
aqi: 135,
ymd: "2019-02-02",
week: "星期六",
fx: "西北风",
fl: "<3级",
type: "阴",
notice: "不要被阴云遮挡住好心情"
 * */
@Parcelize
data class Forecast(
    @field:SerializedName("date")
    val dateString:String?=null,
    val sunrise:String?=null,
    val high:String?=null,
    val low:String?=null,
    val sunset:String?=null,
    val aqi:Int?=null,
    val ymd:String?=null,
    val week:String?=null,
    @field:SerializedName("fx")
    val windDirection:String?=null,
    @field:SerializedName("fl")
    val windStrength:String?=null,
    val type:String?=null,
    val notice:String?=null
):Parcelable