package com.fero.juaraandroid.ui.home.movie

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.data.source.local.entity.MovieEntity
import com.fero.juaraandroid.vo.Resource

class MovieViewModel (private val movieTvShowRepository: MovieTvShowRepository): ViewModel() {

    fun getMovies() : LiveData<Resource<List<MovieEntity>>> = movieTvShowRepository.getAllMovies()
}