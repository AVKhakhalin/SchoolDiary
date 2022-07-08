package com.edycation.note.journal.school.children.schooldiary.navigation

import com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.ClassesFragment
import com.edycation.note.journal.school.children.schooldiary.view.fragments.home.HomeFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

class AppScreensImpl: AppScreens {
    // Окно с домашней работой
    override fun homeScreen() = FragmentScreen {
        HomeFragment.newInstance()
    }

    // Окно с заданиями
    override fun classesScreen() = FragmentScreen {
        ClassesFragment.newInstance()
    }
}