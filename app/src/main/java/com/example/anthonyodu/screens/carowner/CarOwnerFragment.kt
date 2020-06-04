package com.example.anthonyodu.screens.carowner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.anthonyodu.MyApplication
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FragmentCarOwnerBinding
import com.example.anthonyodu.utils.Utility
import com.google.android.material.snackbar.Snackbar
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.io.File
import javax.inject.Inject

/**
 * A simple [Fragment] subclass.
 */
class CarOwnerFragment : Fragment() {

    lateinit var binding: FragmentCarOwnerBinding
    lateinit var recyclerView: RecyclerView
    lateinit var adapter: CarOwnerAdapter

    @Inject
    lateinit var carOwnerViewModel: CarOwnerViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        (requireActivity().application as MyApplication).getSharedComponent().inject(this)
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_car_owner,container,false)
        val absoluteFile by lazy {
            File(requireContext().filesDir, Utility.FOLDER.plus("/${Utility.CAR_OWNER_DATA}"))
        }
        val args = CarOwnerFragmentArgs.fromBundle(requireArguments()).Filterlist

        if (!absoluteFile.exists()){
            Snackbar.make(binding.root,"No List Available", Snackbar.LENGTH_LONG).show()
        }else {
            GlobalScope.launch(Dispatchers.Main) {
                val result = carOwnerViewModel.filterFile(args)
                adapter = CarOwnerAdapter(result)
                recyclerView.adapter = adapter
                binding.progressbar2.visibility = View.GONE
                val total = result.size
                Snackbar.make(binding.root,total.toString(), Snackbar.LENGTH_LONG).show()
            }
        }


        return binding.root
    }

}
