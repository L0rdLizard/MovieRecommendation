package com.example.movierecommendation


import android.R.attr.button
import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.movierecommendation.adapter.MovieAdapter
import com.example.movierecommendation.databinding.FragmentMovieListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class MoviesListFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()
//    private lateinit var adapter: MovieAdapter
//    private val addButton : Button? = view?.findViewById(R.id.addButton)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMovieListBinding.inflate(inflater, container, false).root
    }

    @SuppressLint("NotifyDataSetChanged")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieListBinding.bind(view)
        val recyclerViewVal = binding.recyclerView
        val slidingPaneLayout = binding.slidingPaneLayout
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            MovieListOnBackPressedCallback(slidingPaneLayout))
        // Initialize the adapter and set it to the RecyclerView.
        val adapter = MovieAdapter {
            println("!!!!!!!!!!!!!!!!!!create adapter int MovieListFragment")
            // Update the user selected sport as the current sport in the shared viewmodel
            // This will automatically update the dual pane content
            moviesViewModel.updateCurrentMovie(it)
            // Navigate to the details screen

            val action = MoviesListFragmentDirections.actionMoviesListFragmentToDescriptionDetailsFragment()
            this.findNavController().navigate(action)
            binding.slidingPaneLayout.openPane()
        }
        binding.recyclerView.adapter = adapter
        recyclerViewVal.adapter?.notifyDataSetChanged()
        adapter.submitList(moviesViewModel.moviesData)

//        addButton = view.findViewById<Button>(R.id.addButton)
//        addButton?.setOnClickListener{
//            println("ggggggggggggggggggggggggggggggg")
//        }

//        addButton?.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View?) {
//                println("ggggggggggggggggggggggggggggggg")
//            }
//
//        })

    }

    @SuppressLint("NotifyDataSetChanged")
    fun refreshMovieList (recyclerView: RecyclerView?){
        CoroutineScope(Dispatchers.Main).launch {
            recyclerView?.adapter?.notifyDataSetChanged()
        }
    }
}
class MovieListOnBackPressedCallback (private val slidingPaneLayout : SlidingPaneLayout)
    :OnBackPressedCallback(slidingPaneLayout.isSlideable && slidingPaneLayout.isOpen),
    SlidingPaneLayout.PanelSlideListener{
    init{
        slidingPaneLayout.addPanelSlideListener(this)
    }

    override fun handleOnBackPressed() {
        slidingPaneLayout.closePane()
    }

    override fun onPanelSlide(panel: View, slideOffset: Float) {

    }

    override fun onPanelOpened(panel: View) {
        isEnabled = true
    }

    override fun onPanelClosed(panel: View) {
        isEnabled = false
    }

}
