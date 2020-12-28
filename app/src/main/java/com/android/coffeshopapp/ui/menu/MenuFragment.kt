package com.android.coffeshopapp.ui.menu

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.android.coffeshopapp.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_menu.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@AndroidEntryPoint
class MenuFragment : Fragment(R.layout.fragment_menu){

    @Inject lateinit var menuService: MenuService
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        rvMenu.setOnClickListener{
            findNavController().navigate(R.id.cartFragment)
        }
        GlobalScope.launch {
            menuService.getMenuItems()
        }

        val adapter = MenuAdapter()
        adapter.items = listOf(
            NotificationItem(
                "Сэндвичи",
                "Очень вкусные сэндвичи",
                "https://images.unsplash.com/photo-1540713434306-58505cf1b6fc?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                { findNavController().navigate(R.id.categoryDetailFragment) }
            ),
            NotificationItem(
                "Напитки",
                "Освежающие напитки",
                "https://images.unsplash.com/photo-1551870573-6f5e93e660fd?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1350&q=80",
                {}
            ),
            NotificationItem(
                "Кофе",
                "Бодрящий кофе",
                "https://images.unsplash.com/photo-1511920170033-f8396924c348?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=634&q=80",
                {}
            ),
            NotificationItem(
                "Салаты",
                "Очень вкусные салаты",
                "https://images.unsplash.com/photo-1551248429-40975aa4de74?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1190&q=80",
                {}
            ),
            NotificationItem(
                "Десерты",
                "",
                "https://images.unsplash.com/photo-1530016555861-3d1f3f5ca94b?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=1347&q=80",
                {}
            ),
            NotificationItem(
                "Горячие блюда",
                "",
                "https://images.unsplash.com/photo-1576107290640-a68caf8256f1?ixid=MXwxMjA3fDB8MHxwaG90by1wYWdlfHx8fGVufDB8fHw%3D&ixlib=rb-1.2.1&auto=format&fit=crop&w=675&q=80",
                {}
            )
        )
        rvMenu.adapter = adapter
    }
}