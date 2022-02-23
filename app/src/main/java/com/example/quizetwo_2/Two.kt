package com.example.quizetwo_2

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.example.quizetwo_2.databinding.TwoBinding
import com.squareup.picasso.Picasso
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import searchimage.SearchImage

class Two : Fragment(R.layout.two) {
    private lateinit var binding: TwoBinding

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DataBindingUtil.bind(view)!!
        binding.btn.setOnClickListener {
            fetchJson()
        }

    }

    private fun fetchJson() {
        NetworkManager.service.searchImage(
            "1c04e05bce6e626247758d120b372a73",
            "flickr.photos.search",
            binding.ed.text.toString(),
            "url_s",
            "json",
            "1"
        ).enqueue(object : Callback<SearchImage> {
            override fun onResponse(call: Call<SearchImage>, response: Response<SearchImage>) {
                Log.d("Tag", response.body().toString())
                Log.d("Tag", "success")

                val url = response.body()?.photos?.photo?.get(0)?.url_s
                Picasso.with(requireContext())
                    .load(url)
                    .into(binding.Img02)
            }

            override fun onFailure(call: Call<SearchImage>, t: Throwable) {
                Log.d("Tag", t.message.toString())
                Log.d("Tag", "Failure")
            }
        })
    }

}