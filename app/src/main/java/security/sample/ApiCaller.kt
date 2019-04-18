package security.sample

import com.facebook.stetho.okhttp3.StethoInterceptor
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import security.sample.data.Item
import security.sample.data.ItemListResponse
import security.sample.data.LoginResponse
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.converter.gson.GsonConverterFactory
import security.sample.data.PayResponse

object ApiCaller {

    private const val API_KEY = ""

    private val service by lazy {
        val logging = HttpLoggingInterceptor { message ->
            // TODO implement our own logger
        }
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .addNetworkInterceptor(StethoInterceptor())
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dago.netlify.com/.netlify/functions/")
            .build()

        retrofit.create(ApiService::class.java)
    }

    fun login(onResponse: (Boolean) -> Unit) {
        service.login(API_KEY).enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
                onResponse(false)
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
                onResponse(true)
            }
        })
    }

    fun getItem(onResponse: (List<Item>) -> Unit) {
        service.getItemList(API_KEY, "xxxxx").enqueue(object : Callback<ItemListResponse> {
            override fun onFailure(call: Call<ItemListResponse>, t: Throwable) {
                onResponse(emptyList())
            }

            override fun onResponse(call: Call<ItemListResponse>, response: Response<ItemListResponse>) {
                onResponse(response.body()?.items ?: emptyList())
            }
        })
    }

    fun pay(onResponse: (Boolean) -> Unit) {
        service.pay(API_KEY, "xxxxx").enqueue(object : Callback<PayResponse> {
            override fun onFailure(call: Call<PayResponse>, t: Throwable) {
                onResponse(false)
            }

            override fun onResponse(call: Call<PayResponse>, response: Response<PayResponse>) {
                onResponse(true)
            }
        })
    }
}