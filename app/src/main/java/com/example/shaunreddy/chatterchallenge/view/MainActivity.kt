package com.example.shaunreddy.chatterchallenge.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.shaunreddy.chatterchallenge.R
import com.example.shaunreddy.chatterchallenge.utils.dagger.DaggerComponent
import com.example.shaunreddy.chatterchallenge.utils.dagger.PresenterModule
import dagger.Component
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainActivityContract.IMainActivity {
    @Inject
    lateinit var presenter: MainActivityPresenter
    lateinit var component: Component
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

       DaggerComponent.builder().presenterModule(PresenterModule()).build().injectPresenter(this)
       if(presenter == null) print("null")

    }

    public override fun populateRecyclerView(){

    }
}
