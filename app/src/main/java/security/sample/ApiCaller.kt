package security.sample

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

object ApiCaller {

    private val service by lazy {
        val logging = HttpLoggingInterceptor { message ->
            // TODO implement our own logger
        }
        logging.level = HttpLoggingInterceptor.Level.BASIC

        val client = OkHttpClient.Builder()
            .addInterceptor(logging)
            .build()

        val retrofit = Retrofit.Builder()
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://dago.netlify.com/.netlify/functions/")
            .build()

        retrofit.create(ApiService::class.java)
    }

    fun login(onSuccess: () -> Unit) {
        service.login("").enqueue(object : Callback<LoginResponse> {
            override fun onFailure(call: Call<LoginResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<LoginResponse>, response: Response<LoginResponse>) {
            }
        })
    }

    fun getItem(onSuccess: (List<Item>) -> Unit) {
        service.getItemList("", "").enqueue(object : Callback<ItemListResponse> {
            override fun onFailure(call: Call<ItemListResponse>, t: Throwable) {
            }

            override fun onResponse(call: Call<ItemListResponse>, response: Response<ItemListResponse>) {
            }
        })
    }
}