package security.sample.itemlist

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import kotlinx.android.synthetic.main.activity_list.*
import security.sample.ApiCaller
import security.sample.PayActivity
import security.sample.R

class ItemListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Set RecyclerView adapter
        val adapter = ItemListAdapter {
            startActivity(Intent(this, PayActivity::class.java))
        }
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // Call the API
        ApiCaller.getItem {
            progressBar.visibility = View.VISIBLE
            adapter.setData(it)
        }
    }
}
