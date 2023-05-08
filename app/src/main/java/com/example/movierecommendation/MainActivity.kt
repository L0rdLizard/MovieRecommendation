package com.example.movierecommendation

//import android.os.Bundle
//import android.view.View
//import android.widget.Toast
//import androidx.appcompat.app.AppCompatActivity
//import androidx.navigation.ui.AppBarConfiguration
//import androidx.recyclerview.widget.RecyclerView
//import com.example.movierecommendation.adapter.ItemAdapter
//import com.example.movierecommendation.data.Datasource

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.movierecommendation.data.Datasource
import com.example.movierecommendation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_main)
//        val myDataset = Datasource().loadMovieCards()
//        val recycleView = findViewById<RecyclerView>(R.id.recycleView)
//        recycleView.adapter = ItemAdapter(this, myDataset)
//    }
//    fun onMyButtonClick(view: View?) {
//        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show()
//    }

    private lateinit var appBarConfiguration: AppBarConfiguration
    val movieList = Datasource()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment
        val navController = navHostFragment.navController
        appBarConfiguration = AppBarConfiguration(navController.graph)
        binding.toolbar.setupWithNavController(navController, appBarConfiguration)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
//    fun onMyButtonClick(view: View?) {
//        Toast.makeText(this, "Зачем вы нажали?", Toast.LENGTH_SHORT).show()
//        CoroutineScope(Dispatchers.IO).launch {
//            movieList.addNewMovie(301)
//        }
//        CoroutineScope(Dispatchers.Main).launch {
//            println(objKinopoiskAPI.retrofitService.getMovie("301"))
//        }

//    }
}