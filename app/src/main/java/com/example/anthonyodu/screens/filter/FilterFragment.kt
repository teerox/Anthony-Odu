package com.example.anthonyodu.screens.filter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.anthonyodu.MyApplication
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FilterListItemBinding
import com.example.anthonyodu.databinding.FragmentFilterBinding
import com.example.anthonyodu.model.FilterArray
import kotlinx.android.synthetic.main.filter_list_item.*
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    lateinit var binding: FragmentFilterBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: FilterListAdapter
    @Inject
    lateinit var filterViewModel: FilterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity().application as MyApplication).getSharedComponent().inject(this)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_filter, container, false)

        recyclerView = binding.allFilter

        filterViewModel.filterList.observeForever {
            filterArray ->
            adapter = FilterListAdapter(filterArray){
                filter ->
                val action = FilterFragmentDirections.actionFilterFragmentToAllFilter(filter)
            }
            recyclerView.adapter = adapter
            binding.progressbar.visibility = View.GONE
        }

        return binding.root
    }

}
