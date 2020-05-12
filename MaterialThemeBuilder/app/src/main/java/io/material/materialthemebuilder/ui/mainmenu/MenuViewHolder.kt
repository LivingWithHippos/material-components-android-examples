package io.material.materialthemebuilder.ui.mainmenu

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.material.materialthemebuilder.R

sealed class MenuViewHolder (val view: View) : RecyclerView.ViewHolder(view) {

    open fun bind(menu: Menu) {
        // Override in subclass if needed.
    }

    class MainMenuViewHolder(
            parent: ViewGroup
    ) : MenuViewHolder(inflate(parent, R.layout.component_main_menu))

    class MainMenuV2ViewHolder(
            parent: ViewGroup
    ) : MenuViewHolder(inflate(parent, R.layout.component_main_menu_v2))


    companion object {
        fun create(
                parent: ViewGroup,
                viewType: Int,
                listener: MenuAdapter.MenuAdapterListener
        ): MenuViewHolder {
            return when (Menu.values()[viewType]) {
                Menu.MAIN -> MainMenuViewHolder(parent)
                Menu.MAIN_V2 ->  MainMenuV2ViewHolder(parent)
            }
        }

        private fun inflate(parent: ViewGroup, layout: Int): View {
            return LayoutInflater.from(parent.context).inflate(layout, parent, false)
        }
    }
}