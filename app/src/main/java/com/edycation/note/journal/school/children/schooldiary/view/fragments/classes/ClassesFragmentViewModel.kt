package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.cachedIn
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseViewModel
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.MAX_PAGE_SIZE
import com.edycation.note.journal.school.children.schooldiary.utils.convertDayToIndex
import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.list.ClassesListPageSource
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.list.HomeworkListPageSource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.java.KoinJavaComponent
import java.util.*

class ClassesFragmentViewModel(
    private val interactor: ClassesFragmentInteractor
): BaseViewModel<AppState>() {
    /** Задание исходных данных */ //region
    // Информация с результатом запроса
    private val liveDataForViewToObserve: LiveData<AppState> = _mutableLiveData
    // Settings
    private val settings: Settings = KoinJavaComponent.getKoin().get()
    // Paging 3.0
    val lession = Pager(PagingConfig(pageSize = MAX_PAGE_SIZE, enablePlaceholders = true)) {
        ClassesListPageSource(settings.currentData.get(Calendar.DAY_OF_WEEK).convertDayToIndex())
    }.flow.cachedIn(viewModelScope)
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