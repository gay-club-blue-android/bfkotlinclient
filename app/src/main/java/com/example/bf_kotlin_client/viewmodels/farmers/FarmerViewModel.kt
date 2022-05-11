package com.example.bf_kotlin_client.viewmodels.farmers

import android.graphics.Bitmap
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.dtos.entities.Farmer
import kotlinx.coroutines.*

/**
 * Логика фрагмента [профиля фермера][com.example.bf_kotlin_client.fragments.farmers.FarmerFragment]
 *
 */
class FarmerViewModel {
    private var imageApiWorker = ImagesApiWorker()

    /**
     * Сущность фермера, данные которой представлены к отображению
     */
    var farmer: Farmer=Farmer()
        set(value) {
            field = value
            GlobalScope.launch(Dispatchers.IO) {
                var bitmap =
                    imageApiWorker.getPictureByName("farmers", value.photoPath)
                picture.set(bitmap)
            }
        }

    /**
     * Изображение [фермера][farmer], обновляется вместе с ним
     */
    var picture= ObservableField(
        imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background))
        private set
}