package io.material.materialthemebuilder.ui.cards

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import io.material.materialthemebuilder.R

class CardsFragment : Fragment(), CardAdapter.CardAdapterListener {

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_cards, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceBundle: Bundle?) {
        super.onViewCreated(view, savedInstanceBundle)

        val recyclerView: RecyclerView = view.findViewById(R.id.recycler_view)
        val adapter = CardAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        recyclerView.adapter = adapter
        adapter.submitList(Card.values().toList())
    }
}
