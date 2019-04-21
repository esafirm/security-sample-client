package security.sample

import android.app.ProgressDialog
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_pay.*
import security.sample.data.Item

class PayActivity : AppCompatActivity() {

    private val progressDialog by lazy {
        ProgressDialog(this).apply {
            setMessage("Paying...")
        }
    }

    private val receiver by lazy {
        object : BroadcastReceiver() {
            override fun onReceive(context: Context?, intent: Intent?) {
                progressDialog.dismiss()
                finish()
            }
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pay)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val item = intent.getParcelableExtra<Item>("item")
        txtName.text = item.name
        txtPrice.text = item.harga.toString()
        txtDescription.text = item.desc

        btnPay.setOnClickListener {
            progressDialog.show()
            PayService.start(this, item)
        }
    }

    override fun onStart() {
        super.onStart()
        // Listen to PayService notification
        registerReceiver(receiver, IntentFilter(PayService.PAY_ACTION))
    }

    override fun onStop() {
        super.onStop()
        // Stop listen to PayService
        unregisterReceiver(receiver)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        // Kill the Activity when toolbar back pressed
        finish()
        return super.onOptionsItemSelected(item)
    }
}