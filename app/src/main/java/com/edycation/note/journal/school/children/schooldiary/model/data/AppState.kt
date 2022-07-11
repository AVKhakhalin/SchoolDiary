package com.edycation.note.journal.school.children.schooldiary.model.data

sealed class AppState {
    data class Success(val lessionsList: List<Lession>?): AppState()
    data class Error(val error: Throwable): AppState()
    data class Loading(val progress: Int?): AppState()
}