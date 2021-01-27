package com.app.spacez.ui.rockets

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.app.spacez.R
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.ResultHolder.Error
import com.app.spacez.data.ResultHolder.Loading
import com.app.spacez.data.ResultHolder.Success
import com.app.spacez.data.Rocket
import com.app.spacez.ui.adapter.RocketAdapter
import com.app.spacez.ui.adapter.RocketAdapter.RocketDiff
import com.app.spacez.ui.rocketdetail.RocketDetailFragment.RocketDetailFragmentFactory
import com.app.spacez.utils.addFragment

class RocketsFragment : Fragment() {

    private lateinit var rocketAdapter: RocketAdapter

    private val viewModel: RocketsViewModel by viewModels()

    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingBar: ProgressBar

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rockets, container, false)
        recyclerView = view.findViewById(R.id.rocketsRecyclerView)
        loadingBar = view.findViewById(R.id.loadingBar)

        rocketAdapter = RocketAdapter(RocketDiff()) { rocket ->
            requireActivity().addFragment(RocketDetailFragmentFactory.newInstance(rocket.id))
        }

        recyclerView.apply {
            layoutManager = LinearLayoutManager(requireActivity(), RecyclerView.VERTICAL, false)
            adapter = rocketAdapter
        }
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.uiState.observe(viewLifecycleOwner, ::observeUiState)
    }

    private fun observeUiState(resultHolder: ResultHolder<List<Rocket>>) = when (resultHolder) {
        is Loading -> loadingBar.visibility = View.VISIBLE
        is Success -> {
            loadingBar.visibility = View.GONE
            rocketAdapter.submitList(resultHolder.data)
        }
        is Error -> {
            loadingBar.visibility = View.GONE
            Toast.makeText(requireActivity(), resultHolder.error, Toast.LENGTH_LONG).show()
        }
    }
}
