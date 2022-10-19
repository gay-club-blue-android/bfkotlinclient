package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers.ViewModel
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductBinding
import com.example.bf_kotlin_client.databinding.ProductPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.Product
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.*

/**
 * класс, описывающий размещение элементов(продуктов) внутри RecyclerView,
 * а такжу обеспечивающий привязку xml к viewmodel
 * @param products список сущностей, который будет отображён
 */

class RvAdapterProducts(private var products: ArrayList<Product>) :
    RecyclerView.Adapter<RvAdapterProducts.ViewHolder>() {

    private var imageApiWorker = ImagesApiWorker()
    private var fragmentManager = GlobalVariables.instance.fragmentManager
    private var layoutInflater = GlobalVariables.instance.layoutInflater

    /**
     * подкласс, хранящий 1 элемент списка
     * @param binding разметка, которая будет использоваться для отображения элемента
     */
    inner class ViewHolder internal constructor(var binding: ProductPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * viewModel подкласс, обеспечивающий бизнес-логику для view конкретной сущности
     */
    inner class ViewModel {
        /**
         * поле, хранящее картитку элемента и обновляющее её при смене сужности
         * @see product
         */
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            imageApiWorker.getBitmapFromDrawableId(R.drawable.ic_launcher_background)
        )
            private set

        /**
         * поле, в котором хранится сущность элемента
         */
        var product = Product()
            set(value) {
                field = value
                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("products", value.photoPath)
                    fieldImage.set(bitmap)
                }
            }

        /**
         * открывает новый фрагмент и помещает в его viewModel текущую сущность
         */
        fun openProductView() {
            fragmentManager.openFragmentAboveMain(ProductFragment)
            var binding =
                fragmentManager.getCurrentFragmentBinding<FragmentProductBinding>()!!
            var viewModel = binding.viewModel!!
            viewModel.product = product
        }
    }

    /**
     * <вызывается автоматически>
     * метод инициализирующий элемент и его viewHolder с разметкой
     * @see ViewHolder
     * @see onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductPreviewBinding.inflate(layoutInflater, parent, false)
        return ViewHolder(binding)
    }

    /**
     * <вызывается автоматически>
     * привядывет к текущему элементу viewModel и кладёт в него сущность
     * @see onCreateViewHolder
     * @see ViewModel
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        var viewModel = ViewModel()
        viewModel.product = products[position]
        holder.binding.viewModel = viewModel
    }

    /**
     * <вызывается автоматически>
     * выдаёт количество элементов/сущностей
     */
    override fun getItemCount(): Int {
        return products.size
    }

}
