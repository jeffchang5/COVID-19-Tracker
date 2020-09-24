package io.jeffchang.covidtracking.ui.dailycase.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import io.jeffchang.DailyCaselist.R
import io.jeffchang.DailyCaselist.databinding.FragmentDailyCaseBinding
import io.jeffchang.covidtracking.ui.dailycase.inject
import io.jeffchang.covidtracking.ui.dailycase.view.adapter.DailyCaseListAdapter
import io.jeffchang.covidtracking.ui.dailycase.viewmodel.DailyCaseViewModel
import io.jeffchang.core.data.ViewState
import javax.inject.Inject

class DailyCaseFragment : Fragment() {

    private lateinit var binding: FragmentDailyCaseBinding

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    // Kotlin delegate to lazily create viewmodels.
    private val dailyCaseViewModel by viewModels<DailyCaseViewModel> {
        viewModelFactory
    }

    private val dailyCaseListAdapter by lazy {
        DailyCaseListAdapter()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        inject()
        binding = FragmentDailyCaseBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            DailyCaseListRecyclerView.adapter = dailyCaseListAdapter
            DailyCaseListRecyclerView.layoutManager = LinearLayoutManager(context)
            swipeRefreshLayout.setOnRefreshListener {
                dailyCaseViewModel.getDailyCasees()
            }
        }
        subscribeUI()
    }

    private fun subscribeUI() {
        binding.apply {
            // Hides main UI with list. Shows Progress Bar.
            fun hide() {
                progressBar.isVisible = true
                DailyCaseListRecyclerView.isVisible = false
            }

            // Shows main UI with list
            fun show() {
                progressBar.isVisible = false
                DailyCaseListRecyclerView.isVisible = true
            }

            dailyCaseViewModel.viewState().observe(viewLifecycleOwner, Observer {
                binding.swipeRefreshLayout.isRefreshing = false
                when (it) {
                    is ViewState.Success -> {
                        dailyCaseListAdapter.submitList(it.data)
                        show()
                    }
                    is ViewState.Empty -> {
                        Toast.makeText(context, R.string.empty_list, Toast.LENGTH_LONG).show()
                        show()
                    }
                    is ViewState.Error -> {
                        Toast.makeText(context, R.string.network_error, Toast.LENGTH_LONG).show()
                        show()
                    }
                    is ViewState.Loading -> {
                        progressBar.isVisible = true
                        DailyCaseListRecyclerView.isVisible = false
                        hide()
                    }
                }
            })
        }
    }
}
