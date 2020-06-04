package com.example.anthonyodu.screens.filter

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.example.anthonyodu.MyApplication
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FilterListItemBinding
import com.example.anthonyodu.databinding.FragmentFilterBinding
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class FilterFragment : Fragment() {

    lateinit var binding: FragmentFilterBinding
    @Inject
    lateinit var filterViewModel: FilterViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        (requireActivity().application as MyApplication).getSharedComponent().inject(this)
        binding = DataBindingUtil.inflate(inflater,R.layout.fragment_filter, container, false)

        filterViewModel.filterList.observeForever {
            Log.e("All List", it.toString())
        }

        return binding.root
    }

}
