package com.edycation.note.journal.school.children.schooldiary.utils

import com.edycation.note.journal.school.children.schooldiary.model.data.ClassesDate

const val CICERONE_NAME: String = "cicerone"
const val MAIN_ACTIVITY_SCOPE: String = "MAIN_ACTIVITY_SCOPE"
const val CLASSES_FRAGMENT_SCOPE: String = "CLASSES_FRAGMENT_SCOPE"
const val HOME_FRAGMENT_SCOPE: String = "HOME_FRAGMENT_SCOPE"
val START_CLASSES_DATE: ClassesDate = ClassesDate(10,7,2022)
val END_CLASSES_DATE: ClassesDate = ClassesDate(30,7,2022)
const val NUMBER_EDUCATION_DAYS_IN_WEEK: Int = 7

enum class ClassesTypes {
    HISTORY,
    PHYSICAL_EDUCATION,
    LITERATURE,
    PHYSICS,
    MATHEMATICS,
    BIOLOGY,
    RUSSIA_LANGUAGE,
    ALGEBRA,
    GEOGRAPHY,
    MUSIC,
    GEOMETRY,
    ASTRONOMY,
    ENGLISH_LANGUAGE,
    HISTORY_OF_RUSSIA,
    INFORMATICS,
    GENERAL_HISTORY,
    SOCIAL_SCIENCE,
    FRENCH_LANGUAGE,
    GERMAN_LANGUAGE,
    NO
}

enum class StudyDayOfWeek {
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY,
    SUNDAY
}
