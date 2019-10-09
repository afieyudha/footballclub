package com.example.footballclub

import android.content.Intent
import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import com.bumptech.glide.Glide
import android.view.LayoutInflater
import com.bumptech.glide.request.RequestOptions
import android.widget.TextView

class ListClubAdapter(val listClub: ArrayList<Club>) : RecyclerView.Adapter<ListClubAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int) : ListViewHolder {
        val view: View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_card_club, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listClub.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, rank, photo, overview, identity) =listClub[position]

        Glide.with(holder.itemView.context)
            .load(photo)
            .apply(RequestOptions())
            .into(holder.imgPhoto)

        holder.tvName.text = name
        holder.tvRank.text = rank

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, detail_club::class.java)
            moveDetail.putExtra(detail_club.EXTRA_RANK, rank)
            moveDetail.putExtra(detail_club.EXTRA_NAME, name)
            moveDetail.putExtra(detail_club.EXTRA_PHOTO, photo)
            moveDetail.putExtra(detail_club.EXTRA_IDENTITY, identity)
            moveDetail.putExtra(detail_club.EXTRA_OVERVIEW, overview)
            mContext.startActivity(moveDetail)
        }
    }

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_item_name)
        var tvRank: TextView = itemView.findViewById(R.id.tv_item_rank)
        var imgPhoto: ImageView = itemView.findViewById(R.id.img_item_photo)
    }

}