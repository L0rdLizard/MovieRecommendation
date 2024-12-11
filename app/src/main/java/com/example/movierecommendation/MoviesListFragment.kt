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
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.slidingpanelayout.widget.SlidingPaneLayout
import com.example.movierecommendation.adapter.MovieAdapter
import com.example.movierecommendation.databinding.FragmentMovieListBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.launch


class MoviesListFragment : Fragment() {
    private val moviesViewModel: MoviesViewModel by activityViewModels()
//    private lateinit var adapter: MovieAdapter
    private var addButton: Button? = null
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
//        val moviesViewModel: MoviesViewModel by activityViewModels()
//        println("moviesViewModel.moviesData.size = " + moviesViewModel.moviesData.size + "\n");
        println("moviesViewModel.moviesData.size = " + moviesViewModel.moviesData.value?.size + "\n");
        super.onViewCreated(view, savedInstanceState)

        addButton = view.findViewById(R.id.addButton)

        val binding = FragmentMovieListBinding.bind(view)
        val recyclerViewVal = binding.recyclerView

        val slidingPaneLayout = binding.slidingPaneLayout
        slidingPaneLayout.lockMode = SlidingPaneLayout.LOCK_MODE_LOCKED
        requireActivity().onBackPressedDispatcher.addCallback(viewLifecycleOwner,
            MovieListOnBackPressedCallback(slidingPaneLayout))

        val adapter = MovieAdapter {
            println("!!!!!!!!!!!!!!!!!!create adapter in MovieListFragment")

            moviesViewModel.updateCurrentMovie(it)

            val action = MoviesListFragmentDirections.actionMoviesListFragmentToDescriptionDetailsFragment()
            this.findNavController().navigate(action)
            binding.slidingPaneLayout.openPane()
        }

        moviesViewModel.moviesData.observe(viewLifecycleOwner, Observer { movies ->
            adapter.submitList(movies ?: listOf())
        })

        binding.recyclerView.adapter = adapter
        recyclerViewVal.adapter?.notifyDataSetChanged()
//        adapter.submitList(moviesViewModel.moviesData)
        adapter.submitList(moviesViewModel.moviesData.value ?: listOf())


        addButton?.setOnClickListener {
            println("Button clicked!")
            Toast.makeText(requireActivity(), "Зачем вы нажали?", Toast.LENGTH_SHORT).show()
        }

        val includedView = view.findViewById<View>(R.id.addButton)
//        val includedButton = includedView.findViewById<Button>(R.id.button_included)

        includedView?.setOnClickListener {
            println("Button from included layout clicked!")
            Toast.makeText(requireContext(), "Кнопка из include нажата!", Toast.LENGTH_SHORT).show()
        }


//        addButton?.setOnClickListener(object : View.OnClickListener {
//            override fun onClick(view: View?) {
//                println("ggggggggggggggggggggggggggggggg")
//            }
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
