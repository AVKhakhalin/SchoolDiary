package com.edycation.note.journal.school.children.schooldiary.view.fragments.home

import android.content.Context
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import com.edycation.note.journal.school.children.schooldiary.databinding.FragmentHomeBinding
import com.edycation.note.journal.school.children.schooldiary.model.base.BaseFragment
import com.edycation.note.journal.school.children.schooldiary.model.data.AppState
import com.edycation.note.journal.school.children.schooldiary.utils.HOME_FRAGMENT_SCOPE
import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.ClassesFragmentViewModel
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent
import org.koin.java.KoinJavaComponent.getKoin

class HomeFragment:
    BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate) {
    /** Задание переменных */ //region
    // ViewModel
    private lateinit var viewModel: HomeFragmentViewModel
    // ShowResultFilmFragmentScope
    private lateinit var showHomeFragmentScope: Scope
    // Навигационные кнопки
    private lateinit var classesButton: ImageView
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
    }

    // Инициализация ViewModel
    private fun initViewModel() {
        val _viewModel: HomeFragmentViewModel by showHomeFragmentScope.inject()
        viewModel = _viewModel
        // Подписка на ViewModel
        this.viewModel.subscribe().observe(viewLifecycleOwner) { renderData(it) }
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
        classesButton = binding.footerClassesButton
        classesButton.setOnClickListener {
            viewModel.router.navigateTo(viewModel.screens.classesScreen())
        }
    }
}