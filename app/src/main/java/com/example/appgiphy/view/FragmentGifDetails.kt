package com.example.appgiphy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.example.appgiphy.MAIN
import com.example.appgiphy.R
import com.example.appgiphy.model.Data
import kotlinx.android.synthetic.main.fragment_gif_details.*

class FragmentGifDetails : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gif_details, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var data:Data? = arguments?.getParcelable("gif")

        id_title_details.text = data!!.title
        id_username_details.text = data!!.username
        id_date_detail.text = data!!.import_datetime

        Glide.with(requireContext())
            .load(data.images.original.url)
            .into(id_imageview_details)

        Glide.with(requireContext())
            .load(data.user.avatar_url)
            .into(id_imageview_user_details)

        id_button_detail.setOnClickListener {
            MAIN.navController.navigate(R.id.action_fragmentGifDetails_to_fragmentGifs)
        }

    }

}