package com.edycation.note.journal.school.children.schooldiary.model.data

import com.edycation.note.journal.school.children.schooldiary.utils.ClassesTypes
import com.edycation.note.journal.school.children.schooldiary.utils.getClassesName
import com.edycation.note.journal.school.children.schooldiary.utils.getHomeworkDescription

data class HomeWork(
    val typeLession: ClassesTypes,
    val endDate: String,
    val nameLession: String = typeLession.getClassesName(),
    val description: String = typeLession.getHomeworkDescription()
)