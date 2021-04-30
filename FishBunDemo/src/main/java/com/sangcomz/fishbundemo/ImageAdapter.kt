package com.sangcomz.fishbundemo

import android.content.Context
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item.view.*
import java.util.*

/**
 * Created by sangc on 2015-11-06.
 */
class ImageAdapter(
    private val context: Context,
    private val imageController: ImageController,
    private var imagePaths: List<Uri> = emptyList()
) : RecyclerView.Adapter<ImageAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val imagePath = imagePaths[position]
        Picasso
            .with(context)
            .load(imagePath)
            .fit()
            .centerCrop()
            .into(holder.imageView);
        holder.imageView.setOnClickListener { imageController.setImgMain(imagePath) }
    }

    fun changePath(imagePaths: ArrayList<Uri>) {
        this.imagePaths = imagePaths
        imageController.setImgMain(imagePaths[0])
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = imagePaths.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val imageView = itemView.img_item as ImageView
    }
}