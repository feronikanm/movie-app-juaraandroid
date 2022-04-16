package com.fero.juaraandroid.di

import android.content.Context
import com.fero.juaraandroid.data.MovieTvShowRepository
import com.fero.juaraandroid.data.source.local.LocalDataSource
import com.fero.juaraandroid.data.source.local.room.MovieTvShowDatabase
import com.fero.juaraandroid.data.source.remote.RemoteDataSource
import com.fero.juaraandroid.utils.AppExecutors

object Injection {

    fun provideRepository(context: Context) : MovieTvShowRepository{

        val database = MovieTvShowDatabase.getInstance(context)

        val remoteDataSource = RemoteDataSource.getInstance()
        val localDataSource = LocalDataSource.getInstance(database.movieTvShowDao())
        val appExecutors = AppExecutors()

        return MovieTvShowRepository.getInstance(remoteDataSource, localDataSource, appExecutors)
    }
}