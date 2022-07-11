package com.edycation.note.journal.school.children.schooldiary.view.fragments.home.list

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.edycation.note.journal.school.children.schooldiary.R
import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.dayEndingCreate
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProvider
import org.koin.java.KoinJavaComponent.getKoin
import java.util.*
import java.util.concurrent.TimeUnit

class HomeworkListRecyclerAdapter(private val lessions: List<Lession>):
    RecyclerView.Adapter<HomeworkListRecyclerAdapter.MyViewHolder>() {
    /** Исходные данные */ //region
    // Хранилище текущих данных
    private val settings: Settings = getKoin().get()
    // Получение доступа к ресурсам
    private val resourcesProviderImpl: ResourcesProvider = getKoin().get()
    //endregion

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val homeWorkTitle: TextView = itemView.findViewById(R.id.homework_item_title)
        val homeWorkDaysExist: TextView = itemView.findViewById(R.id.homework_item_days_left_text)
        val homeWorkDescription: TextView = itemView.findViewById(R.id.homework_item_description)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(parent.context).
        inflate(R.layout.homework_list_recyclerview_item, parent, false)
        return MyViewHolder(itemView)
    }

    @SuppressLint("SetTextI18n")
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        // Установка названия предмета для домашнего задания
        holder.homeWorkTitle.text = lessions[position].name
        // Установка дней до экзамена
        val examDate: Calendar = Calendar.getInstance()
        //!!! месяц нужно занижать на 1 единицу
        examDate.set(lessions[position].examDate.year, lessions[position].examDate.month - 1,
            lessions[position].examDate.day)
        val daysUntilExam: Long = TimeUnit.DAYS.convert(
            examDate.timeInMillis - Date().time, TimeUnit.MILLISECONDS)
        holder.homeWorkDaysExist.text = "$daysUntilExam ${daysUntilExam.dayEndingCreate()} " +
                resourcesProviderImpl.getString(R.string.days_remain)
        // Установка содержания домашнего задания
        holder.homeWorkDescription.text = lessions[position].homeWork.description
    }

    override fun getItemCount() = lessions.size
}