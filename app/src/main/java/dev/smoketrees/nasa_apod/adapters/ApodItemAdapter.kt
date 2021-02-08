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
    private var items: MutableList<ApodItem>,
    private val onClick: (Int) -> Unit,
    private val onFavClick: (Int) -> Unit
) : RecyclerView.Adapter<ApodItemAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ApodItemBinding.inflate(LayoutInflater.from(parent.context))
        return ViewHolder(binding, onClick, onFavClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position, items[position])
    }

    override fun getItemCount() = items.size

    fun updateItems(newItems: List<ApodItem>) {
        items.clear()
        items.addAll(newItems)
        notifyDataSetChanged()
    }

    class ViewHolder(
        private val binding: ApodItemBinding,
        private val onClick: (Int) -> Unit,
        private val onFavClick: (Int) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int, item: ApodItem) {
            binding.apply {
                apodTitle.text = item.title

                val circularProgressDrawable = CircularProgressDrawable(itemView.context)
                circularProgressDrawable.apply {
                    setColorSchemeColors(Color.rgb(105, 240, 174))
                    strokeWidth = 10f
                    centerRadius = 40f
                    start()
                }

                binding.favButton.setOnClickListener { onFavClick(position) }

                Glide.with(itemView)
                    .load(item.url)
                    .placeholder(circularProgressDrawable)
                    .into(apodImage)

                containerCard.setOnClickListener { onClick(position) }
            }
        }
    }
}