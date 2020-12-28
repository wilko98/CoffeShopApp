package com.android.coffeshopapp.ui.menu.category

import android.os.Bundle
import android.view.View
import androidx.core.view.ViewCompat
import androidx.fragment.app.Fragment
import coil.load
import com.android.coffeshopapp.R
import kotlinx.android.synthetic.main.fragment_category.*

class CategoryFragment : Fragment(R.layout.fragment_category) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        iv_category.load("https://images.unsplash.com/photo-1540713434306-58505cf1b6fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80")
        ViewCompat.setTransitionName(iv_category,"categoryImage")
        super.onViewCreated(view, savedInstanceState)
    }
}