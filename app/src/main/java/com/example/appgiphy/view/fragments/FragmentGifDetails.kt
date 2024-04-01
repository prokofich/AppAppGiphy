package com.example.appgiphy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.appgiphy.constant.MAIN
import com.example.appgiphy.R
import com.example.appgiphy.databinding.FragmentGifDetailsBinding
import com.example.appgiphy.model.Data

class FragmentGifDetails : Fragment() {

    private var binding:FragmentGifDetailsBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGifDetailsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val data:Data? = arguments?.getParcelable("gif")

        binding?.idTitleDetails?.text = data?.title
        binding?.idUsernameDetails?.text = data?.username
        binding?.idDateDetail?.text = data?.import_datetime

        Glide.with(requireContext())
            .load(data?.images?.original?.url)
            .into(binding?.idImageviewDetails!!)

        Glide.with(requireContext())
            .load(data?.user?.avatar_url)
            .into(binding?.idImageviewUserDetails!!)

        binding?.idButtonDetail?.setOnClickListener {
            MAIN?.navController?.navigate(R.id.action_fragmentGifDetails_to_fragmentGifs)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}