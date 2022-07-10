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
        Array(NUMBER_EDUCATION_DAYS_IN_WEEK){ i -> mutableListOf() }
    //endregion
}