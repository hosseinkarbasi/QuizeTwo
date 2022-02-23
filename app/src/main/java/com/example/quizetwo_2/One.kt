package com.example.quizetwo_2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.quizetwo_2.databinding.OneBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class One : Fragment(R.layout.one) {
    private lateinit var binding: OneBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!

        binding.recyclerViewMain.layoutManager = GridLayoutManager(view.context, 3)
        fetchJson()
    }

    private fun fetchJson() {
        NetworkManager.service.getImage(
            "1c04e05bce6e626247758d120b372a73",
            "flickr.photos.getRecent",
            "url_s",
            "json",
            "1",
            "100",
            "1"
        ).enqueue(object : Callback<FlickrResult> {
            override fun onResponse(call: Call<FlickrResult>, response: Response<FlickrResult>) {
                Log.d("Tag", response.body().toString())
                Log.d("Tag", "success")
                val recyclerView = view?.findViewById<RecyclerView>(R.id.recyclerView_main)
                recyclerView?.adapter = RecyclerAdapter(response.body()!!)
            }

            override fun onFailure(call: Call<FlickrResult>, t: Throwable) {
                Log.d("Tag", t.message.toString())
                Log.d("Tag", "Failure")
            }
        })
    }

}