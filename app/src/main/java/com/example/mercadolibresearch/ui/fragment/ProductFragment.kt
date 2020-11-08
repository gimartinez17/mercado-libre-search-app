package com.example.mercadolibresearch.ui.fragment

import android.graphics.Paint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.viewpager2.widget.ViewPager2
import com.example.domain.model.Attribute
import com.example.mercadolibresearch.R
import com.example.mercadolibresearch.databinding.FragmentProductBinding
import com.example.mercadolibresearch.model.DetailProductModel
import com.example.mercadolibresearch.ui.adapters.AttributeAdapter
import com.example.mercadolibresearch.ui.adapters.PictureAdapter
import com.example.mercadolibresearch.ui.viewmodel.ProductViewModel
import com.example.mercadolibresearch.utils.getPercentageOff
import com.example.mercadolibresearch.utils.getPriceFormatted
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ProductFragment : Fragment() {

    private lateinit var binding: FragmentProductBinding
    private lateinit var pictureAdapter: PictureAdapter
    private lateinit var attributeAdapter: AttributeAdapter
    private lateinit var id: String

    private val productViewModel: ProductViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProductBinding.inflate(inflater, container, false)
        arguments?.let {
            id = it.getString(KEY_PRODUCT_ID) ?: ""
        }
        setupView()
        setupObservers()
        return binding.root
    }

    fun setupView() {
        pictureAdapter = PictureAdapter()
        with(binding.viewPagerSlider) {
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
            adapter = pictureAdapter
        }

        attributeAdapter = AttributeAdapter()
        with(binding.rvProductsAttributes) {
            setHasFixedSize(true)
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = attributeAdapter
        }
    }

    fun setupObservers() {
        productViewModel.productDetail.observe(viewLifecycleOwner, Observer {
            setProductDetails(it)
        })

        productViewModel.isLoading.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                binding.productProgressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
        productViewModel.getProductDetail(id)
    }

    private fun setProductDetails(details: DetailProductModel) {
        binding.apply {
            attributeAdapter.loadAttributes(details.attribute.filterAll(attributesFilter()).take(8))
            pictureAdapter.loadPictures(details.pictures)

            val condition = if (details.condition == "used") getString(R.string.product_used) else getString(R.string.product_new)

            tvProductConditionAndQuantity.text =
                getString(
                    R.string.product_condition_quantity,
                    condition, details.soldQuantity
                )
            tvProductTitle.text = details.title
            details.originalPrice?.let {
                if (details.price < it) {
                    groupPriceOff.visibility = View.VISIBLE
                    tvProductOriginalPrice.text = root.context.getString(
                        R.string.product_original_price,
                        getPriceFormatted(details.originalPrice)
                    )
                    tvProductOriginalPrice.paintFlags = tvProductOriginalPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                    tvProductOffLabel.text = root.context.getString(
                        R.string.product_percentage_off,
                        getPercentageOff(details.price, details.originalPrice)
                    )
                }
            }
            tvProductPrice.text = root.context.getString(
                R.string.product_price,
                getPriceFormatted(details.price)
            )
            if (details.availableQuantity > 0) {
                groupQuantityStock.visibility = View.VISIBLE
                tvProductAvailableStock.text = getString(
                    R.string.product_available_quantity,
                    details.availableQuantity
                )
                btnBuyProduct.visibility = View.VISIBLE
                btnAddToCart.visibility = View.VISIBLE
            }
        }
    }

    private fun attributesFilter() = listOf<(Attribute) -> Boolean>(
        { it.valueID != null },
        { it.valueName != null }
    )

    private fun <T> List<T>.filterAll(filters: List<(T) -> Boolean>) =
        filter { item -> filters.all { filter -> filter(item) } }


    companion object {
        const val KEY_PRODUCT_ID = "key_product_id"

        @JvmStatic
        fun newInstance(id: String) = ProductFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_PRODUCT_ID, id)
            }
        }
    }
}