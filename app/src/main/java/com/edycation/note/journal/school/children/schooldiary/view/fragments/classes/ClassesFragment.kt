package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.Toast
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.edycation.note.journal.school.children.schooldiary.databinding.FragmentClassesBinding
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseFragment
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.CLASSES_FRAGMENT_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.convertDayToIndex
import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.list.ClassesListPageAdapter
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.list.HomeworkListPageAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin
import java.util.*

class ClassesFragment:
    BaseFragment<FragmentClassesBinding>(FragmentClassesBinding::inflate) {
    /** Задание переменных */ //region
    // ViewModel
    private lateinit var viewModel: ClassesFragmentViewModel
    // ShowResultFilmFragmentScope
    private lateinit var showClassesFragmentScope: Scope
    // Навигационные кнопки
    private lateinit var homeButton: ImageView
    // Класс с настройками для получения текущей даты
    private val settings: Settings = getKoin().get()
    // newInstance для данного класса
    companion object {
        fun newInstance(): ClassesFragment = ClassesFragment()
    }
    //endregion

    /** Работа со Scope */ //region
    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Задание Scope для данного фрагмента
        showClassesFragmentScope = getKoin().getOrCreateScope(
            CLASSES_FRAGMENT_SCOPE, named(CLASSES_FRAGMENT_SCOPE)
        )
    }
    override fun onDetach() {
        // Удаление скоупа для данного фрагмента
        showClassesFragmentScope.close()
        super.onDetach()
    }
    //endregion

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Инициализация ViewModel
        initViewModel()
        // Инициализация навигационных кнопок
        initNavigaionsButtons()
    }

    // Инициализация ViewModel
    private fun initViewModel() {
        val _viewModel: ClassesFragmentViewModel by showClassesFragmentScope.inject()
        viewModel = _viewModel
        // Подписка на ViewModel
        this.viewModel.subscribe().observe(viewLifecycleOwner) { renderData(it) }
        // Загрузка данных
        viewModel.getData(settings.currentData.get(Calendar.DAY_OF_WEEK).convertDayToIndex())

        val recyclerView: RecyclerView = binding.classesRecyclerList
        recyclerView.layoutManager = LinearLayoutManager(
            requireContext(), LinearLayoutManager.VERTICAL, false)
        val classesListPageAdapter: ClassesListPageAdapter = ClassesListPageAdapter(requireContext())
        recyclerView.adapter = classesListPageAdapter

        lifecycleScope.launch {
            viewModel.lession.collectLatest { pagedData ->
                classesListPageAdapter.submitData(pagedData)
            }
        }
    }

    private fun renderData(appState: AppState) {
        when (appState) {
            is AppState.Success -> {
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
        homeButton = binding.footerHomeButton
        homeButton.setOnClickListener {
            viewModel.router.navigateTo(viewModel.screens.homeScreen())
        }
    }
}