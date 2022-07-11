package com.edycation.note.journal.school.children.schooldiary.view.fragments.home

import com.edycation.note.journal.school.children.schooldiary.model.base.Interactor
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import org.koin.java.KoinJavaComponent

class HomeFragmentInteractor: Interactor<AppState> {
    /** Исходные данные */ //region
    private val settings: Settings = KoinJavaComponent.getKoin().get()
    //endregion

    override suspend fun getData(dayIndex: Int): AppState {
        val appState: AppState = AppState.Success(settings.classes[dayIndex])
        return appState
    }
}