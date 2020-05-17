package io.material.materialthemebuilder.ui.cards

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.material.materialthemebuilder.R

sealed class CardViewHolder(val view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(card: Card) {
        // Override in subclass if needed.
    }

    class FoundationIDCardViewHolder(
            parent: ViewGroup
    ) : CardViewHolder(inflate(parent, R.layout.card_foundation_id_mtf))

    class SCPFileCardViewHolder(
            parent: ViewGroup
    ) : CardViewHolder(inflate(parent, R.layout.scp_id_custom_view))


    companion object {
        fun create(
                parent: ViewGroup,
                viewType: Int,
                listener: CardAdapter.CardAdapterListener
        ): CardViewHolder {
            return when (Card.values()[viewType]) {
                Card.FOUNDATION_ID -> CardViewHolder.FoundationIDCardViewHolder(parent)
                Card.SCP_FILE -> CardViewHolder.SCPFileCardViewHolder(parent)
            }
        }

        private fun inflate(parent: ViewGroup, layout: Int): View {
            return LayoutInflater.from(parent.context).inflate(layout, parent, false)
        }
    }
}