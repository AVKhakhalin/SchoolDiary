package com.edycation.note.journal.school.children.schooldiary.model.data

import com.edycation.note.journal.school.children.schooldiary.utils.*
import java.util.*

data class Lession(
    val type: ClassesTypes,
    val startDate: String,
    val position: Int,
    val isAdditional: Boolean,
    val isOpenIn: Boolean,
    val examDateString: String,
    val homeWork: HomeWork,
    val examDate: ExamDate = examDateString.getExamDate(),
    val startTime: Calendar = startDate.getClassesStartTime(position, isAdditional),
    val name: String = type.getClassesName(),
    val teacherName: String = type.getClassesTeacherName()
)