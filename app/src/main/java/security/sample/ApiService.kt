package security.sample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import security.sample.data.ItemListResponse
import security.sample.data.LoginResponse
import security.sample.data.PayResponse


interface ApiService {

    @GET("login")
    fun login(@Query("apiKey") apiKey: String): Call<LoginResponse>

    @GET("items")
    fun getItemList(
        @Query("apiKey") apiKey: String,
        @Query("token") token: String
    ): Call<ItemListResponse>

    @GET("pay")
    fun pay(
        @Query("apiKey") apiKey: String,
        @Query("token") token: String,
        @Query("itemId") itemId: String
    ): Call<PayResponse>
}