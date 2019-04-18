package security.sample

import android.app.Application
import com.facebook.stetho.Stetho

class SampleApp : Application() {
    override fun onCreate() {
        super.onCreate()
        Stetho.initializeWithDefaults(this)
    }
}