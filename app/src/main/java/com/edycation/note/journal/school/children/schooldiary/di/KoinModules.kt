package com.edycation.note.journal.school.children.schooldiary.di

import com.edycation.note.journal.school.children.schooldiary.navigation.AppScreens
import com.edycation.note.journal.school.children.schooldiary.navigation.AppScreensImpl
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.CICERONE_NAME
import com.edycation.note.journal.school.children.schooldiary.utils.CLASSES_FRAGMENT_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.HOME_FRAGMENT_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.MAIN_ACTIVITY_SCOPE
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProvider
import com.edycation.note.journal.school.children.schooldiary.utils.resources.ResourcesProviderImpl
import com.edycation.note.journal.school.children.schooldiary.view.activity.MainViewModel
import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.ClassesFragmentInteractor
import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.ClassesFragmentViewModel
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.HomeFragmentInteractor
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.HomeFragmentViewModel
import com.github.terrakok.cicerone.Cicerone
import com.github.terrakok.cicerone.NavigatorHolder
import com.github.terrakok.cicerone.Router
import org.koin.android.ext.koin.androidContext
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val application = module {

    // Локальное сохранение данных
    single<Settings> { Settings() }

    // Навигация между окнами
    single<Cicerone<Router>>(named(CICERONE_NAME)) { Cicerone.create() }
    single<NavigatorHolder> {
        get<Cicerone<Router>>(named(CICERONE_NAME)).getNavigatorHolder() }
    single<Router> { get<Cicerone<Router>>(named(CICERONE_NAME)).router }
    single<AppScreens> { AppScreensImpl() }

    // Вспомогательные классы:
    // Получение доступа к ресурсам
    single<ResourcesProvider> { ResourcesProviderImpl(androidContext()) }
}

val screens = module {
    // Scope для MainActivity
    scope(named(MAIN_ACTIVITY_SCOPE)) {
        viewModel {
            MainViewModel()
        }
    }

    // Scope для фрагмента с уроками
    scope(named(CLASSES_FRAGMENT_SCOPE)) {
        scoped {
            ClassesFragmentInteractor()
        }
        viewModel {
            ClassesFragmentViewModel(getScope(CLASSES_FRAGMENT_SCOPE).get())
        }
    }

    // Scope для фрагмента с домашними заданиями
    scope(named(HOME_FRAGMENT_SCOPE)) {
        scoped {
            HomeFragmentInteractor()
        }
        viewModel {
            HomeFragmentViewModel(getScope(HOME_FRAGMENT_SCOPE).get())
        }
    }
}
