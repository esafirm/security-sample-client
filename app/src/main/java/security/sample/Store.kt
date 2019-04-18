package security.sample

import com.orhanobut.hawk.Hawk

object Store {

    private const val KEY_TOKEN = "Store.Token"

    fun saveToken(token: String) {
        Hawk.put(KEY_TOKEN, token)
    }

    fun getToken(): String {
        return Hawk.get(KEY_TOKEN, "")
    }
}