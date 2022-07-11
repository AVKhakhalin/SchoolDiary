package com.edycation.note.journal.school.children.schooldiary.utils

import com.edycation.note.journal.school.children.schooldiary.R
import com.edycation.note.journal.school.children.schooldiary.model.data.ClassesDate
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
fun ClassesDate.getClassesStartTime(position: Int, isAdditional: Boolean): Calendar {
    val calendarStart: Calendar = Calendar.getInstance()
    val beginDay: Int = this.day
    val beginMonth: Int = this.month
    val beginYear: Int = this.year
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
            resourcesProviderImpl.getString(R.string.homework_description_hystory)
        ClassesTypes.PHYSICAL_EDUCATION ->
            resourcesProviderImpl.getString(R.string.homework_description_physical_education)
        ClassesTypes.LITERATURE ->
            resourcesProviderImpl.getString(R.string.homework_description_literature)
        ClassesTypes.PHYSICS ->
            resourcesProviderImpl.getString(R.string.homework_description_physics)
        ClassesTypes.MATHEMATICS ->
            resourcesProviderImpl.getString(R.string.homework_description_mathematics)
        ClassesTypes.BIOLOGY ->
            resourcesProviderImpl.getString(R.string.homework_description_biology)
        ClassesTypes.RUSSIA_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.homework_description_russia_language)
        ClassesTypes.ALGEBRA ->
            resourcesProviderImpl.getString(R.string.homework_description_algebra)
        ClassesTypes.GEOGRAPHY ->
            resourcesProviderImpl.getString(R.string.homework_description_geography)
        ClassesTypes.MUSIC -> resourcesProviderImpl.getString(R.string.homework_description_music)
        ClassesTypes.GEOMETRY ->
            resourcesProviderImpl.getString(R.string.homework_description_geometry)
        ClassesTypes.ASTRONOMY ->
            resourcesProviderImpl.getString(R.string.homework_description_astronomy)
        ClassesTypes.ENGLISH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.homework_description_english_language)
        ClassesTypes.HISTORY_OF_RUSSIA ->
            resourcesProviderImpl.getString(R.string.homework_description_history_of_russia)
        ClassesTypes.INFORMATICS ->
            resourcesProviderImpl.getString(R.string.homework_description_informatics)
        ClassesTypes.GENERAL_HISTORY ->
            resourcesProviderImpl.getString(R.string.homework_description_general_history)
        ClassesTypes.FRENCH_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.homework_description_french_language)
        ClassesTypes.GERMAN_LANGUAGE ->
            resourcesProviderImpl.getString(R.string.homework_description_german_language)
        ClassesTypes.NO -> ""
        else -> ""
    }
}

// Установка экзаменационной даты из String
fun String.getExamDateClassesDate(): ClassesDate {
    val date: Array<String> = this.split(".", "/", "|", "\\", " ").toTypedArray()
    val examDate: ClassesDate = if (date.size != 3) ClassesDate(0, 0,0)
                                else ClassesDate(if (date[0].isNotEmpty()) date[0].toInt() else 0,
                                                 if (date[1].isNotEmpty()) date[1].toInt() else 0,
                                                 if (date[2].isNotEmpty()) date[2].toInt() else 0)
    return examDate
}

// Получение даты экзамена предмета по его типу ClassesTypes
fun ClassesTypes.getExamDateString(): String {
    return when(this) {
        ClassesTypes.HISTORY -> "01.08.2022"
        ClassesTypes.PHYSICAL_EDUCATION -> "02.08.2022"
        ClassesTypes.LITERATURE -> "03.08.2022"
        ClassesTypes.PHYSICS -> "04.08.2022"
        ClassesTypes.MATHEMATICS -> "05.08.2022"
        ClassesTypes.BIOLOGY -> "06.08.2022"
        ClassesTypes.RUSSIA_LANGUAGE -> "07.08.2022"
        ClassesTypes.ALGEBRA -> "08.08.2022"
        ClassesTypes.GEOGRAPHY -> "09.08.2022"
        ClassesTypes.MUSIC -> "10.08.2022"
        ClassesTypes.GEOMETRY -> "11.08.2022"
        ClassesTypes.ASTRONOMY -> "12.08.2022"
        ClassesTypes.ENGLISH_LANGUAGE -> "13.08.2022"
        ClassesTypes.HISTORY_OF_RUSSIA -> "14.08.2022"
        ClassesTypes.INFORMATICS -> "15.08.2022"
        ClassesTypes.GENERAL_HISTORY -> "16.08.2022"
        ClassesTypes.SOCIAL_SCIENCE -> "17.08.2022"
        ClassesTypes.FRENCH_LANGUAGE -> "18.08.2022"
        ClassesTypes.GERMAN_LANGUAGE -> "19.08.2022"
        ClassesTypes.NO -> ""
    }
}

// Установка текущего расписания
fun Array<MutableList<Lession>>.initiateClasses() {
    val startDate: ClassesDate = START_CLASSES_DATE
    val endDate: ClassesDate = END_CLASSES_DATE
    var indexOfDay: Int = StudyDayOfWeek.MONDAY.ordinal
    var classesType: ClassesTypes = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.FRENCH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GEOGRAPHY
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.TUESDAY.ordinal
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MUSIC
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.FRENCH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.WEDNESDAY.ordinal
    classesType = ClassesTypes.INFORMATICS
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.MATHEMATICS
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.LITERATURE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICS
    this[indexOfDay].add(Lession(classesType, startDate,6,true,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.THURSDAY.ordinal
    classesType = ClassesTypes.MUSIC
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GEOGRAPHY
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ALGEBRA
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.BIOLOGY
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GERMAN_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,5,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GENERAL_HISTORY
    this[indexOfDay].add(Lession(classesType, startDate,6,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICAL_EDUCATION
    this[indexOfDay].add(Lession(classesType, startDate,7,true,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.FRIDAY.ordinal
    classesType = ClassesTypes.SOCIAL_SCIENCE
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.HISTORY_OF_RUSSIA
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.PHYSICS
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GERMAN_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,4,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.INFORMATICS
    this[indexOfDay].add(Lession(classesType, startDate,5,true,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,7,true,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.SATURDAY.ordinal
    classesType = ClassesTypes.BIOLOGY
    this[indexOfDay].add(Lession(classesType, startDate,1,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ENGLISH_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,2,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.GENERAL_HISTORY
    this[indexOfDay].add(Lession(classesType, startDate,3,false,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.ASTRONOMY
    this[indexOfDay].add(Lession(classesType, startDate,4,true,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))
    classesType = ClassesTypes.RUSSIA_LANGUAGE
    this[indexOfDay].add(Lession(classesType, startDate,6,false,
        false, classesType.getExamDateString(), HomeWork(classesType, endDate)))

    indexOfDay = StudyDayOfWeek.SUNDAY.ordinal
    classesType = ClassesTypes.PHYSICAL_EDUCATION
    this[indexOfDay].add(Lession(classesType, startDate,1,true,
        true, classesType.getExamDateString(), HomeWork(classesType, endDate)))
}

// Конвертер дня недели из ClassesTypes в индекс StudyDayOfWeek
fun Int.convertDayToIndex(): Int {
    return when(this) {
        Calendar.MONDAY -> 0
        Calendar.TUESDAY -> 1
        Calendar.WEDNESDAY -> 2
        Calendar.THURSDAY -> 3
        Calendar.FRIDAY -> 4
        Calendar.SATURDAY -> 5
        Calendar.SUNDAY -> 6
        else -> -1
    }
}

fun Long.dayEndingCreate(): String {
    /** Исходные данные */ //region
    // Получение доступа к ресурсам
    val resourcesProviderImpl: ResourcesProvider = getKoin().get()
    //endregion

    var numberString: String = this.toString()
    numberString = numberString[numberString.length - 1].toString()
    return when(numberString.toInt()) {
        1 -> resourcesProviderImpl.getString(R.string.days_variation_one)
        in 2..4 -> resourcesProviderImpl.getString(R.string.days_variation_two)
        else -> resourcesProviderImpl.getString(R.string.days_variation_three)
    }
}