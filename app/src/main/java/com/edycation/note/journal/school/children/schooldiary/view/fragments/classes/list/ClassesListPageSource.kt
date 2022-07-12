package com.edycation.note.journal.school.children.schooldiary.view.fragments.classes.list

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.edycation.note.journal.school.children.schooldiary.model.data.Lession
import com.edycation.note.journal.school.children.schooldiary.repository.settings.Settings
import com.edycation.note.journal.school.children.schooldiary.utils.INITIAL_PAGE_NUMBER
import com.edycation.note.journal.school.children.schooldiary.utils.MAX_ELEMENTS_ON_PAGE
import org.koin.java.KoinJavaComponent

class ClassesListPageSource(
    private val dayIndex: Int,
    private val settings: Settings = KoinJavaComponent.getKoin().get()
): PagingSource<Int, Lession>() {
    override fun getRefreshKey(state: PagingState<Int, Lession>): Int? {
        val anchorPosition = state.anchorPosition ?: return null
        val anchorPage = state.closestPageToPosition(anchorPosition) ?: return null
        return anchorPage.prevKey?.plus(1) ?: anchorPage.nextKey?.minus(1)
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Lession> {
        val pageNumber = params.key ?: INITIAL_PAGE_NUMBER
        val lessions: List<Lession> =
            settings.getListLesions(dayIndex, pageNumber, MAX_ELEMENTS_ON_PAGE)
        val nextPageNumber = if (lessions.isEmpty()) null else pageNumber + 1 * MAX_ELEMENTS_ON_PAGE
        val prevPageNumber = if (pageNumber > 1) pageNumber - 1 * MAX_ELEMENTS_ON_PAGE else null
        return LoadResult.Page(lessions, prevPageNumber, nextPageNumber)
    }
}