package security.sample

import android.app.Application
import com.facebook.stetho.Stetho
import com.orhanobut.hawk.Hawk
import timber.log.Timber

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
        Timber.plant(Timber.DebugTree())

        Hawk.init(this).build()
    }
}