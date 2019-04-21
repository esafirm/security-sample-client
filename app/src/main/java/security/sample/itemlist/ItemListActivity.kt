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
import security.sample.data.Item

class ItemListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        // Define OnItemClick listener
        val onClick = { item: Item ->
            val intent = Intent(this, PayActivity::class.java)
            intent.putExtra("item", item)
            startActivity(intent)
        }

        // Set RecyclerView adapter
        val adapter = ItemListAdapter(onClick)

        // Set LayoutManager and Adapter to RecyclerView
        recycler.layoutManager = LinearLayoutManager(this)
        recycler.adapter = adapter

        // Call the API
        ApiCaller.getItem {
            progressBar.visibility = View.GONE
            adapter.setData(it)
        }
    }
}
