package victorteka.github.io.tmdbapp.data.repository

import androidx.paging.PagingSource
import victorteka.github.io.tmdbapp.data.api.ApiHelper
import victorteka.github.io.tmdbapp.data.models.upcoming.Result
import java.lang.Exception
import javax.inject.Inject

class PopularMovieRepo @Inject constructor(private val apiHelper: ApiHelper)
    :PagingSource<Int, Result>(){
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        try {
            val currentLoadingPageKey = params.key ?: 1
            val response = apiHelper.getPopular()
            val responseResult = mutableListOf<Result>()
            val result = response.body()?.results ?: emptyList()
            responseResult.addAll(result)
            val prevKey = if (currentLoadingPageKey == 1) null else currentLoadingPageKey - 1

            return LoadResult.Page(
                responseResult,
                prevKey,
                currentLoadingPageKey.plus(1)
            )
        } catch (e: Exception) {
            return LoadResult.Error(e)
        }
    }

}