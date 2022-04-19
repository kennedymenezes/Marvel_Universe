package com.kennedymenezes.marveluniverse.dashboard.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kennedymenezes.marveluniverse.MainActivity
import com.kennedymenezes.marveluniverse.R
import com.kennedymenezes.marveluniverse.commons.utils.checkConnection
import com.kennedymenezes.marveluniverse.dashboard.ui.adapter.CharactersAdapter
import com.kennedymenezes.marveluniverse.dashboard.ui.viewModel.DashboardViewModel
import com.kennedymenezes.marveluniverse.databinding.DashboardFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DashboardFragment : Fragment(R.layout.dashboard_fragment) {

    private val viewModel: DashboardViewModel by viewModel()
    private lateinit var binding: DashboardFragmentBinding
    private val adapter = CharactersAdapter()
    private val highlightAdapter = CharactersAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = DashboardFragmentBinding.bind(view)
        setupRecyclerView()
        setupObservers()
        viewModel.getCharacters((requireActivity() as MainActivity).checkConnection())
        viewModel.getHighLightCharacters((requireActivity() as MainActivity).checkConnection())
    }

    private fun setupObservers() {
        viewModel.charactersList.observe(viewLifecycleOwner) {
            if (it.isEmpty()){
                Toast.makeText(requireContext(), "Go online to get heroes", Toast.LENGTH_SHORT).show()
            } else {
                adapter.loadCharacters(it)
            }
        }

        viewModel.charactersHighlightList.observe(viewLifecycleOwner) {
            highlightAdapter.loadCharacters(it.subList(0, 5))
        }
    }

    private fun setupRecyclerView() {
        binding.rvCharactersList.layoutManager =
            GridLayoutManager(requireContext(), 2, GridLayoutManager.VERTICAL, false)
        binding.rvCharactersList.adapter = adapter

        binding.rvCharactersList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)
                if (!recyclerView.canScrollVertically(1)){
                    viewModel.loadMoreCharacters((requireActivity() as MainActivity).checkConnection())
                }
            }
        })

        binding.rvHighlightList.adapter = highlightAdapter
        binding.rvHighlightList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
    }
}