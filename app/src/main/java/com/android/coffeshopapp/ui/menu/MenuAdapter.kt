package com.android.coffeshopapp.ui.menu

import android.view.View
import coil.load
import com.android.coffeshopapp.R
import com.tamerlan.nelsetteapp.global.DisplayAdapter
import com.tamerlan.nelsetteapp.global.DisplayItem
import com.tamerlan.nelsetteapp.global.DisplayViewHolder
import kotlinx.android.synthetic.main.item_food.view.*

class MenuAdapter : DisplayAdapter() {
    override fun createViewHolder(view: View, viewType: Int) = when (viewType) {
        R.layout.item_food -> NotificationItem.FoodViewHolder(
            view
        )
        else -> throw RuntimeException("Unknown type $viewType, you should modify createViewHolder")
    }
}

data class NotificationItem(
    val title: String,
    val content: String,
    val imageURL: String,
    val itemClick: () -> Unit
) : DisplayItem(R.layout.item_food) {

    class FoodViewHolder(
        itemView: View
    ) : DisplayViewHolder<NotificationItem>(itemView) {
        override fun bind(item: NotificationItem) {
            itemView.tvFoodTitle.text = item.title
            itemView.tvFoodContent.text = item.content
            itemView.ivFoodImage.load(item.imageURL)
            itemView.setOnClickListener {
                item.itemClick.invoke()
            }
        }
    }
}