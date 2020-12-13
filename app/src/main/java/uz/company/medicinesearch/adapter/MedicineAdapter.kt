package uz.company.medicinesearch.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.medicine_item.view.*
import uz.company.medicinesearch.R
import uz.company.medicinesearch.models.Medicine
import java.security.AllPermission

class MedicineAdapter(private val allMediceine:ArrayList<Medicine>):RecyclerView.Adapter<MedicineAdapter.ViewHolder>(), Filterable {


    var onItemClick: ((Int,String) -> Unit)? = null

    private var medicineList:ArrayList<Medicine>

    init {
        medicineList=allMediceine
    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.medicine_item, parent, false)
    )




    override fun getItemCount()=medicineList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindData(medicineList[position])
    }


    inner class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val medicineText=itemView.findViewById<TextView>(R.id.medicineText)


        init {
            itemView.setOnClickListener {
                onItemClick?.invoke(medicineList[adapterPosition]!!.id,medicineList[adapterPosition]!!.name)
            }
        }

        fun bindData(medicine: Medicine){
            medicineText.text=medicine.name
        }
    }

    override fun getFilter(): Filter {
        return filter
    }

    private val filter: Filter = object : Filter(){
        override fun performFiltering(charSequence: CharSequence): FilterResults {
            val queryString = charSequence?.toString()?.toLowerCase()

            val filterResults = Filter.FilterResults()
            filterResults.values = if (queryString==null || queryString.isEmpty())
                allMediceine
            else
                allMediceine.filter {
                    it.name.toLowerCase().contains(queryString)
                }
            return filterResults

        }

        override fun publishResults(p0: CharSequence?, filterResults: FilterResults) {
            medicineList = filterResults.values as ArrayList<Medicine>
            notifyDataSetChanged()
        }

    }


}