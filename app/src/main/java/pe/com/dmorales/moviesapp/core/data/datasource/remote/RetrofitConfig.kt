package pe.com.dmorales.moviesapp.core.data.datasource.remote


import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import pe.com.dmorales.moviesapp.core.data.datasource.local.preferences.AuthenticationPreferences
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class RetrofitConfig(private val baseUrl: String, private val authSharedPreferences: AuthenticationPreferences) {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(getHttpClient())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getHttpClient(): OkHttpClient {
        val logging = HttpLoggingInterceptor()
        logging.level = HttpLoggingInterceptor.Level.BODY

        val httpClient = OkHttpClient.Builder()
        httpClient.addInterceptor(logging)
            .addInterceptor(object : Interceptor {
                override fun intercept(chain: Interceptor.Chain): Response {
                    val original: Request = chain.request()
                    val request: Request = original.newBuilder()
                        .header("Authorization", "Bearer ${authSharedPreferences.token}")
                        //.header("X-Socket-ID", "${authSharedPreferences.socketId}") //Cuando se necesite se agrega
                        .method(original.method, original.body)
                        .build()

                    return chain.proceed(request)
                }
            })
            .callTimeout(2, TimeUnit.MINUTES)
            .connectTimeout(10, TimeUnit.SECONDS)
            .readTimeout(30, TimeUnit.SECONDS)
            .writeTimeout(30, TimeUnit.SECONDS)
        return httpClient.build()
    }

    fun <T> createService(serviceClass: Class<T>): T {
        return retrofit.create(serviceClass)
    }

}