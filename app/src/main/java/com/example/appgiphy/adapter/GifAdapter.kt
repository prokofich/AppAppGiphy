package com.example.appgiphy.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.appgiphy.R
import com.example.appgiphy.model.Data
import com.example.appgiphy.view.fragments.FragmentGifs
import kotlinx.android.synthetic.main.gif_item.view.*

class GifAdapter(private val context: Context):RecyclerView.Adapter<GifAdapter.GifViewHolder>() {

    private var gifDataList = emptyList<Data>()

    class GifViewHolder(view: View): RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GifViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.gif_item,parent,false)
        return GifViewHolder(view)
    }

    override fun onBindViewHolder(holder: GifViewHolder, position: Int) {

        val imageViewGif = holder.itemView.findViewById<ImageView>(R.id.id_imageview_gif)

        Glide.with(context)
            .load(gifDataList[position].images.original.url)
            .into(imageViewGif)

    }

    override fun getItemCount(): Int {
        return gifDataList.size
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setList(list:List<Data>?){
        if(list!=null){
            gifDataList = list
            notifyDataSetChanged()
        }
    }

    override fun onViewAttachedToWindow(holder: GifViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            FragmentGifs.clickGif(gifDataList[holder.adapterPosition])
        }
    }


}