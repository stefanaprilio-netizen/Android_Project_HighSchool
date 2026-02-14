package com.example.kampustangerang;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import com.example.kampustangerang.databinding.ItemCampusBinding;
import java.util.List;

public class CampusAdapter extends RecyclerView.Adapter<CampusAdapter.CampusViewHolder> {

    private List<Campus> campusList;

    public CampusAdapter(List<Campus> campusList) {
        this.campusList = campusList;
    }

    @NonNull
    @Override
    public CampusViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemCampusBinding binding = ItemCampusBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new CampusViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull CampusViewHolder holder, int position) {
        Campus campus = campusList.get(position);
        holder.binding.tvCampusName.setText(campus.getName());
        holder.binding.tvCampusLocation.setText(campus.getLocation());
        holder.binding.tvCampusDescription.setText(campus.getDescription());

        Glide.with(holder.itemView.getContext())
                .load(campus.getImageUrl())
                .placeholder(android.R.drawable.ic_menu_gallery)
                .error(android.R.drawable.ic_menu_report_image)
                .into(holder.binding.ivCampus);
    }

    @Override
    public int getItemCount() {
        return campusList.size();
    }

    public static class CampusViewHolder extends RecyclerView.ViewHolder {
        ItemCampusBinding binding;

        public CampusViewHolder(ItemCampusBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
