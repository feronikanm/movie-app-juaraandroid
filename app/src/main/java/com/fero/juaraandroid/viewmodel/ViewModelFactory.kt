package com.fero.juaraandroid.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.di.Injection
import com.fero.juaraandroid.ui.detail.movie.DetailMovieViewModel
import com.fero.juaraandroid.ui.detail.tvshow.DetailTvShowViewModel
import com.fero.juaraandroid.ui.favorite.movie.FavoriteMovieViewModel
import com.fero.juaraandroid.ui.favorite.tvshow.FavoriteTvShowViewModel
import com.fero.juaraandroid.ui.home.movie.MovieViewModel
import com.fero.juaraandroid.ui.home.tvshow.TvShowViewModel

class ViewModelFactory private constructor(private var movieTvShowRepository: MovieTvShowRepository) : ViewModelProvider.NewInstanceFactory() {

    companion object {
        @Volatile
        private var instance: ViewModelFactory? = null

        fun getInstance(context: Context): ViewModelFactory =
            instance ?: synchronized(this) {
                instance ?: ViewModelFactory(Injection.provideRepository(context)).apply {
                    instance = this
                }
            }
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>) : T{
        when{
            modelClass.isAssignableFrom(MovieViewModel::class.java) -> {
                return MovieViewModel(movieTvShowRepository) as T
            }
            modelClass.isAssignableFrom(TvShowViewModel::class.java) -> {
                return TvShowViewModel(movieTvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailMovieViewModel::class.java) -> {
                return DetailMovieViewModel(movieTvShowRepository) as T
            }
            modelClass.isAssignableFrom(DetailTvShowViewModel::class.java) -> {
                return DetailTvShowViewModel(movieTvShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteMovieViewModel::class.java) -> {
                return FavoriteMovieViewModel(movieTvShowRepository) as T
            }
            modelClass.isAssignableFrom(FavoriteTvShowViewModel::class.java) -> {
                return FavoriteTvShowViewModel(movieTvShowRepository) as T
            }
            else -> throw Throwable("Unknown ViewModel class: " + modelClass.name)
        }
    }
}