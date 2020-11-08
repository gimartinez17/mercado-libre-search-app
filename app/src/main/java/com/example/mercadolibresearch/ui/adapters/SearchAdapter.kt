package com.example.mercadolibresearch.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.mercadolibresearch.R
import com.example.mercadolibresearch.databinding.ProductItemBinding
import com.example.mercadolibresearch.model.ProductModel
import com.example.mercadolibresearch.utils.*


class SearchAdapter(val listener: OnProductClickListener) :
    RecyclerView.Adapter<SearchAdapter.SearchViewHolder>() {

    private var productList = ArrayList<ProductModel>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SearchViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = ProductItemBinding.inflate(layoutInflater, parent, false)
        return SearchViewHolder((binding))
    }

    override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
        holder.bind(productList[position])
        holder.itemView.setOnClickListener {
            listener.onProductClickListener(productList[position].id)
        }
    }

    override fun getItemCount(): Int {
        return productList.size
    }

    fun loadProducts(products: List<ProductModel>) {
        productList.clear()
        productList.addAll(products)
        notifyDataSetChanged()
    }

    inner class SearchViewHolder(val binding: ProductItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(product: ProductModel) {
            binding.apply {
                when {
                    product.isBestSeller() -> {
                        tvHighlightLabel.text =
                            root.context.getString(R.string.best_seller_candidate)
                        tvHighlightLabel.visibility = View.VISIBLE
                        tvHighlightLabel.setBackgroundResource(R.color.orange)
                    }
                    product.isDealOfTheDay() -> {
                        root.context.getString(R.string.deal_of_the_day)
                        tvHighlightLabel.visibility = View.VISIBLE
                        tvHighlightLabel.setBackgroundResource(R.color.blue)
                    }
                    else -> {
                        tvHighlightLabel.visibility = View.GONE
                    }
                }
                Glide.with(root.context)
                    .load(product.thumbnail)
                    .into(imgProduct)
                tvTitle.text = product.title
                tvPrice.text = root.context.getString(
                    R.string.product_price,
                    getPriceFormatted(product.price)
                )
                product.originalPrice?.let {
                    if (product.price != product.originalPrice) {
                        tvOffLabel.visibility = View.VISIBLE
                        tvOffLabel.text = root.context.getString(
                            R.string.product_percentage_off,
                            getPercentageOff(product.price, product.originalPrice)
                        )
                    }
                }
                tvFreeShipping.visibility = if (product.freeShipping) View.VISIBLE else View.GONE
                imgFullLabel.visibility = if (product.isFulfillment()) View.VISIBLE else View.GONE
            }
        }
    }
}