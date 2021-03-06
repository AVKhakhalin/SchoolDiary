package com.edycation.note.journal.school.children.schooldiary.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.edycation.note.journal.school.children.schooldiary.R
import com.edycation.note.journal.school.children.schooldiary.databinding.ActivityMainBinding
import com.edycation.note.journal.school.children.schooldiary.navigation.BackButtonListener
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.MAIN_ACTIVITY_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.initiateClasses
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.androidx.AppNavigator
import org.koin.core.qualifier.named
import org.koin.core.scope.Scope
import org.koin.java.KoinJavaComponent.getKoin
import java.util.*

class MainActivity: AppCompatActivity() {
    /** Исходные данные */ //region
    // Binding
    private lateinit var binding: ActivityMainBinding
    // MainActivityScope
    private val mainActivityScope: Scope = getKoin().getOrCreateScope(
        MAIN_ACTIVITY_SCOPE, named(MAIN_ACTIVITY_SCOPE)
    )
    // ViewModel
    private lateinit var viewModel: MainViewModel
    // Навигация
    private val navigator = AppNavigator(this@MainActivity, R.id.fragments_container)
    private val navigatorHolder: NavigatorHolder = getKoin().get()
    // Текущий день
    private val settings: Settings = getKoin().get()
    //endregion

    override fun onDestroy() {
        // Удаление скоупа для данной активити
        mainActivityScope.close()
        super.onDestroy()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Установка текущей даты
        settings.currentData.time = Date()
        // Установка текущего расписания
        settings.classes.initiateClasses()
        // Подключение Binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        // Инициализация ViewModel
        initViewModel()
        // Отслеживание первого или последующего запусков MainActivity
        if (savedInstanceState != null) {
            // Установка текущего экрана приложения
            navigatorHolder.setNavigator(navigator)
        } else {
            // Установка начального экрана приложения
            viewModel.router.navigateTo(viewModel.screens.homeScreen())
        }

        // Отображение содержимого окна
        setContentView(binding.root)
    }

    // Инициализация ViewModel
    private fun initViewModel() {
        // Начальная установка ViewModel
        val viewModel: MainViewModel by mainActivityScope.inject()
        this.viewModel = viewModel
    }

    /** Методы для настройки навигатора */ //region
    override fun onResume() {
        super.onResume()
        // Установка навигатора
        navigatorHolder.setNavigator(navigator)
    }
    override fun onPause() {
        super.onPause()
        // Удаление навигатора
        navigatorHolder.removeNavigator()
    }
    override fun onBackPressed() {
        // Закрыть активити, если в настоящий момент открыт только один фрагмент
        if (supportFragmentManager.fragments.size == 1) finish()
        supportFragmentManager.fragments.forEach {
            if (it is BackButtonListener && it.backPressed()) {
                return
            }
        }
        viewModel.router.exit()
    }
    //endregion
}