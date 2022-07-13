package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.list

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.edycation.note.journal.school.children.schooldiary.databinding.ClassesListRecyclerviewItemStandartBinding
import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.utils.TIME_FORMAT
import java.text.SimpleDateFormat
import java.util.*

class ClassesListPageAdapter(context: Context):
    PagingDataAdapter<Lession, ClassesViewHolder>(LessionDiffItemCallback) {
    /** Исходные данные */ //region
    private val layoutInflater: LayoutInflater = LayoutInflater.from(context)
    //endregion

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClassesViewHolder {
        return ClassesViewHolder(ClassesListRecyclerviewItemStandartBinding.inflate(
            layoutInflater, parent, false))
    }

    override fun onBindViewHolder(holder: ClassesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    override fun getItemViewType(position: Int): Int {
        getItem(position)?.let {
            if (it.isAdditional) return 1
            if (it.isOpenIn) return 2
        }
        return 0
    }
}

class ClassesViewHolder(
    private val binding: ClassesListRecyclerviewItemStandartBinding
): RecyclerView.ViewHolder(binding.root) {
    @SuppressLint("SetTextI18n")
    fun bind(lession: Lession?) {
        lession?.let {
            // Установка названия предмета для домашнего задания
            binding.classesInfoClassTitle.text = lession.name
            // Установка ФИО учителя
            binding.classesInfoTeacherName.text = lession.teacherName
            // Установка времени занятия
            val startClassTime: Calendar = lession.startTime
            val startTimeString: String = SimpleDateFormat(TIME_FORMAT,
                Locale.getDefault()).format(startClassTime.time)
            val endClassTime: Calendar = lession.endTime
            val endTimeString: String = SimpleDateFormat(TIME_FORMAT,
                Locale.getDefault()).format(endClassTime.time)
            binding.classTime.text = "$startTimeString-$endTimeString"
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
                && oldItem.endDate.year == newItem.endDate.year
                && oldItem.endDate.month == newItem.endDate.month
                && oldItem.endDate.day == newItem.endDate.day
                && oldItem.homeWork.description == newItem.homeWork.description
                && oldItem.homeWork.examDate.year == newItem.homeWork.examDate.year
                && oldItem.homeWork.examDate.month == newItem.homeWork.examDate.month
                && oldItem.homeWork.examDate.day == newItem.homeWork.examDate.day
    }
}