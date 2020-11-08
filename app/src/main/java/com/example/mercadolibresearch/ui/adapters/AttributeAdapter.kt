package com.example.mercadolibresearch.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.domain.model.Attribute
import com.example.mercadolibresearch.R
import com.example.mercadolibresearch.databinding.AttributeItemBinding


class AttributeAdapter : RecyclerView.Adapter<AttributeAdapter.AttributeViewHolder>() {

    private var attributeList: List<Attribute> = ArrayList<Attribute>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AttributeViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = AttributeItemBinding.inflate(layoutInflater, parent, false)

        return AttributeViewHolder(binding)
    }

    override fun onBindViewHolder(holder: AttributeViewHolder, position: Int) {
        holder.bind(attributeList[position])
    }

    fun loadAttributes(attributes: List<Attribute>) {
        attributeList = attributes
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return attributeList.size
    }


    inner class AttributeViewHolder(val binding: AttributeItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(attribute: Attribute) {
            binding.apply {
                binding.tvAttributeName.text = attribute.name
                binding.tvAttributeValue.text = attribute.valueName

                if (adapterPosition % 2 == 0) {
                    binding.tvAttributeName.setBackgroundColor(
                        root.context.getColor(R.color.grey_EBEB)
                    )
                    binding.tvAttributeValue.setBackgroundColor(
                        root.context.getColor(R.color.grey_F5F5)
                    )
                } else {
                    binding.tvAttributeName.setBackgroundColor(
                        root.context.getColor(R.color.grey_F5F5)
                    )
                    binding.tvAttributeValue.setBackgroundColor(
                        root.context.getColor(R.color.white)
                    )
                }

            }
        }
    }
}