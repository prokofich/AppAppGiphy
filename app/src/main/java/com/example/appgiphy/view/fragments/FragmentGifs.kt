package com.example.appgiphy.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.appgiphy.constant.MAIN
import com.example.appgiphy.R
import com.example.appgiphy.adapter.GifAdapter
import com.example.appgiphy.databinding.FragmentGifsBinding
import com.example.appgiphy.model.Data
import com.example.appgiphy.viewmodel.GifViewModel

class FragmentGifs : Fragment() {

    private var binding: FragmentGifsBinding? = null
    private var recyclerView: RecyclerView? = null
    private var adapter: GifAdapter? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentGifsBinding.inflate(inflater,container,false)
        return binding?.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewmodel = ViewModelProvider(this)[GifViewModel::class.java]

        recyclerView = binding?.idRv
        adapter = GifAdapter(requireContext())
        recyclerView?.adapter = adapter

        binding?.idButton?.setOnClickListener {
            if (binding?.idEt?.text?.isNotEmpty() == true) {

                viewmodel.getGifs(binding?.idEt?.text.toString())
                binding?.idEt?.setText("")

            }else{

                Toast.makeText(requireContext(),"введите запрос в поле!",Toast.LENGTH_SHORT).show()
                binding?.idEt?.setText("")

            }
        }

        viewmodel.gif.observe(viewLifecycleOwner) { list ->
            list.body().let { adapter?.setList(it?.data) }
        }

    }

    companion object{
        fun clickGif(data: Data){
            val bundle = Bundle()
            bundle.putParcelable("gif",data)
            MAIN?.navController?.navigate(R.id.action_fragmentGifs_to_fragmentGifDetails,bundle)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }

}