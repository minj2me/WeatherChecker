package weathercheckter.johnnyzhao.com.weathercheckter.project.network

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import weathercheckter.johnnyzhao.com.weathercheckter.project.BASE_REQUEST_URL

val createRetrofit: Retrofit by lazy {
    Retrofit.Builder()
        .baseUrl(BASE_REQUEST_URL)
        .client(okHttpClient)
        //Retrofit2+Rxjava2如何主动取消网络请求
        //https://blog.csdn.net/oqqYYYY1/article/details/78740920
        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}

val okHttpClient: OkHttpClient by lazy {
    val builder = OkHttpClient.Builder()
//    if (BuildConfig.DEBUG) {
//        val loggingInterceptor = HttpLoggingInterceptor()
//        loggingInterceptor.level = HttpLoggingInterceptor.Level.BODY
//        builder.addInterceptor(loggingInterceptor)
//    }
    builder.build()
}