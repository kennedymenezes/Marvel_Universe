package com.kennedymenezes.marveluniverse.dashboard.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.kennedymenezes.marveluniverse.R
import com.kennedymenezes.marveluniverse.dashboard.ui.adapter.CharactersAdapter
import com.kennedymenezes.marveluniverse.dashboard.ui.viewModel.DashboardViewModel
import com.kennedymenezes.marveluniverse.databinding.DashboardFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.dashboard_fragment) {

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var binding: DashboardFragmentBinding
    private val adapter = CharactersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DashboardFragmentBinding.bind(view)
        setupRecyclerView()
        setupObservers()
        viewModel.getCharacters()
    }

    private fun setupObservers(){
        viewModel.charactersList.observe(viewLifecycleOwner) {
            adapter.loadCharacters(it.data.heroesResult)
        }
    }

    private fun setupRecyclerView(){
        binding.rvCharactersList.layoutManager = GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvCharactersList.adapter = adapter
    }
}