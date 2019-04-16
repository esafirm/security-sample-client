package security.sample

import retrofit2.Call
import retrofit2.http.GET
import security.sample.data.ItemListResponse
import security.sample.data.LoginResponse
import security.sample.data.PayResponse


interface ApiService {

    @GET("login")
    fun login(apiKey: String): Call<LoginResponse>

    @GET("item")
    fun getItemList(): Call<ItemListResponse>

    @GET("pay")
    fun pay(): Call<PayResponse>
}