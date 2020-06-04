package com.example.anthonyodu.screens.filter

import android.Manifest
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.ListAdapter
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.downloader.PRDownloader
import com.downloader.PRDownloaderConfig
import com.example.anthonyodu.MyApplication
import com.example.anthonyodu.R
import com.example.anthonyodu.databinding.FilterListItemBinding
import com.example.anthonyodu.databinding.FragmentFilterBinding
import com.example.anthonyodu.model.FilterArray
import com.example.anthonyodu.utils.Utility.MY_PERMISSIONS_REQUEST_WRITE_STORAGE
import com.google.android.material.snackbar.Snackbar
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


        //Check for Permission
        checkPermissionAndStart()

        //Initialize Download
        val config = PRDownloaderConfig.newBuilder().setDatabaseEnabled(true).build()
        PRDownloader.initialize(context, config)


        recyclerView = binding.allFilter

        filterViewModel.filterList.observeForever {
            filterArray ->
            adapter = FilterListAdapter(filterArray){
                filter ->
                val action = FilterFragmentDirections.actionFilterFragmentToAllFilter(filter)
                findNavController().navigate(action)
            }
            recyclerView.adapter = adapter
            binding.progressbar.visibility = View.GONE
        }

        filterViewModel.startMyDownload.observeForever {
            if (!it) {
                filterViewModel.showDialog()
                Snackbar.make(binding.root,"Downloaded Started", Snackbar.LENGTH_LONG).show()

            }
        }
        filterViewModel.completeDownload.observe(viewLifecycleOwner, Observer { isCompleted ->
            isCompleted?.let { result ->
                if (result) {
                    filterViewModel.dismiss()
                    Snackbar.make(binding.root,"Downloaded Completed", Snackbar.LENGTH_LONG).show()
                }
            }
        })

        return binding.root
    }

    //METHOD TO CHECK PERMISSION
    private fun checkPermissionAndStart() {
        if (ContextCompat.checkSelfPermission(
                requireContext(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            != PackageManager.PERMISSION_GRANTED
        ) {
            promptDialogPermission()

        } else {
            filterViewModel.grantAccess.value = true
        }
    }



    private fun promptDialogPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(
                arrayOf(Manifest.permission.WRITE_EXTERNAL_STORAGE),
                MY_PERMISSIONS_REQUEST_WRITE_STORAGE
            )
        }
    }


    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        when (requestCode) {
            MY_PERMISSIONS_REQUEST_WRITE_STORAGE -> {
                if ((grantResults.isNotEmpty() && permissions[0] == Manifest.permission.WRITE_EXTERNAL_STORAGE)) {
                    if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                        filterViewModel.checkDataExist()
                        filterViewModel.grantAccess.value = true
                    }
                } else {
                    promptDialogPermission()
                }

            }

        }
    }


}
