package com.example.mercadolibresearch.ui.fragment

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mercadolibresearch.R
import com.example.mercadolibresearch.databinding.FragmentSearchBinding
import com.example.mercadolibresearch.model.ProductModel
import com.example.mercadolibresearch.ui.adapters.OnProductClickListener
import com.example.mercadolibresearch.ui.adapters.SearchAdapter
import com.example.mercadolibresearch.ui.viewmodel.SearchViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SearchFragment : Fragment(), OnProductClickListener {

    private lateinit var binding: FragmentSearchBinding
    private lateinit var searchAdapter: SearchAdapter
    private val searchViewModel: SearchViewModel by activityViewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        setupView()
        setupObservers()
        setupListeners()
        return binding.root
    }

    private fun setupView() {
        searchAdapter = SearchAdapter(this@SearchFragment)
        with(binding.recyclerViewSearch) {
            setHasFixedSize(true)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)
            adapter = searchAdapter
//            addOnScrollListener()
        }
    }

    private fun setupObservers() {
        searchViewModel.products.observe(viewLifecycleOwner, Observer { response ->
            binding.viewEmpty.groupEmptyMessage.visibility = View.GONE
            if (response.paging.total == 0) {
                binding.recyclerViewSearch.visibility = View.GONE
                binding.tvNoResults.visibility = View.VISIBLE
            } else {
                binding.tvNoResults.visibility = View.GONE
                binding.recyclerViewSearch.visibility = View.VISIBLE
                searchAdapter.loadProducts(response.results.map { ProductModel.convertTo(it) })
            }
        })
        searchViewModel.isLoading.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                binding.viewEmpty.groupEmptyMessage.visibility = View.GONE
                binding.recyclerViewSearch.visibility = View.GONE
                binding.searchProgressBar.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
        searchViewModel.showError.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                binding.viewEmpty.groupEmptyMessage.visibility = View.GONE
                binding.viewError.groupErrorMessage.visibility = if (it) View.VISIBLE else View.GONE
                binding.viewError.btnRetry.setOnClickListener {
                    searchViewModel.onClickRetryButton()
                }
            }
        })
        searchViewModel.showEmpty.observe(viewLifecycleOwner, Observer { event ->
            event.getContentIfNotHandled()?.let {
                binding.viewEmpty.groupEmptyMessage.visibility = if (it) View.VISIBLE else View.GONE
            }
        })
    }

    private fun setupListeners() {
        binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String): Boolean {
                hideKeyboard()
                searchViewModel.getProductsByQuery(query)
                return true
            }

            override fun onQueryTextChange(newText: String): Boolean {
                return false
            }
        })
    }

    fun hideKeyboard() {
        val inputMethodManager: InputMethodManager =
            activity?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
        inputMethodManager.hideSoftInputFromWindow(activity?.currentFocus?.windowToken, 0)
    }


    companion object {
        @JvmStatic
        fun newInstance() = SearchFragment()
    }

    override fun onProductClickListener(id: String) {
        val fragment = ProductFragment.newInstance(id)
        activity?.let {
            it.supportFragmentManager.beginTransaction()
                .replace(R.id.main_container, fragment)
                .addToBackStack(fragment.toString())
                .commitAllowingStateLoss()
        }
    }
}