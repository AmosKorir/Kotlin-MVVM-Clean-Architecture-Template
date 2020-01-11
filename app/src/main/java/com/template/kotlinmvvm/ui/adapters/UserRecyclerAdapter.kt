package com.template.kotlinmvvm.ui.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.NonNull
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import com.template.domain.models.GithubUser
import com.template.kotlinmvvm.R
import com.template.kotlinmvvm.ui.adapters.UserRecyclerAdapter.UsersViewHolder
import kotlinx.android.synthetic.main.item_row.view.avatar
import kotlinx.android.synthetic.main.item_row.view.loginU

/**
 * Created by Korir on 1/12/20.
 * amoskrr@gmail.com
 */

class UserRecyclerAdapter : RecyclerView.Adapter<UsersViewHolder>() {

  lateinit var context: Context
  lateinit var users: List<GithubUser>

  class UsersViewHolder(@NonNull itemView: View) : RecyclerView.ViewHolder(itemView) {
    var view = itemView
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersViewHolder {
    return UsersViewHolder(LayoutInflater.from(context).inflate(R.layout.item_row, parent, false))
  }

  override fun getItemCount(): Int {
    return users.size
  }

  override fun onBindViewHolder(holder: UsersViewHolder, position: Int) {
    var user = users[position]
    holder.view.loginU.text = user.login
    Picasso.get().load(user.avatar_url).into(holder.view.avatar)

  }
}