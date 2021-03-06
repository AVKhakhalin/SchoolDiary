package com.edycation.note.journal.school.children.schooldiary.utils

import com.edycation.note.journal.school.children.schooldiary.model.data.ClassesDate

const val CICERONE_NAME: String = "cicerone"
const val MAIN_ACTIVITY_SCOPE: String = "MAIN_ACTIVITY_SCOPE"
const val CLASSES_FRAGMENT_SCOPE: String = "CLASSES_FRAGMENT_SCOPE"
const val HOME_FRAGMENT_SCOPE: String = "HOME_FRAGMENT_SCOPE"
val START_CLASSES_DATE: ClassesDate = ClassesDate(2022,7,10)
val END_CLASSES_DATE: ClassesDate = ClassesDate(2022, 7,30)
const val NUMBER_EDUCATION_DAYS_IN_WEEK: Int = 7
const val DATE_FORMAT: String = "dd/MM/yyyy"
const val TIME_FORMAT: String = "HH:mm"
const val DELTA_EXAMS: Int = 7
const val ZERO_STRING: String = "0"
const val MILLISECONDS_IN_DAY: Long = 86400000
const val REFRESH_EXAM_TIME_DELAY: Long = 1000L

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

// Настройки Paging 3.0
const val INITIAL_PAGE_NUMBER: Int = 1
const val MAX_PAGE_SIZE: Int = 5
const val MAX_ELEMENTS_ON_PAGE: Int = 10
const val INFINITY_KOEFFICIENT: Int = 10000
