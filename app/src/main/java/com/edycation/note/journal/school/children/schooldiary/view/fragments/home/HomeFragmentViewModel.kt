package com.edycation.note.journal.school.children.schooldiary.view.fragments.home

import androidx.lifecycle.LiveData
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseViewModel
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeFragmentViewModel(
    private val interactor: HomeFragmentInteractor
): BaseViewModel<AppState>() {
    /** Задание исходных данных */ //region
    // Информация с результатом запроса
    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    //endregion

    override fun getData() {
        // Выполнение поиска
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch {
            startInteractor()
        }
    }

    private suspend fun startInteractor() =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getData())
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }
}