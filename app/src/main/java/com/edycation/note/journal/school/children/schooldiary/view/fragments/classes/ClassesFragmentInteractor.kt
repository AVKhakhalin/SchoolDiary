package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes

import com.edycation.note.journal.school.children.schooldiary.model.base.Interactor
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProvider
import org.koin.java.KoinJavaComponent.getKoin

class ClassesFragmentInteractor(
    private val resourcesProviderImpl: ResourcesProvider,
): Interactor<AppState> {
    /** Исходные данные */ //region
    private val settings: Settings = getKoin().get()
    //endregion

    override suspend fun getData(dayIndex: Int): AppState {
        val appState: AppState = AppState.Success(settings.classes[dayIndex])
        return appState
    }
}