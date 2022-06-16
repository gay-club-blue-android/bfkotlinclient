package com.example.bf_kotlin_client.apiworkers

import android.graphics.Bitmap
import androidx.appcompat.content.res.AppCompatResources
import androidx.core.graphics.drawable.toBitmap
import com.bumptech.glide.Glide
import com.bumptech.glide.load.model.GlideUrl
import com.bumptech.glide.load.model.Headers
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.GlobalVariables
/**
 * класс, позволяющий осуществить запросы к серверу на получение изображений
 */
class ImagesApiWorker {

    private var globalVariables = GlobalVariables.instance

    /**
     * выдаёт картинку по указанному местоположению на сервере
     *
     * @param controllerName название папки на сервере, в которой лежит наша картинка
     * @param pictureName названия файла картинки
     * @return запрашиваемая картинка
     */
    fun getPictureByName(controllerName: String, pictureName: String): Bitmap {
        var serverUrl = globalVariables.applicationContext.getString(R.string.serverUrl)
        var glideUrl = GlideUrl(
            "$serverUrl$controllerName/getPictureByName/$pictureName",
            Headers {
                globalVariables.httpHeaders
            }
        )
        var bitmap = try {
            Glide.with(globalVariables.applicationContext).asBitmap()
                .load(glideUrl)
                .fallback(R.drawable.fallback)
                .submit().get()
        } catch (e: Exception) {
            getBitmapFromDrawableId(R.drawable.error)
        }
        return bitmap
    }

    /**
     * возвращает drawable из приложения в виде [Bitmap]
     *
     * @param drawableId id искомого drawable в текущей сессии
     * @return искомая картика
     */
    fun getBitmapFromDrawableId(drawableId: Int): Bitmap {
        return AppCompatResources.getDrawable(globalVariables.applicationContext, drawableId)!!
            .toBitmap(1000, 1000)
    }
}