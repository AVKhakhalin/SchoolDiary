package com.edycation.note.journal.school.children.schooldiary.model.base

interface Interactor<T> {

    suspend fun getData(): T
}