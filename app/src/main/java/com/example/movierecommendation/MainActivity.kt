package com.example.movierecommendation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.RecyclerView
import com.example.movierecommendation.adapter.ItemAdapter
import com.example.movierecommendation.data.Datasource

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
//        val check : TextView = findViewById(R.id.textView)
//        check.text = Datasource().loadAffirmations().size.toString()
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val myDataset = Datasource().loadMovieCards()
        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
        recycleView.adapter = ItemAdapter(this, myDataset)
    }
}