package com.template.kotlinmvvm.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.kotlinmvvm.R.layout
import com.template.kotlinmvvm.ui.adapters.UserRecyclerAdapter
import com.template.viewmodels.UserViewModel
import kotlinx.android.synthetic.main.activity_main.usersRecyclerView
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
  private val userViewModel by viewModel<UserViewModel>()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    usersRecyclerView.layoutManager = LinearLayoutManager(this)
    userViewModel.userLiveData.observe(this, Observer {
      var userAdapter = UserRecyclerAdapter()
      userAdapter.context = this
      userAdapter.users = it
      usersRecyclerView.adapter = userAdapter
    })

    userViewModel.errorLiveData.observe(this, Observer {
      showError(it)
    })
    userViewModel.getUsers()

  }

  fun showError(throwable: Throwable) {
    Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
  }

  override fun onStart() {
    super.onStart()

  }
}
