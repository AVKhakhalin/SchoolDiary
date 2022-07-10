package com.edycation.note.journal.school.children.schooldiary.utils

const val CICERONE_NAME: String = "cicerone"
const val MAIN_ACTIVITY_SCOPE: String = "MAIN_ACTIVITY_SCOPE"
const val CLASSES_FRAGMENT_SCOPE: String = "CLASSES_FRAGMENT_SCOPE"
const val HOME_FRAGMENT_SCOPE: String = "HOME_FRAGMENT_SCOPE"
const val START_CLASSES_DATE: String = "10.07.2022"
const val END_CLASSES_DATE: String = "30.07.2022"
// 8 указано с учётом последнего индекса субботы = 7
const val NUMBER_EDUCATION_DAYS_IN_WEEK: Int = 8

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

