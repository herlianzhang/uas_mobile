package com.example.uas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val rep: MainRepository
) : ViewModel() {
    val albums = rep.albums

    fun insertAlbum(albums: List<Album>) {
        viewModelScope.launch(Dispatchers.IO) {
            rep.insertAlbum(albums)
        }
    }

    fun deleteAlbum(album: Album) {
        viewModelScope.launch(Dispatchers.IO) {
            rep.deleteAlbum(album)
        }
    }
}