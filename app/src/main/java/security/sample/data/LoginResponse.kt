package security.sample.data

import com.google.gson.annotations.SerializedName

data class LoginResponse(
    @SerializedName("message") val message: String? = null,
    @SerializedName("token") val token: String? = null
)