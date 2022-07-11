package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes

import androidx.lifecycle.LiveData
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseViewModel
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ClassesFragmentViewModel(
    private val interactor: ClassesFragmentInteractor
): BaseViewModel<AppState>() {
    /** Задание исходных данных */ //region
    // Информация с результатом запроса
    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    //endregion

    override fun getData(dayIndex: Int) {
        // Выполнение поиска
        _mutableLiveData.value = AppState.Loading(null)
        cancelJob()
        viewModelCoroutineScope.launch {
            startInteractor(dayIndex)
        }
    }

    private suspend fun startInteractor(dayIndex: Int) =
        withContext(Dispatchers.IO) {
            _mutableLiveData.postValue(interactor.getData(dayIndex))
        }

    override fun handleError(error: Throwable) {
        _mutableLiveData.postValue(AppState.Error(error))
    }

    fun subscribe(): LiveData<AppState> {
        return liveDataForViewToObserve
    }
}