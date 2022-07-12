package com.edycation.note.journal.school.children.schooldiary.view.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edycation.note.journal.school.children.schooldiary.databinding.FragmentHomeBinding
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseFragment
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.HOME_FRAGMENT_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.convertDayToIndex
import com.edycation.note.journal.school.children.schooldiary.utils.convertIntToDecadeString
import com.edycation.note.journal.school.children.schooldiary.utils.convertIntToUnitString
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.list.HomeworkListPageAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin
import java.util.*

class HomeFragment:
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    /** Задание переменных */ //region
    // ViewModel
    private lateinit var viewModel: HomeFragmentViewModel
    // ShowResultFilmFragmentScope
    private lateinit var showHomeFragmentScope: Scope
    // Навигационные кнопки
    private lateinit var classesButton: ImageView
    // Класс с настройками для получения текущей даты
    private val settings: Settings = getKoin().get()
    // Paging 3.0
    private lateinit var homeworkRecyclerView: RecyclerView
    private lateinit var homeworkListPageAdapter: HomeworkListPageAdapter
    // Переменные для табло времени до экзамена
    private lateinit var decadeDays: TextView
    private lateinit var unitDays: TextView
    private lateinit var decadeHours: TextView
    private lateinit var unitHours: TextView
    private lateinit var decadeMinuts: TextView
    private lateinit var unitMinuts: TextView
    // newInstance для данного класса
    companion object {
        fun newInstance(): HomeFragment = HomeFragment()
    }
    //endregion

    /** Работа со Scope */ //region
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Задание Scope для данного фрагмента
        showHomeFragmentScope = getKoin().getOrCreateScope(
            HOME_FRAGMENT_SCOPE, named(HOME_FRAGMENT_SCOPE)
        )
    }
    override fun onDetach() {
        // Удаление скоупа для данного фрагмента
        showHomeFragmentScope.close()
        super.onDetach()
    }
    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel
        initViewModel()
        // Инициализация навигационных кнопок
        initNavigaionsButtons()
        // Инициализация списка домашних заданий
        initHomework()
        // Инициализация переменных для табло времени до экзамена
        initTimeUntilExams()
    }

    // Инициализация ViewModel
    private fun initViewModel() {
        val _viewModel: HomeFragmentViewModel by showHomeFragmentScope.inject()
        viewModel = _viewModel
        // Подписка на ViewModel
        this.viewModel.subscribe().observe(viewLifecycleOwner) { renderData(it) }
        // Загрузка данных
        viewModel.getData(settings.currentData.get(Calendar.DAY_OF_WEEK).convertDayToIndex())
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
                // Запуск получения данных для Paging 3.0 и их отображение
                lifecycleScope.launch {
                    viewModel.lession.collectLatest { pagedData ->
                        homeworkListPageAdapter.submitData(pagedData)
                    }
                }
            }
            is AppState.SuccessTime -> {
                // Отображение времени до экзамена (сдачи домашней работы)
                decadeDays.text = appState.examTime.days.convertIntToDecadeString()
                unitDays.text = appState.examTime.days.convertIntToUnitString()
                decadeHours.text = appState.examTime.hours.convertIntToDecadeString()
                unitHours.text = appState.examTime.hours.convertIntToUnitString()
                decadeMinuts.text = appState.examTime.minuts.convertIntToDecadeString()
                unitMinuts.text = appState.examTime.minuts.convertIntToUnitString()
            }
            is AppState.Loading -> {
                // Изменение внешнего вида фрагмента
            }
            is AppState.Error -> {
                Toast.makeText(requireContext(), appState.error.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    // Инициализация навигационных кнопок
    private fun initNavigaionsButtons() {
        classesButton = binding.footerClassesButton
        classesButton.setOnClickListener {
            viewModel.router.navigateTo(viewModel.screens.classesScreen())
        }
    }

    // Инициализация списка домашних заданий по технологии Paging 3.0
    private fun initHomework() {
        homeworkRecyclerView = binding.homeworkContent
        homeworkRecyclerView.layoutManager = LinearLayoutManager(requireContext(),
            LinearLayoutManager.HORIZONTAL, false)
        homeworkListPageAdapter = HomeworkListPageAdapter(requireContext())
        homeworkRecyclerView.adapter = homeworkListPageAdapter
    }

    // Инициализация переменных для табло времени до экзамена
    private fun initTimeUntilExams() {
        // Инициализация переменных для табло времени до экзамена
        decadeDays = binding.examsTimeDaysDecade
        unitDays = binding.examsTimeDaysUnits
        decadeHours = binding.examsTimeHoursDecade
        unitHours = binding.examsTimeHoursUnits
        decadeMinuts = binding.examsTimeMinutesDecade
        unitMinuts = binding.examsTimeMinutesUnits
    }
}