package com.example.movierecommendation

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecommendation.adapter.ItemAdapter
import com.example.movierecommendation.data.Datasource


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadMovieCards()
        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.adapter = ItemAdapter(this, myDataset)
    }
    fun onMyButtonClick(view: View?) {
        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show()
    }
}