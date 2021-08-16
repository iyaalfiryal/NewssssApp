package com.iyaliyul.newssssapp.ui.home

import android.view.View
import com.iyaliyul.newssssapp.R
import com.iyaliyul.newssssapp.data.model.ArticleItem
import com.iyaliyul.newssssapp.databinding.ListItemNewsBinding
import com.iyaliyul.newssssapp.utils.loadImage
import com.xwray.groupie.viewbinding.BindableItem

class MainItem(
    private val news: ArticleItem,
    private val onclick: (ArticleItem) -> Unit
): BindableItem<ListItemNewsBinding>() {

    override fun bind(viewBinding: ListItemNewsBinding, position: Int) {
        viewBinding.apply {
            itemName.text = news.title
            itemImage.loadImage(news.urlToImage)
            itemDesc.text = news.description
            itemCard.setOnClickListener {
                onclick(news)
            }
        }
    }

    override fun getLayout(): Int = R.layout.list_item_news

    override fun initializeViewBinding(view: View): ListItemNewsBinding {
        return ListItemNewsBinding.bind(view)
    }


}