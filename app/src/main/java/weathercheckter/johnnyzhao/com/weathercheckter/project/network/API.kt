package weathercheckter.johnnyzhao.com.weathercheckter.project.network

import com.google.gson.JsonObject
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface API {

    //http://t.weather.sojson.com/api/weather/city/city_code
    @GET("{city_code}")
    fun getWeather(
        @Path("city_code") cityCode: String
    ): Single<JsonObject>
}