package com.app.spacez.ui.rockets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import com.app.spacez.SpaceApplication
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.ResultHolder.Error
import com.app.spacez.data.ResultHolder.Loading
import com.app.spacez.data.ResultHolder.Success
import com.app.spacez.data.Rocket
import com.app.spacez.databinding.FragmentRocketsBinding
import com.app.spacez.di.navigator.Screens
import com.app.spacez.di.navigator.SpaceNavigator
import com.app.spacez.ui.adapter.RocketAdapter
import com.app.spacez.ui.adapter.RocketAdapter.RocketDiff

class RocketsFragment : Fragment() {

    private var _binding: FragmentRocketsBinding? = null
    private val binding get() = _binding!!
    private lateinit var rocketAdapter: RocketAdapter

    private val navigator: SpaceNavigator by lazy {
        (requireActivity().applicationContext as SpaceApplication)
            .applicationComponent.provideNavigator(requireActivity())
    }

    private val viewModel: RocketsViewModel by lazy {
        ViewModelProvider(requireActivity()).get(RocketsViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketsBinding.inflate(inflater, container, false)
        rocketAdapter = RocketAdapter(RocketDiff()) { rocket ->
            navigator.navigateTo(Screens.RocketDetail(rocket.id))
        }
        binding.rocketsRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity())
            setHasFixedSize(true)
            adapter = rocketAdapter
        }
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        viewModel.uiState.observe(viewLifecycleOwner, ::observeUiState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUiState(resultHolder: ResultHolder<List<Rocket>>) = when (resultHolder) {
        is Loading -> binding.loadingBar.visibility = View.VISIBLE
        is Success -> {
            binding.loadingBar.visibility = View.GONE
            rocketAdapter.submitList(resultHolder.data)
        }
        is Error -> {
            binding.loadingBar.visibility = View.GONE
            Toast.makeText(requireActivity(), resultHolder.error, Toast.LENGTH_LONG).show()
        }
    }
}
