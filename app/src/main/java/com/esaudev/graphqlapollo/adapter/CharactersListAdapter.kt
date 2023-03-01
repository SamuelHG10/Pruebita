package com.esaudev.graphqlapollo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.esaudev.graphqlapollo.CharactersListQuery
import com.esaudev.graphqlapollo.databinding.ItemCharacterBinding

class CharactersListAdapter(
): ListAdapter<CharactersListQuery.Book, BaseListViewHolder<*>>(DiffUtilCallback)  {

    private object DiffUtilCallback : DiffUtil.ItemCallback<CharactersListQuery.Book>() {
        override fun areItemsTheSame(oldItem: CharactersListQuery.Book, newItem: CharactersListQuery.Book): Boolean = oldItem.author == newItem.author
        override fun areContentsTheSame(oldItem: CharactersListQuery.Book, newItem: CharactersListQuery.Book): Boolean = oldItem == newItem
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseListViewHolder<*> {
        val itemBinding = ItemCharacterBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return BindViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: BaseListViewHolder<*>, position: Int) {
        when (holder) {
            is BindViewHolder -> holder.bind(getItem(position), position)
        }
    }

    inner class BindViewHolder(private val binding: ItemCharacterBinding) : BaseListViewHolder<CharactersListQuery.Book>(binding.root) {

        override fun bind(item: CharactersListQuery.Book, position: Int) = with(binding) {

            characterId.text = item.author
            characterName.text = item.title
        }
    }
}