package com.fero.juaraandroid.ui.detail.tvshow

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.data.source.local.entity.TvShowEntity
import com.fero.juaraandroid.vo.Resource

class DetailTvShowViewModel(private val movieTvShowRepository: MovieTvShowRepository) : ViewModel() {

    val tvShowId = MutableLiveData<Int>()

    fun setSelectedTvShow(tvShow: Int){
        this.tvShowId.value = tvShow
    }

    var getDetailTvShow: LiveData<Resource<TvShowEntity>> = Transformations.switchMap(tvShowId){ tvShowId ->
        movieTvShowRepository.getDetailTvShow(tvShowId)
    }

    fun setFavorite(){
        val favoriteResource = getDetailTvShow.value
        if (favoriteResource != null){
            val favoriteTvShow = favoriteResource.data

            if (favoriteTvShow != null){
                val state = !favoriteTvShow.isFavorite
                movieTvShowRepository.setFavoriteTvShow(favoriteTvShow, state)
            }
        }
    }

//    fun getDetailTvShow(tv_id: Int): LiveData<Resource<TvShowEntity>> =
//        movieTvShowRepository.getDetailTvShow(tv_id)

}

