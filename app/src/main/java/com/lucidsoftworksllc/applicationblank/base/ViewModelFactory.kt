package com.lucidsoftworksllc.applicationblank.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.lucidsoftworksllc.applicationblank.main_activity.repositories.MainActivityRepository
import com.lucidsoftworksllc.applicationblank.main_activity.view_models.MainActivityViewModel

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(
    private val repository: BaseRepository
) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return when{
            modelClass.isAssignableFrom(MainActivityViewModel::class.java) -> MainActivityViewModel(repository as MainActivityRepository) as T
            else -> throw IllegalArgumentException("ViewModel Class Not Found")
        }
    }
}