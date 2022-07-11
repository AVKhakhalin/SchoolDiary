package com.edycation.note.journal.school.children.schooldiary.model.base

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.navigation.AppScreens
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.github.terrakok.cicerone.Router
import kotlinx.coroutines.*
import org.koin.java.KoinJavaComponent.getKoin

abstract class BaseViewModel<T: AppState>(
    protected open val _mutableLiveData: MutableLiveData<T> = MutableLiveData(),
    protected open val _mutableLiveDataSettings: MutableLiveData<Settings> = MutableLiveData()
): ViewModel() {
    /** Исходные данные */ //region
    // Навигация
    val screens: AppScreens = getKoin().get()
    val router: Router = getKoin().get()
    //endregion

    protected val viewModelCoroutineScope = CoroutineScope(
        Dispatchers.Main
                + SupervisorJob()
                + CoroutineExceptionHandler { _, throwable ->
            handleError(throwable)
        })

    override fun onCleared() {
        super.onCleared()
        cancelJob()
    }

    protected fun cancelJob() {
        viewModelCoroutineScope.coroutineContext.cancelChildren()
    }

    abstract fun getData(dayIndex: Int)

    abstract fun handleError(error: Throwable)
}