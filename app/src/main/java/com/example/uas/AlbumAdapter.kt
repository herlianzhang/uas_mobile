package com.example.uas

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.uas.databinding.MyAdapterViewBinding

class AlbumAdapter(private val onClickListener: OnClickListener) : ListAdapter<Album, AlbumAdapter.ViewHolder>(DiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder.from(parent)

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)

        holder.button.setOnClickListener {
            onClickListener.onDeleteAlbum(item)
        }
    }

    class ViewHolder private constructor(private val binding: MyAdapterViewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        val button = binding.hapus

        fun bind(item: Album) {
            binding.namaAlbum.text = item.name
            binding.genre.text = item.genre
            binding.tglRilis.text = item.realiseDate
            binding.jumlah.text = item.sellCount.toString()
            binding.totalPendapatan.text = item.totalSell.toString()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = MyAdapterViewBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<Album>() {
        override fun areItemsTheSame(oldItem: Album, newItem: Album) = oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Album, newItem: Album) = oldItem == newItem
    }
}

interface OnClickListener {
    fun onDeleteAlbum(album: Album)
}
