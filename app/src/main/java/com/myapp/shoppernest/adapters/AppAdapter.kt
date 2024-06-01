package com.myapp.shoppernest.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.myapp.shoppernest.databinding.ItemAppBinding
import com.myapp.shoppernest.models.App

class AppAdapter(private val appList : ArrayList<App>, private val onClick : (String) -> Unit) : RecyclerView.Adapter<AppAdapter.AppViewHolder>() {


    class AppViewHolder(val binding : ItemAppBinding): RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AppViewHolder {
        return AppViewHolder(ItemAppBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount() = appList.size

    override fun onBindViewHolder(holder: AppViewHolder, position: Int) {

        val app = appList[position]

        Glide.with(holder.itemView.context)
            .load(app.appImage)
            .into(holder.binding.appIcon)
        holder.binding.appName.text = app.appName


        holder.binding.app.setOnClickListener {
            onClick(app.appUrl)
        }
    }
}