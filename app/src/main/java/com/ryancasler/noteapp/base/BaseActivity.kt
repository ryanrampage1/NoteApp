package com.ryancasler.noteapp.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjection

abstract class BaseActivity<out P : BasePresenter> : AppCompatActivity()  {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)

        getPresenter().onCreate()
    }

    override fun onResume() {
        super.onResume()
        getPresenter().onResume()
    }

    abstract fun getPresenter(): P
}