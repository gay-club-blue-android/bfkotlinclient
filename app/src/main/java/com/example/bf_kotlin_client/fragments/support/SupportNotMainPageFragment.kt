package com.example.bf_kotlin_client.fragments.support

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentSupportNotMainPageBinding
import com.example.bf_kotlin_client.viewmodels.support.SupportNotMainPageViewModel

class SupportNotMainPageFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        val binding =FragmentSupportNotMainPageBinding.inflate(layoutInflater)

        val supportMainPageViewModel = SupportNotMainPageViewModel()
        binding.viewModel = supportMainPageViewModel

        //var view = inflater.inflate(R.layout.fragment_products_categories, container, false)

        return binding.root
    }
}