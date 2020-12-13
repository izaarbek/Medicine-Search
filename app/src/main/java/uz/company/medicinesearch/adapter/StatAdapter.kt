package uz.company.medicinesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import uz.company.medicinesearch.R

import uz.company.medicinesearch.models.Stat

class StatAdapter : RecyclerView.Adapter<StatAdapter.ViewHolder>() {

    private var statList = arrayListOf<Stat>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.stat_item, parent, false)
    )

    fun setItems(stats: List<Stat>) {
        this.statList.clear()
        this.statList.addAll(stats)
        notifyDataSetChanged()
    }

    override fun getItemCount() = statList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(statList[position])
    }


    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val statImage = itemView.findViewById<ImageView>(R.id.statImg)
        val statTitle = itemView.findViewById<TextView>(R.id.statTitle)
        fun bindData(stat: Stat) {
            statImage.setImageResource(stat.image)
            statTitle.text = stat.title
        }

    }


}