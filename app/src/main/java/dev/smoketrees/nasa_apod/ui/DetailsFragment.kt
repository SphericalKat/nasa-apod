package dev.smoketrees.nasa_apod.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.navArgs
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.HiltAndroidApp
import dev.smoketrees.nasa_apod.adapters.DetailsItemAdapter
import dev.smoketrees.nasa_apod.databinding.FragmentDetailsBinding

@AndroidEntryPoint
class DetailsFragment : Fragment() {
    private var _binding: FragmentDetailsBinding? = null
    private val binding get() = _binding!!
    private val args: DetailsFragmentArgs by navArgs()
    private val viewModel: MainViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentDetailsBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val detailsItemAdapter = DetailsItemAdapter(viewModel.apodItems)
        binding.pager.apply {
            adapter = detailsItemAdapter
            setCurrentItem(args.position, false)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}