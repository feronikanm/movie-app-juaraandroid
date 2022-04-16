package com.fero.juaraandroid.ui.favorite.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.paging.PagedList
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.data.source.local.entity.MovieEntity

class FavoriteMovieViewModel(private val movieTvShowRepository: MovieTvShowRepository) : ViewModel() {

    fun getFavoriteMovie(): LiveData<PagedList<MovieEntity>> = movieTvShowRepository.getFavoriteMovie()

//    lateinit var livePagedMovieEntity : LiveData<PagedList<MovieEntity>>
//    val onProgressView = MutableLiveData<Boolean>()
//
//    fun setFavoriteMovie(data: MovieEntity, favorite: Boolean) {
//        movieTvShowRepository.setFavoriteMovie(data, favorite)
//    }
//
//    fun deleteMovie(movieId: Int) {
//        movieTvShowRepository.deleteMovie(movieId)
//    }
//
//    fun nukeMovie() {
//        movieTvShowRepository.nukeMovie()
//    }
//
//    fun getFavoriteMovies() {
//        onProgressView.value = true
//        livePagedMovieEntity = movieTvShowRepository.getFavoriteMovie()
//        onProgressView.value = false
//    }
}