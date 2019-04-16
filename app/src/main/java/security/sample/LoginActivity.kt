package security.sample

import android.app.ProgressDialog
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_login.*
import security.sample.itemlist.ItemListActivity

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        supportActionBar?.hide()

        btn_login.setOnClickListener {

            val progressDialog = ProgressDialog(this).apply {
                setMessage("Please wait...")
                setCancelable(false)
            }
            progressDialog.show()

            ApiCaller.login { isSuccess ->
                progressDialog.dismiss()
                if (isSuccess) {
                    finish()
                    startActivity(Intent(this, ItemListActivity::class.java))
                }
            }
        }
    }
}