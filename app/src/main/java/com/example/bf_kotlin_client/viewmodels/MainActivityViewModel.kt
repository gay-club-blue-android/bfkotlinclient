package com.example.bf_kotlin_client.viewmodels

import android.view.MenuItem
import androidx.activity.OnBackPressedCallback
import androidx.databinding.ObservableField
import com.example.bf_kotlin_client.R
import com.example.bf_kotlin_client.utils.AppFragmentManager
import com.example.bf_kotlin_client.utils.AppFragmentManager.FragmentsName.*
import com.example.bf_kotlin_client.utils.GlobalVariables

/**
 * Логика главного экрана приложения
 *
 */
class MainActivityViewModel {
    private var fragmentManager = GlobalVariables.instance.fragmentManager

    /**
     * Словарь,соотносящий id кнопок BottomNavigationView с названиями вкладок [AppFragmentManager]
     */
    private var menuItemIdToTabName: MutableMap<Int, AppFragmentManager.FragmentsName> =
        mutableMapOf(
            R.id.productsSection to ProductsCategoriesFragment,
            R.id.farmersSection to FarmersListFragment,
            R.id.favouritesSection to FavoriteProductsFragment,
            R.id.profileSection to ProfileFragment,
            R.id.supportSection to SupportQuestionsPageFragment
        )

    /**
     * Обработчик события кнопки "назад"
     *
     * Привязывется через параметр [onBackPressed][com.example.bf_kotlin_client.utils.onBackPressed]
     *
     * Косвенно используется в параметре [is_back_button][com.example.bf_kotlin_client.utils.setIsBackButton]
     *
     */
    var onBackPressedCallback = object : OnBackPressedCallback(true) {
        override fun handleOnBackPressed() {
            fragmentManager.popBackStack()
        }
    }

    init{
        GlobalVariables.instance.onBackPressedCallback = onBackPressedCallback
    }

    /**
     * Вызывается при нажатии на кнопку BottomNavigationView
     *
     * @param menuItem элемент, на который нажали
     * @return удалось ли нажать
     */
    fun onItemSelected(menuItem: MenuItem): Boolean {
        var tabName = menuItemIdToTabName[menuItem.itemId]
        fragmentManager.showTab(tabName!!)
        return true
    }

}