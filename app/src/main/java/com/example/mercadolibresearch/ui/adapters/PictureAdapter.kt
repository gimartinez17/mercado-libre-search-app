package com.example.mercadolibresearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadolibresearch.databinding.PictureItemBinding


class PictureAdapter : RecyclerView.Adapter<PictureAdapter.PictureViewHolder>() {

    private var pictureList: List<String> = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PictureViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = PictureItemBinding.inflate(layoutInflater, parent, false)
        return PictureViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PictureViewHolder, position: Int) {
        holder.bind(pictureList[position])
    }

    override fun getItemCount(): Int {
        return pictureList.size
    }

    fun loadPictures(pictures: List<String>) {
        pictureList = pictures
        notifyDataSetChanged()
    }

    inner class PictureViewHolder(val binding: PictureItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(picture: String) {
            Glide.with(binding.root.context)
                .load(picture)
                .into(binding.imgProductPicture)
        }
    }
}