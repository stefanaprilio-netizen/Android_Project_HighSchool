package com.example.kampustangerang

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.kampustangerang.databinding.ItemCampusBinding

class CampusAdapter(private val campusList: List<Campus>) :
    RecyclerView.Adapter<CampusAdapter.CampusViewHolder>() {

    class CampusViewHolder(val binding: ItemCampusBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CampusViewHolder {
        val binding = ItemCampusBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CampusViewHolder(binding)
    }

    override fun onBindViewHolder(holder: CampusViewHolder, position: Int) {
        val campus = campusList[position]
        holder.binding.apply {
            tvCampusName.text = campus.name
            tvRector.text = "Rektor: ${campus.rector}"
            tvCampusLocation.text = campus.location
            
            val facultiesInfo = campus.faculties.joinToString("\n") { faculty ->
                "• ${faculty.name} (Dekan: ${faculty.dean})\n  Prodi: ${faculty.studyPrograms.joinToString { it.name }}"
            }
            tvFacultiesSummary.text = facultiesInfo

            Glide.with(holder.itemView.context)
                .load(campus.imageUrl)
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(ivCampus)
        }
    }

    override fun getItemCount(): Int = campusList.size
}
