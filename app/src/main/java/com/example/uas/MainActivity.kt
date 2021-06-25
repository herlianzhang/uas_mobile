package com.example.uas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uas.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), OnClickListener {

    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    private val adapter = AlbumAdapter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        initAdapter()
        initObserver()
        insertDummyData()
    }

    private fun initAdapter() {
        binding.myRecycleView.layoutManager = LinearLayoutManager(this)
        binding.myRecycleView.adapter = adapter
    }

    private fun initObserver() {
        viewModel.albums.observe(this) {
            adapter.submitList(it)
        }
    }

    private fun insertDummyData() {
        val list = listOf(
            Album(1, "Nama1", "2000-06-02 06:10:12.478437", "Country", 7378789, 5964000),
            Album(2, "Nama2", "2017-01-20 02:31:31.685155", "Hip Hop", 6654725, 4235000),
            Album(3, "Nama3", "2005-10-26 15:07:06.358500", "EDM", 10846762, 8919000),
            Album(4, "Nama4", "1985-12-21 12:39:53.869202", "Hip Hop", 18842857, 7579000),
            Album(5, "Nama5", "1986-07-02 21:18:26.560203", "Pop", 8354998, 8556000),
            Album(6, "Nama6", "1994-03-27 22:28:37.238300", "Rock", 530668, 911000),
            Album(7, "Nama7", "2000-03-02 05:25:09.954501", "EDM", 20660590, 8544000),
            Album(8, "Nama8", "2010-09-07 20:10:14.543097", "EDM", 14653410, 5468000),
            Album(9, "Nama9", "1998-07-11 22:47:00.205447", "Country", 29037830, 9617000),
            Album(10, "Nama10", "1991-11-24 09:15:33.286878", "Rock", 12414026, 9384000)

        )
        viewModel.insertAlbum(list)
    }

    override fun onDeleteAlbum(album: Album) {
        viewModel.deleteAlbum(album)
    }
}