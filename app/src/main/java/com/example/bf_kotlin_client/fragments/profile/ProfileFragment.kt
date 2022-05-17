package com.example.bf_kotlin_client.fragments.profile

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.bf_kotlin_client.databinding.FragmentProfileBinding
import com.example.bf_kotlin_client.viewmodels.profile.ProfileViewModel

class ProfileFragment : Fragment() {
    lateinit var binding: FragmentProfileBinding
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        binding = FragmentProfileBinding.inflate(layoutInflater)

        binding.viewModel = ProfileViewModel()

        return binding.root
    }

    override fun onHiddenChanged(hidden: Boolean) {
        super.onHiddenChanged(hidden)
        if (!hidden)
            binding.viewModel?.onFragmentShow()
    }
}