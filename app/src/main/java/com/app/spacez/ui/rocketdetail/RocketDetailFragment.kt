package com.app.spacez.ui.rocketdetail

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import com.app.spacez.R
import com.app.spacez.data.ResultHolder
import com.app.spacez.data.ResultHolder.Error
import com.app.spacez.data.ResultHolder.Loading
import com.app.spacez.data.ResultHolder.Success
import com.app.spacez.data.Rocket
import com.bumptech.glide.Glide

class RocketDetailFragment : Fragment() {

    private val viewModel: RocketDetailViewModel by viewModels()

    private val rocketId by lazy { requireArguments().getString(ARG_ROCKET_ID) }

    private lateinit var rocketImageView: ImageView
    private lateinit var loadingBar: ProgressBar
    private lateinit var rocketNameTextView: TextView
    private lateinit var rocketDescriptionTextView: TextView
    private lateinit var rocketCompanyTextView: TextView
    private lateinit var rocketHeightTextView: TextView
    private lateinit var rocketMassTextView: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_rocket_detail, container, false)
        rocketImageView = view.findViewById(R.id.rocketImageView)
        loadingBar = view.findViewById(R.id.loadingBar)
        rocketNameTextView = view.findViewById(R.id.rocketNameTextView)
        rocketDescriptionTextView = view.findViewById(R.id.rocketDescriptionTextView)
        rocketCompanyTextView = view.findViewById(R.id.rocketCompanyTextView)
        rocketHeightTextView = view.findViewById(R.id.rocketHeightTextView)
        rocketMassTextView = view.findViewById(R.id.rocketMassTextView)
        return view
    }

    override fun onStart() {
        super.onStart()
        with(viewModel) {
            uiState.observe(viewLifecycleOwner, ::observeUiState)
            getRocketDetail(rocketId)
        }
    }

    private fun observeUiState(resultHolder: ResultHolder<Rocket>) = when (resultHolder) {
        is Loading -> loadingBar.visibility = View.VISIBLE
        is Success -> {
            loadingBar.visibility = View.GONE
            renderUi(resultHolder.data)
        }
        is Error -> {
            loadingBar.visibility = View.GONE
            Toast.makeText(requireActivity(), resultHolder.error, Toast.LENGTH_LONG).show()
        }
    }

    @SuppressLint("StringFormatMatches")
    private fun renderUi(data: Rocket?) {
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
