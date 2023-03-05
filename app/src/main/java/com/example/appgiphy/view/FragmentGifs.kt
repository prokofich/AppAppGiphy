package com.example.appgiphy.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appgiphy.MAIN
import com.example.appgiphy.R
import com.example.appgiphy.adapter.GifAdapter
import com.example.appgiphy.model.Data
import com.example.appgiphy.viewmodel.GifViewModel
import kotlinx.android.synthetic.main.fragment_gifs.*
import kotlin.properties.Delegates

class FragmentGifs : Fragment() {

    lateinit var recyclerView: RecyclerView
    lateinit var adapter: GifAdapter



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_gifs, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewmodel = ViewModelProvider(this).get(GifViewModel::class.java)
        recyclerView = id_rv
        adapter = GifAdapter(requireContext())
        recyclerView.adapter = adapter

        id_button.setOnClickListener {
            if (id_et.text != null) {
                viewmodel.get_gifs(id_et.text.toString())
                id_et.setText("")
                viewmodel.Gif.observe(viewLifecycleOwner) { list ->
                    list.body().let { adapter.setList(it!!.data) }
                }
            }else{
                Toast.makeText(requireContext(),"введите запрос в поле!",Toast.LENGTH_SHORT).show()
                id_et.setText("")
            }
        }

    }

    companion object{
        fun clickGif(data: Data){
            val bundle = Bundle()
            bundle.putParcelable("gif",data)
            MAIN.navController.navigate(R.id.action_fragmentGifs_to_fragmentGifDetails,bundle)
        }
    }

}