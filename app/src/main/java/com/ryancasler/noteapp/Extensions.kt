package com.ryancasler.noteapp

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

/**
 * Inflate a layout from a view group. Made for RecyclerView.
 */
fun ViewGroup.inflateView(layoutRes: Int): View {
    val layoutInflater = LayoutInflater.from(context)
    return layoutInflater.inflate(layoutRes, this, false)
}