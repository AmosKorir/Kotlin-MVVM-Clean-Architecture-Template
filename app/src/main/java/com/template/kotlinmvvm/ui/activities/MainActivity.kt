package com.template.kotlinmvvm.ui.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.template.domain.models.GithubUser
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

        userViewModel.getState().observe(this, Observer {
            onStateChanged(it)
        })
        userViewModel.fetchUsers()

    }

    fun showError(throwable: Throwable) {
        Toast.makeText(this, throwable.message, Toast.LENGTH_LONG).show()
    }

    private fun onStateChanged(state: UserViewModel.State) = when (state) {
        is UserViewModel.State.Users -> {
            showUsers(state.users)
        }
        UserViewModel.State.ShowLoading -> {
        }
        UserViewModel.State.ShowContent -> {
        }
        UserViewModel.State.ShowError -> {

        }
    }

    private fun showUsers(users: List<GithubUser>) {
        val userAdapter = UserRecyclerAdapter()
        userAdapter.context = this
        userAdapter.users = users
        usersRecyclerView.adapter = userAdapter
    }

    override fun onStart() {
        super.onStart()

    }
}
