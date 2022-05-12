package com.example.bf_kotlin_client.viewmodels.products

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.dtos.entities.Product
import kotlinx.coroutines.*

/**
 * Логика фрагмента [страницы продукта][com.example.bf_kotlin_client.fragments.products.ProductFragment]
 *
 */
class ProductViewModel {
    private var imageApiWorker = ImagesApiWorker()

    /**
     * Сущность продукта, отображаемая фрагментом
     */
    var product: Product = Product()
        set(value) {
            field = value
            GlobalScope.launch(Dispatchers.IO) {
                var bitmap =
                    imageApiWorker.getPictureByName("products", value.photoPath)
                picture.set(bitmap)
            }
        }

    /**
     * Изображение [продукта][product],обновляется вместе с продуктом
     */
    var picture = ObservableField(
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background))
        private set
}