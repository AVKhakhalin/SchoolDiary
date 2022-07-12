package com.edycation.note.journal.school.children.schooldiary.model.data

import com.edycation.note.journal.school.children.schooldiary.utils.ClassesTypes
import com.edycation.note.journal.school.children.schooldiary.utils.getClassesName
import com.edycation.note.journal.school.children.schooldiary.utils.getExamDateClassesDate
import com.edycation.note.journal.school.children.schooldiary.utils.getHomeworkDescription

data class HomeWork(
    val typeLession: ClassesTypes,
    val examDate: ClassesDate,
    val nameLession: String = typeLession.getClassesName(),
    val description: String = typeLession.getHomeworkDescription()
)