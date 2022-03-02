package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.Headers
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImageApiWorker
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RvAdapterProductsCategories(private var categories: ArrayList<ProductCategory>) :
    RecyclerView.Adapter<RvAdapterProductsCategories.ViewHolder>() {

    inner class ViewHolder internal constructor(var binding: ProductCategoryPreviewBinding) : RecyclerView.ViewHolder(binding.root) {
        private var globalVariables = GlobalVariables.instance

        var productCategory=ProductCategory()
        set(value){
            field=value
            fieldTitle.set(value.name)
            GlobalScope.launch(Dispatchers.IO) {
                var glideUrl = GlideUrl("http://151.248.113.116:8080/mobile/productsCategories/getPictureByName/${value.pictureName}",
                    globalVariables.headers)

                var bitmap = Glide.with(GlobalVariables.instance.applicationContext).asBitmap()
                    .load(glideUrl)
                    .error(R.drawable.error)
                    .fallback(R.drawable.fallback)
                    .submit().get()

                image.set(bitmap)
            }
        }

        var fieldTitle = ObservableField("")
        var image = ObservableField<Bitmap>(GlobalVariables.instance.applicationContext.getDrawable(R.drawable.ic_launcher_background)?.toBitmap())
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductCategoryPreviewBinding.bind(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.product_category_preview, parent, false)
        )
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.viewModel = holder

        holder.productCategory=categories[position]

    }

    override fun getItemCount(): Int {
        return categories.size
    }

}
