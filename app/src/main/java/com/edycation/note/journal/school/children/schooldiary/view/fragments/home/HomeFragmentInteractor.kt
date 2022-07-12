package com.edycation.note.journal.school.children.schooldiary.view.fragments.home

import com.edycation.note.journal.school.children.schooldiary.model.base.Interactor
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.model.data.ExamTime
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.DELTA_EXAMS
import com.edycation.note.journal.school.children.schooldiary.utils.MILLISECONDS_IN_DAY
import com.edycation.note.journal.school.children.schooldiary.utils.setNewDate
import org.koin.java.KoinJavaComponent
import java.util.*
import java.util.concurrent.TimeUnit

class HomeFragmentInteractor: Interactor<AppState> {
    /** Исходные данные */ //region
    private val settings: Settings = KoinJavaComponent.getKoin().get()
    //endregion

    override suspend fun getData(dayIndex: Int): AppState {
        val appState: AppState = AppState.Success(settings.classes[dayIndex])
        return appState
    }

    fun getExamTime(dayIndex: Int): AppState {
        val currentTime: Calendar = Calendar.getInstance()
        currentTime.time = Date()
        var comparableTime: Calendar = Calendar.getInstance()
        settings.classes[dayIndex][0].endDate.also {
            // !!! месяц нужно занижать на 1 единицу
            comparableTime.set(it.year, it.month - 1, it.day)
        }
        return if ((currentTime.timeInMillis >=
                    settings.classes[dayIndex][0].startTime.timeInMillis) &&
            (currentTime.timeInMillis <= comparableTime.timeInMillis)) {
            var currentLessionIndex: Int = 0
            for (index in 0 until settings.classes[dayIndex].size) {
                comparableTime = settings.classes[dayIndex][index].startTime
                comparableTime.setNewDate(currentTime)
                if (currentTime.timeInMillis > comparableTime.timeInMillis)
                    currentLessionIndex = index
            }
            var daysUntilExam: Long = 0
            var hoursUntilExam: Long = 0
            var minutesUntilExam: Long = 0
            var diff: Long = MILLISECONDS_IN_DAY * DELTA_EXAMS - currentTime.timeInMillis +
                    settings.classes[dayIndex][currentLessionIndex].startTime.timeInMillis
            if (diff > 0) {
                daysUntilExam = TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS)
                diff -= TimeUnit.MILLISECONDS.convert(daysUntilExam, TimeUnit.DAYS)
                if (diff > 0) {
                    hoursUntilExam = TimeUnit.HOURS.convert(diff, TimeUnit.MILLISECONDS)
                    diff -= TimeUnit.MILLISECONDS.convert(hoursUntilExam, TimeUnit.HOURS)
                    if (diff > 0)
                        minutesUntilExam = TimeUnit.MINUTES.convert(diff, TimeUnit.MILLISECONDS)
                }
            }
            AppState.SuccessTime(
                ExamTime(daysUntilExam.toInt(), hoursUntilExam.toInt(),
                    minutesUntilExam.toInt()))
        } else {
            AppState.SuccessTime(ExamTime(0,0,0))
        }
    }
}