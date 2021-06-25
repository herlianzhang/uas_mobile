package com.example.uas

import android.app.Application
import androidx.room.Room
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class MainModule {
    @Singleton
    @Provides
    fun provideAlbumDb(app: Application) =
        Room.databaseBuilder(app, AlbumDatabase::class.java, "album.db")
            .fallbackToDestructiveMigration().build()

    @Singleton
    @Provides
    fun provideAlbumDao(db: AlbumDatabase) = db.albumDao()
}