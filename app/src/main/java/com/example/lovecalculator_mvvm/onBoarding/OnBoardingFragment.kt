package com.example.lovecalculator_mvvm.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.lovecalculator_mvvm.data.local.db.Pref
import com.example.lovecalculator_mvvm.R
import com.example.lovecalculator_mvvm.databinding.FragmentOnBoardingBinding
import com.example.lovecalculator_mvvm.onboarding.adapter.OnBoardingAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardingBinding
    private lateinit var adapter: OnBoardingAdapter

    @Inject
    lateinit var pref: Pref

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentOnBoardingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = OnBoardingAdapter(this::onClick)
        binding.viewPager.adapter = adapter

        binding.indicator.setViewPager(binding.viewPager)
        adapter.registerAdapterDataObserver(binding.indicator.adapterDataObserver)

        if (pref.isUserSeen()){
            findNavController().navigate(R.id.firstFragment)
        }
    }

    private fun onClick(){
        pref.isUserSeenOnBoarding()
        findNavController().navigate(R.id.onBoardingFragment)
    }
}
