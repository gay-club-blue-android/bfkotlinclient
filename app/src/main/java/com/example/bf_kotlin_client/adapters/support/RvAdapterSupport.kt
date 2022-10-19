package com.example.bf_kotlin_client.adapters.support

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers.ViewHolder
import com.example.bf_kotlin_client.adapters.farmers.RvAdapterFarmers.ViewModel
import com.example.bf_kotlin_client.databinding.*
import com.example.bf_kotlin_client.dtos.entities.Faq
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.GlobalVariables
import java.util.ArrayList

/**
 * класс, описывающий размещение элементов(вопросов) внутри RecyclerView,
 * а такжу обеспечивающий привязку xml к viewmodel
 * @param faqs список сущностей, который будет отображён
 */
class RvAdapterSupport(private var faqs: ArrayList<Faq>) :
    RecyclerView.Adapter<RvAdapterSupport.ViewHolder>() {

    private var globalVariables = GlobalVariables.instance
    private var fragmentManager = globalVariables.fragmentManager

    /**
     * подкласс, хранящий 1 элемент списка
     * @param binding разметка, которая будет использоваться для отображения элемента
     */
    inner class ViewHolder internal constructor(var binding: SupportPreviewBinding) :
        RecyclerView.ViewHolder(binding.root)

    /**
     * viewModel подкласс, обеспечивающий бизнес-логику для view конкретной сущности
     */
    inner class ViewModel {
        /**
         * поле, в котором хранится сущность элемента
         */
        var faq = Faq()

        /**
         * открывает новый фрагмент и помещает в его viewModel текущую сущность
         */
        fun openSupportNotMainPageFragment() {
            fragmentManager.openFragmentAboveMain(AppFragmentManager.FragmentsName.SupportAnswersPageFragment)

            var binding =
                fragmentManager.getCurrentFragmentBinding<FragmentSupportAnswersPageBinding>()
            var viewModel = binding!!.viewModel
            viewModel!!.faq = faq
        }
    }

    /**
     * <вызывается автоматически>
     * метод инициализирующий элемент и его viewHolder с разметкой
     * @see ViewHolder
     * @see onBindViewHolder
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RvAdapterSupport.ViewHolder {
        var binding = SupportPreviewBinding.bind(
            LayoutInflater.from(parent.context).inflate(R.layout.support_preview, parent, false)
        )

        return ViewHolder(binding)
    }
    /**
     * <вызывается автоматически>
     * привядывет к текущему элементу viewModel и кладёт в него сущность
     * @see onCreateViewHolder
     * @see ViewModel
     */
    override fun onBindViewHolder(holder: RvAdapterSupport.ViewHolder, position: Int) {
        holder.binding.viewModel = ViewModel()
        holder.binding.viewModel!!.faq = faqs[position]
    }

    /**
     * <вызывается автоматически>
     * выдаёт количество элементов/сущностей
     */
    override fun getItemCount(): Int {
        return faqs.size
    }

}