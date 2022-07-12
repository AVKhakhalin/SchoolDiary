package com.edycation.note.journal.school.children.schooldiary.model.data

import com.edycation.note.journal.school.children.schooldiary.utils.*
import java.util.*

data class Lession(
    val type: ClassesTypes,
    val startDate: ClassesDate,
    val position: Int,
    val isAdditional: Boolean,
    val isOpenIn: Boolean,
    val endDate: ClassesDate,
    val homeWork: HomeWork,
    val startTime: Calendar = startDate.convertStartClassesTimeToCalendar(position, isAdditional),
    val endTime: Calendar = startDate.convertEndClassesTimeToCalendar(position, isAdditional),
    val name: String = type.getClassesName(),
    val teacherName: String = type.getClassesTeacherName()
)