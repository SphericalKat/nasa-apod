package dev.smoketrees.nasa_apod.adapters

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import dev.smoketrees.nasa_apod.data.model.ApodItem
import dev.smoketrees.nasa_apod.databinding.DetailsItemBinding

class DetailsItemAdapter(
    private val items: List<ApodItem>,
) : RecyclerView.Adapter<DetailsItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = DetailsItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    override fun getItemCount() = items.size

    class ViewHolder(private val binding: DetailsItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: ApodItem) {
            binding.apply {
                title.text = item.title
                item.copyright?.let {
                    copyright.text = "© $it"
                    copyright.visibility = View.VISIBLE
                }
                date.text = item.date
                explanation.text = item.explanation
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
                    .into(image)
            }
        }
    }
}