package com.example.recyclerview

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val recyclerView = RecyclerView = findViewById(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = Adapter(this, fetchList())
    }
    private fun fetchList(): ArrayList<ColorData> {
        val list = arrayListOf<ColorData>()
    }
}
data class ColorData(
    val colorName: String,
    val colorHex: Int
)
class Adapter(private val context: Context,
              private val list: ArrayList<ColorData>):
        RecyclerView.Adapter<Adapter.ViewHolder>() {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val colorName: View = view.findViewById(R.id.colorName)
        val colorHex: View = view.findViewById(R.id.colorHex)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.cell_view, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.count()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val data = list[position]
        holder.colorName.setImageDrawable(ContextCompat.getDrawable(context, data.icon))
        holder.colorHex.text = data.Hex
    }
}