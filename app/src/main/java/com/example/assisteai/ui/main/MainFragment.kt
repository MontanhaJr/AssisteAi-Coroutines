package com.example.assisteai.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.assisteai.R
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(
            this,
            MainViewModel.MainViewModelFactory(MainRepository())
        ).get(MainViewModel::class.java)

        viewModel.filmesLiveData.observe(viewLifecycleOwner) {
            nameLabel.text = it[1].nome
        }

//        viewModel.getFilmes()
        viewModel.getFilmesCoroutines()
    }

}