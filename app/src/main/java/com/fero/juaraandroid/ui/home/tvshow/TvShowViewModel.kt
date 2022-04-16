package com.fero.juaraandroid.ui.home.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.data.source.local.entity.TvShowEntity
import com.fero.juaraandroid.vo.Resource

class TvShowViewModel(private val movieTvShowRepository: MovieTvShowRepository) : ViewModel() {

    fun getTvShow() : LiveData<Resource<List<TvShowEntity>>> = movieTvShowRepository.getAllTvShows()
}