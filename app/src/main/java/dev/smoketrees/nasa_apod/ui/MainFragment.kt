package dev.smoketrees.nasa_apod.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import dagger.hilt.android.AndroidEntryPoint
import dev.smoketrees.nasa_apod.adapters.ApodItemAdapter
import dev.smoketrees.nasa_apod.databinding.MainFragmentBinding

@AndroidEntryPoint
class MainFragment : Fragment() {
    private var _binding: MainFragmentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = MainFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val apodAdapter = ApodItemAdapter(mutableListOf(), { pos ->
            findNavController().navigate(
                MainFragmentDirections.actionMainFragmentToDetailsFragment(
                    pos
                )
            )
        }, { pos ->
            val newItems = viewModel.apodItems.value!!
            newItems[pos].isFavorite = newItems[pos].isFavorite?.not() ?: true
            viewModel.apodItems.postValue(newItems)

        })

        viewModel.apodItems.observe(viewLifecycleOwner, {
            apodAdapter.updateItems(it)
        })

        val gridLayoutManager = GridLayoutManager(requireContext(), 2)
        binding.mainRecyclerView.apply {
            adapter = apodAdapter
            layoutManager = gridLayoutManager
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}