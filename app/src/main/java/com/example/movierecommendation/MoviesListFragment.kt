package com.example.movierecommendation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.movierecommendation.adapter.ItemAdapter
import com.example.movierecommendation.adapter.MovieAdapter
import com.example.movierecommendation.databinding.FragmentMovieListBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */

class MoviesListFragment : Fragment() {

    private val moviesViewModel: MoviesViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return FragmentMovieListBinding.inflate(inflater, container, false).root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val binding = FragmentMovieListBinding.bind(view)
        val slidingPaneLayout = binding.slidingPaneLayout
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            SportsListOnBackPressedCallback(slidingPaneLayout))

        // Initialize the adapter and set it to the RecyclerView.
        val adapter = MovieAdapter {
            // Update the user selected sport as the current sport in the shared viewmodel
            // This will automatically update the dual pane content
            moviesViewModel.updateCurrentMovie(it)
            // Navigate to the details screen
            val action = MoviesListFragmentDirections.actionMoviesListFragmentToDescriptionDetailsFragment()
            this.findNavController().navigate(action)
            binding.slidingPaneLayout.openPane()
        }
        binding.recyclerView.adapter = adapter
        adapter.submitList(moviesViewModel.moviesData)
    }

}

class SportsListOnBackPressedCallback (private val slidingPaneLayout : SlidingPaneLayout)
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
