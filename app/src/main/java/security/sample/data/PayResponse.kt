package security.sample.data

import com.google.gson.annotations.SerializedName

data class PayResponse(
    @SerializedName("message") val message: String
)