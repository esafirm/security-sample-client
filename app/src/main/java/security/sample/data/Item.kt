package security.sample.data

import com.google.gson.annotations.SerializedName

data class Item(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("harga") val harga: Int,
    @SerializedName("deskripsi") val desc: String
)