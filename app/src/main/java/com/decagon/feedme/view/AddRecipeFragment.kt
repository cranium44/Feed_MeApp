package com.decagon.feedme.view

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.decagon.feedme.R
import com.decagon.feedme.viewmodels.AddRecipeViewModel

class AddRecipeFragment : Fragment() {

    companion object {
        fun newInstance() = AddRecipeFragment()
    }

    private lateinit var viewModel: AddRecipeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_recipe, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(AddRecipeViewModel::class.java)
        // TODO: Use the ViewModel
    }

}
