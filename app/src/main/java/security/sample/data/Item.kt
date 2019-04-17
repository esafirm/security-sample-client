package security.sample.data

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Item(
    @SerializedName("id") val id: Int,
    @SerializedName("name") val name: String,
    @SerializedName("harga") val harga: Int,
    @SerializedName("deskripsi") val desc: String
) : Parcelable