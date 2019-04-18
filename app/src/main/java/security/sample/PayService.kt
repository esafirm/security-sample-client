package security.sample

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.IBinder
import security.sample.data.Item

class PayService : Service() {

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        pay(intent?.getParcelableExtra("item"))
        return super.onStartCommand(intent, flags, startId)
    }

    private fun pay(item: Item?) {
        if (item == null) {
            broadcastReturn(false)
            return
        }
        ApiCaller.pay(item.id.toString()) {
            broadcastReturn(it)
        }
    }

    private fun broadcastReturn(isSuccess: Boolean) {
        sendBroadcast(Intent(PAY_ACTION).putExtra("success", isSuccess))
    }

    companion object {

        const val PAY_ACTION = "PayService.PayAction"

        fun start(context: Context, item: Item) {
            context.startService(
                Intent(
                    context,
                    PayService::class.java
                ).putExtra("item", item)
            )
        }
    }
}