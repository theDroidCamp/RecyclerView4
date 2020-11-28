package com.example.recyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        theAPI().getApi().enqueue(object: Callback<List<Movies>> {
            override fun onFailure(call: Call<List<Movies>>, t: Throwable) {
                Toast.makeText(applicationContext,t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse(call: Call<List<Movies>>, response: Response<List<Movies>>) {
                val screen = response.body()
                screen?.let{
                    showMovies(it)
                }

            }

        })
    }
      private fun showMovies(movies: List<Movies>) {
          recycler_view.layoutManager = LinearLayoutManager(this)
          recycler_view.adapter= MoviesRecyclerAdapter(movies)
    }
}