package com.edycation.note.journal.school.children.schooldiary.view.fragments.home.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.edycation.note.journal.school.children.schooldiary.R
import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.utils.dayEndingCreate
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProvider
import org.koin.java.KoinJavaComponent
import java.util.*
import java.util.concurrent.TimeUnit

class HomeworkListPageAdapter(context: Context):
    PagingDataAdapter<Lession, HomeworkViewHolder>(LessionDiffItemCallback) {
    /** Исходные данные */ //region
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeworkViewHolder {
        return HomeworkViewHolder(layoutInflater.inflate(
            R.layout.homework_list_recyclerview_item, parent, false))
    }

    override fun onBindViewHolder(holder: HomeworkViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}

class HomeworkViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    /** Исходные данные */ //region
    // Получение доступа к ресурсам
    private val resourcesProviderImpl: ResourcesProvider = KoinJavaComponent.getKoin().get()
    //endregion

    @SuppressLint("SetTextI18n")
    fun bind(lession: Lession?) {
        lession?.let {
            val homeWorkTitle: TextView = itemView.findViewById(R.id.homework_item_title)
            val homeWorkDaysExist: TextView =
                itemView.findViewById(R.id.homework_item_days_left_text)
            val homeWorkDescription: TextView =
                itemView.findViewById(R.id.homework_item_description)

            // Установка названия предмета для домашнего задания
            homeWorkTitle.text = lession.name
            // Установка дней до экзамена
            val examDate: Calendar = Calendar.getInstance()
            //!!! месяц нужно занижать на 1 единицу
            examDate.set(lession.examDate.year, lession.examDate.month - 1,
                lession.examDate.day)
            val daysUntilExam: Long = TimeUnit.DAYS.convert(
                examDate.timeInMillis - Date().time, TimeUnit.MILLISECONDS)
            homeWorkDaysExist.text = "$daysUntilExam ${daysUntilExam.dayEndingCreate()} " +
                    resourcesProviderImpl.getString(R.string.days_remain)
            // Установка содержания домашнего задания
            homeWorkDescription.text = lession.homeWork.description
        }
    }
}

private object LessionDiffItemCallback: DiffUtil.ItemCallback<Lession>() {

    override fun areItemsTheSame(oldItem: Lession, newItem: Lession): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: Lession, newItem: Lession): Boolean {
        return oldItem.type == newItem.type
                && oldItem.startDate.year == newItem.startDate.year
                && oldItem.startDate.month == newItem.startDate.month
                && oldItem.startDate.day == newItem.startDate.day
                && oldItem.position == newItem.position
                && oldItem.isAdditional == newItem.isAdditional
                && oldItem.isOpenIn == newItem.isOpenIn
                && oldItem.homeWork.endDate.year == newItem.homeWork.endDate.year
                && oldItem.homeWork.endDate.month == newItem.homeWork.endDate.month
                && oldItem.homeWork.endDate.day == newItem.homeWork.endDate.day
                && oldItem.homeWork.description == newItem.homeWork.description
    }
}