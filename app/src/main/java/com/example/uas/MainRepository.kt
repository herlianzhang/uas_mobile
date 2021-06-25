package com.example.uas

import javax.inject.Inject

class MainRepository @Inject constructor(
    private val albumDao: AlbumDao,
    private val albumDatabase: AlbumDatabase
) {
    val albums = albumDao.getAllAlbum()

    fun insertAlbum(albums: List<Album>) {
        albumDatabase.runInTransaction {
            for (album in albums) {
                albumDao.insertAlbum(album)
            }
        }
    }

    fun deleteAlbum(album: Album) {
        albumDatabase.runInTransaction {
            albumDao.deleteAlbum(album)
        }
    }
}