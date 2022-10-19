package com.example.bf_kotlin_client.adapters.products

import android.graphics.Bitmap
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.graphics.drawable.toBitmap
import androidx.databinding.ObservableField
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers.ViewHolder
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers.ViewModel
import com.example.bf_kotlin_client.apiworkers.ImagesApiWorker
import com.example.bf_kotlin_client.databinding.FragmentProductsInCategoryBinding
import com.example.bf_kotlin_client.databinding.ProductCategoryPreviewBinding
import com.example.bf_kotlin_client.dtos.entities.ProductCategory
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.ProductsInCategoryFragment
import com.example.bf_kotlin_client.utils.GlobalVariables
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

/**
 * класс, описывающий размещение элементов(категорий продуктов) внутри RecyclerView,
 * а такжу обеспечивающий привязку xml к viewmodel
 * @param categories список сущностей, который будет отображён
 */
class RvAdapterProductsCategories(private var categories: ArrayList<ProductCategory>) :
    RecyclerView.Adapter<RvAdapterProductsCategories.ViewHolder>() {

    private var globalVariables = GlobalVariables.instance
    private var imageApiWorker = ImagesApiWorker()
    private var layoutInflater = GlobalVariables.instance.layoutInflater

    /**
     * подкласс, хранящий 1 элемент списка
     * @param binding разметка, которая будет использоваться для отображения элемента
     */
    inner class ViewHolder internal constructor(var binding: ProductCategoryPreviewBinding) : RecyclerView.ViewHolder(binding.root)

    /**
     * viewModel подкласс, обеспечивающий бизнес-логику для view конкретной сущности
     */
    inner class ViewModel{
        /**
         * поле, хранящее картитку элемента и обновляющее её при смене сужности
         * @see productCategory
         */
        var fieldImage: ObservableField<Bitmap> = ObservableField(
            globalVariables.applicationContext.getDrawable(R.drawable.ic_launcher_background)
                ?.toBitmap()
        )
            private set

        /**
         * поле, в котором хранится сущность элемента
         */
        var productCategory = ProductCategory()
            set(value) {
                field = value

                GlobalScope.launch(Dispatchers.IO) {
                    var bitmap =
                        imageApiWorker.getPictureByName("productsCategories", value.pictureName)
                    fieldImage.set(bitmap)
                }
            }
        /**
         * открывает новый фрагмент со списком продуктов в категории,
         * соответствующей текущей сущности
         */
        fun openProductList() {
            var fm = globalVariables.fragmentManager
            fm.openFragmentAboveMain(ProductsInCategoryFragment)
            var binding = fm.getCurrentFragmentBinding<FragmentProductsInCategoryBinding>()!!
            var viewModel = binding.viewModel!!
            viewModel.category = productCategory
        }
    }


    /**
     * <вызывается автоматически>
     * метод инициализирующий элемент и его viewHolder с разметкой
     * @see ViewHolder
     * @see onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var binding = ProductCategoryPreviewBinding.inflate(layoutInflater, parent, false)
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
        holder.binding.viewModel = viewModel
        viewModel.productCategory = categories[position]
    }

    /**
     * <вызывается автоматически>
     * выдаёт количество элементов/сущностей
     */
    override fun getItemCount(): Int {
        return categories.size
    }

}
