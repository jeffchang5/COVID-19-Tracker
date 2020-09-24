package io.jeffchang.covidtracking.ui.dailycase.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import io.jeffchang.DailyCaselist.databinding.ItemDailyCaseBinding
import io.jeffchang.covidtracking.ui.dailycase.data.model.daily.DailyCase

class DailyCaseListAdapter
    : ListAdapter<DailyCase, DailyCaseListAdapter.DailyCaseViewHolder>(DailyCaseDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DailyCaseViewHolder {
        val binding = ItemDailyCaseBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return DailyCaseViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DailyCaseViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    class DailyCaseViewHolder(private val binding: ItemDailyCaseBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(dailyCase: DailyCase) {
            binding.apply {
                val context = root.context

//                // Sets fields or use default values.
//                titleTextView.text = DailyCase.name ?: context.getText(R.string.missing_data)
//                teamTextView.text = DailyCase.alias ?: context.getText(R.string.missing_data)
//
//                // Binds image with placeholders or defaults.
//                Glide.with(context)
//                    .load(DailyCase.imageUrl)
//                    .apply(
//                        RequestOptions()
//                            .error(R.drawable.ic_baseline_none_24)
//                            .placeholder(R.color.placeholder)
//                            .centerCrop()
//                    )
//                    .into(DailyCaseImageView)
            }
        }
    }

    private class DailyCaseDiffCallback : DiffUtil.ItemCallback<DailyCase>() {
        override fun areItemsTheSame(oldItem: DailyCase, newItem: DailyCase): Boolean =
            oldItem === newItem

        override fun areContentsTheSame(oldItem: DailyCase, newItem: DailyCase): Boolean =
            oldItem == newItem
    }
}
