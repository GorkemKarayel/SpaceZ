package com.app.spacez.ui.rocketdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.app.spacez.R
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.ResultHolder.Error
import com.app.spacez.data.ResultHolder.Loading
import com.app.spacez.data.ResultHolder.Success
import com.app.spacez.data.Rocket
import com.app.spacez.databinding.FragmentRocketDetailBinding
import com.bumptech.glide.Glide

class RocketDetailFragment : Fragment() {

    private var _binding: FragmentRocketDetailBinding? = null
    private val binding get() = _binding!!

    private val viewModel: RocketDetailViewModel by lazy {
        ViewModelProvider(requireActivity()).get(RocketDetailViewModel::class.java)
    }
    private val rocketId by lazy { requireArguments().getString(ARG_ROCKET_ID) }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentRocketDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        with(viewModel) {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            getRocketDetail(rocketId)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observeUiState(resultHolder: ResultHolder<Rocket>) = when (resultHolder) {
        is Loading -> binding.loadingBar.visibility = View.VISIBLE
        is Success -> {
            binding.loadingBar.visibility = View.GONE
            renderUi(resultHolder.data)
        }
        is Error -> {
            binding.loadingBar.visibility = View.GONE
            Toast.makeText(requireActivity(), resultHolder.error, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun renderUi(data: Rocket?) = with(binding) {
        if (data == null) return

        Glide.with(this@RocketDetailFragment).load(data.images?.first()).into(rocketImageView)
        rocketNameTextView.text = data.rocketName
        rocketDescriptionTextView.text = data.description
        rocketCompanyTextView.text = data.company
        rocketHeightTextView.text = getString(R.string.rocket_height, data.height.meters)
        rocketMassTextView.text = getString(R.string.rocket_mass, data.mass.kg)
    }

    companion object RocketDetailFragmentFactory {
        private const val ARG_ROCKET_ID = "argRocketId"
        fun newInstance(rocketId: String?) = RocketDetailFragment().apply {
            arguments = bundleOf(ARG_ROCKET_ID to rocketId)
        }
    }
}
