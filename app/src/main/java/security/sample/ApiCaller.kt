package security.sample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import security.sample.data.Item
import security.sample.data.ItemListResponse
import security.sample.data.LoginResponse


object ApiCaller {

    private val service by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.github.com/")
            .build()

        retrofit.create(ApiService::class.java)
    }

    fun login() {
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