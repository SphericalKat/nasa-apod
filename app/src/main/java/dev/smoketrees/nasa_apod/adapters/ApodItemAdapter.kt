package dev.smoketrees.nasa_apod.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import dev.smoketrees.nasa_apod.data.model.ApodItem
import dev.smoketrees.nasa_apod.databinding.ApodItemBinding

class ApodItemAdapter(
    private val items: List<ApodItem>
) : RecyclerView.Adapter<ApodItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ApodItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(
        private val binding: ApodItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, item: ApodItem) {
            binding.apodTitle.text = item.title

            val circularProgressDrawable = CircularProgressDrawable(itemView.context)
            circularProgressDrawable.apply {
                setColorSchemeColors(Color.rgb(105, 240, 174))
                strokeWidth = 10f
                centerRadius = 40f
                start()
            }

            Glide.with(itemView)
                .load(item.url)
                .placeholder(circularProgressDrawable)
                .into(binding.apodImage)
        }
    }
}