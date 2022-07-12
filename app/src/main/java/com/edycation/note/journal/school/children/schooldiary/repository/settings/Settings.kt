package com.edycation.note.journal.school.children.schooldiary.repository.settings

import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.utils.NUMBER_EDUCATION_DAYS_IN_WEEK
import java.util.*

class Settings {
    /** Исходные данные */ //region
    // Текущая дата
    val currentData: Calendar = Calendar.getInstance()
    // Расписание ученика
    val classes: Array<MutableList<Lession>> =
        Array(NUMBER_EDUCATION_DAYS_IN_WEEK) { i -> mutableListOf() }
    //endregion

    // Метод извлечения нужного количества уроков для работы Paging 3.0
    fun getListLesions(dayIndex: Int, pageNumber: Int, elementsOnPage: Int): List<Lession> {
        val result: MutableList<Lession> = mutableListOf()
        repeat(elementsOnPage) {
            if ((dayIndex < classes.size) && (pageNumber - 1 + it < classes[dayIndex].size))
                result.add(classes[dayIndex][pageNumber - 1 + it])
        }
        return result
    }
}