package com.example.myapplication.presentation.main_screen


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.MainViewModel
import com.example.myapplication.R
import com.example.myapplication.data.db.model.Card
import kotlinx.android.synthetic.main.card.view.*


class MainAdapter(mainActivity: MainActivity): RecyclerView.Adapter<MainAdapter.Holder>() {

    class Holder(view: View): RecyclerView.ViewHolder(view)

    val mainViewModel = ViewModelProvider(mainActivity)[MainViewModel::class.java]
    var list = emptyList<Card>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.card, parent, false)
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.titleID.setText(list[position].title)
        holder.itemView.summa.setText(list[position].sum)
        holder.itemView.deleteCardButton.setOnClickListener {
            mainViewModel.delete(list[position].id)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun addCard(listCard: List<Card>) {
        list = listCard
        notifyDataSetChanged()
    }

}