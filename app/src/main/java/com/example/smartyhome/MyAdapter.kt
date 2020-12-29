package com.example.smartyhome

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.row.view.*

class MyAdapter(val arrayList: ArrayList<Model>,val context:Context):
    RecyclerView.Adapter<MyAdapter.VieHolder>() {

    class VieHolder(itemview:View):RecyclerView.ViewHolder(itemview){

        fun binfItems(model: Model){

            itemView.title.text=model.Title
            itemView.dec.text=model.Desc
            itemView.imageid.setImageResource(model.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VieHolder {

        val v = LayoutInflater.from(parent.context).inflate(R.layout.row,parent,false)
        return VieHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: VieHolder, position: Int) {

holder.binfItems(arrayList[position])
    }

}