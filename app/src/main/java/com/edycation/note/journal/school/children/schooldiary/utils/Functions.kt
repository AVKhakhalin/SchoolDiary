package com.edycation.note.journal.school.children.schooldiary.utils

import com.edycation.note.journal.school.children.schooldiary.R
import com.edycation.note.journal.school.children.schooldiary.model.data.ExamDate
import com.edycation.note.journal.school.children.schooldiary.model.data.HomeWork
import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProvider
import org.koin.java.KoinJavaComponent.getKoin
import java.util.*

// Получение названия урока
fun ClassesTypes.getClassesName(): String {
    /** Исходные данные */ //region
    val resourcesProviderImpl: ResourcesProvider = getKoin().get()
    //endregion
    return when(this) {
        ClassesTypes.HISTORY -> resourcesProviderImpl.getString(R.string.classes_hystory)
        ClassesTypes.PHYSICAL_EDUCATION ->
            resourcesProviderImpl.getString(R.string.classes_physical_education)
        ClassesTypes.LITERATURE -> resourcesProviderImpl.getString(R.string.classes_literature)
        ClassesTypes.PHYSICS -> resourcesProviderImpl.getString(R.string.classes_physics)
        ClassesTypes.MATHEMATICS -> resourcesProviderImpl.getString(R.string.classes_mathematics)
        ClassesTypes.BIOLOGY -> resourcesProviderImpl.getString(R.string.classes_biology)
        ClassesTypes.RUSSIA_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_russia_language)
        ClassesTypes.ALGEBRA -> resourcesProviderImpl.getString(R.string.classes_algebra)
        ClassesTypes.GEOGRAPHY -> resourcesProviderImpl.getString(R.string.classes_geography)
        ClassesTypes.MUSIC -> resourcesProviderImpl.getString(R.string.classes_music)
        ClassesTypes.GEOMETRY -> resourcesProviderImpl.getString(R.string.classes_geometry)
        ClassesTypes.ASTRONOMY -> resourcesProviderImpl.getString(R.string.classes_astronomy)
        ClassesTypes.ENGLISH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_english_language)
        ClassesTypes.HISTORY_OF_RUSSIA ->
            resourcesProviderImpl.getString(R.string.classes_history_of_russia)
        ClassesTypes.INFORMATICS -> resourcesProviderImpl.getString(R.string.classes_informatics)
        ClassesTypes.GENERAL_HISTORY ->
            resourcesProviderImpl.getString(R.string.classes_general_history)
        ClassesTypes.FRENCH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_french_language)
        ClassesTypes.GERMAN_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_german_language)
        ClassesTypes.NO -> ""
        else -> ""
    }
}

// Получение имени учителя
fun ClassesTypes.getClassesTeacherName(): String {
    /** Исходные данные */ //region
    val resourcesProviderImpl: ResourcesProvider = getKoin().get()
    //endregion
    return when(this) {
        ClassesTypes.HISTORY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_hystory)
        ClassesTypes.PHYSICAL_EDUCATION ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_physical_education)
        ClassesTypes.LITERATURE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_literature)
        ClassesTypes.PHYSICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_physics)
        ClassesTypes.MATHEMATICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_mathematics)
        ClassesTypes.BIOLOGY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_biology)
        ClassesTypes.RUSSIA_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_russia_language)
        ClassesTypes.ALGEBRA ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_algebra)
        ClassesTypes.GEOGRAPHY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_geography)
        ClassesTypes.MUSIC -> resourcesProviderImpl.getString(R.string.classes_teacher_name_music)
        ClassesTypes.GEOMETRY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_geometry)
        ClassesTypes.ASTRONOMY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_astronomy)
        ClassesTypes.ENGLISH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_english_language)
        ClassesTypes.HISTORY_OF_RUSSIA ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_history_of_russia)
        ClassesTypes.INFORMATICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_informatics)
        ClassesTypes.GENERAL_HISTORY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_general_history)
        ClassesTypes.FRENCH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_french_language)
        ClassesTypes.GERMAN_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_german_language)
        ClassesTypes.NO -> ""
        else -> ""
    }
}

// Получение времени урока
fun String.getClassesStartTime(position: Int, isAdditional: Boolean): Calendar {
    val calendarStart: Calendar = Calendar.getInstance()
    val startDate: Array<String> = this.split(".", "/", "|", "\\", " ").toTypedArray()
    val beginDay: Int = if (startDate[0].isNotEmpty()) startDate[0].toInt() else 0
    val beginMonth: Int = if (startDate[1].isNotEmpty()) startDate[1].toInt() else 0
    val beginYear: Int = if (startDate[2].isNotEmpty()) startDate[2].toInt() else 0
    // this - номер урока
    if (!isAdditional) {
        return when (position) {
            1 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 8, 0)
                calendarStart
            }
            2 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 9, 0)
                calendarStart
            }
            3 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 10, 0)
                calendarStart
            }
            4 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 11, 0)
                calendarStart
            }
            5 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 12, 0)
                calendarStart
            }
            6 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 13, 0)
                calendarStart
            }
            7 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 14, 0)
                calendarStart
            }
            8 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 15, 0)
                calendarStart
            }
            else -> calendarStart
        }
    } else {
        return when (position) {
            1 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 8, 0)
                calendarStart
            }
            2 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 9, 0)
                calendarStart
            }
            3 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 10, 0)
                calendarStart
            }
            4 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 11, 0)
                calendarStart
            }
            5 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 12, 0)
                calendarStart
            }
            6 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 13, 0)
                calendarStart
            }
            7 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 14, 0)
                calendarStart
            }
            8 -> {
                calendarStart.set(beginYear, beginMonth, beginDay, 15, 0)
                calendarStart
            }
            else -> calendarStart
        }
    }
}


// Получение имени учителя
fun ClassesTypes.getHomeworkDescription(): String {
    /** Исходные данные */ //region
    val resourcesProviderImpl: ResourcesProvider = getKoin().get()
    //endregion
    return when(this) {
        ClassesTypes.HISTORY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_hystory)
        ClassesTypes.PHYSICAL_EDUCATION ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_physical_education)
        ClassesTypes.LITERATURE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_literature)
        ClassesTypes.PHYSICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_physics)
        ClassesTypes.MATHEMATICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_mathematics)
        ClassesTypes.BIOLOGY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_biology)
        ClassesTypes.RUSSIA_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_russia_language)
        ClassesTypes.ALGEBRA ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_algebra)
        ClassesTypes.GEOGRAPHY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_geography)
        ClassesTypes.MUSIC -> resourcesProviderImpl.getString(R.string.classes_teacher_name_music)
        ClassesTypes.GEOMETRY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_geometry)
        ClassesTypes.ASTRONOMY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_astronomy)
        ClassesTypes.ENGLISH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_english_language)
        ClassesTypes.HISTORY_OF_RUSSIA ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_history_of_russia)
        ClassesTypes.INFORMATICS ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_informatics)
        ClassesTypes.GENERAL_HISTORY ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_general_history)
        ClassesTypes.FRENCH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_french_language)
        ClassesTypes.GERMAN_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.classes_teacher_name_german_language)
        ClassesTypes.NO -> ""
        else -> ""
    }
}

// Установка экзаменационной даты
fun String.getExamDate(): ExamDate {
    val date: Array<String> = this.split(".", "/", "|", "\\", " ").toTypedArray()
    val examDate: ExamDate =
        ExamDate(if (date[0].isNotEmpty()) date[0].toInt() else 0,
                 if (date[1].isNotEmpty()) date[1].toInt() else 0,
                 if (date[2].isNotEmpty()) date[2].toInt() else 0)
    return examDate
}

// Установка текущего расписания
fun Array<MutableList<Lession>>.initiateClasses() {
    val startDate: String = START_CLASSES_DATE
    val endDate: String = END_CLASSES_DATE
    var examDate: String = "01.08.2022"
    var indexOfDay: Int = Calendar.MONDAY
    var classesType: ClassesTypes = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.FRENCH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GEOGRAPHY
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true,examDate, HomeWork(classesType, endDate)))

    examDate = "02.08.2022"
    indexOfDay = Calendar.TUESDAY
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MUSIC
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.FRENCH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        false,examDate, HomeWork(classesType, endDate)))

    examDate = "03.08.2022"
    indexOfDay = Calendar.WEDNESDAY
    classesType = ClassesTypes.INFORMATICS
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICS
    this[indexOfDay].add(Lession(classesType, startDate,6,true,
        true,examDate, HomeWork(classesType, endDate)))

    examDate = "04.08.2022"
    indexOfDay = Calendar.THURSDAY
    classesType = ClassesTypes.MUSIC
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GEOGRAPHY
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ALGEBRA
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.BIOLOGY
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GERMAN_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GENERAL_HISTORY
    this[indexOfDay].add(Lession(classesType, startDate,6,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICAL_EDUCATION
    this[indexOfDay].add(Lession(classesType, startDate,7,true,
        false,examDate, HomeWork(classesType, endDate)))

    examDate = "05.08.2022"
    indexOfDay = Calendar.FRIDAY
    classesType = ClassesTypes.SOCIAL_SCIENCE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.HISTORY_OF_RUSSIA
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICS
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GERMAN_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.INFORMATICS
    this[indexOfDay].add(Lession(classesType, startDate,5,true,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,7,true,
        false,examDate, HomeWork(classesType, endDate)))

    examDate = "06.08.2022"
    indexOfDay = Calendar.SATURDAY
    classesType = ClassesTypes.BIOLOGY
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ENGLISH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GENERAL_HISTORY
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ASTRONOMY
    this[indexOfDay].add(Lession(classesType, startDate,4,true,
        false,examDate, HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,6,false,
        false,examDate, HomeWork(classesType, endDate)))

    examDate = "07.08.2022"
    indexOfDay = Calendar.SUNDAY
    classesType = ClassesTypes.PHYSICAL_EDUCATION
    this[indexOfDay].add(Lession(classesType, startDate,1,true,
        true,examDate, HomeWork(classesType, endDate)))
}