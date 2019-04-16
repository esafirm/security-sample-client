package security.sample.data

import com.google.gson.annotations.SerializedName

data class ItemListResponse(
    @SerializedName("message") val message: String? = null,
    @SerializedName("items") val items: List<Item> = emptyList()
)