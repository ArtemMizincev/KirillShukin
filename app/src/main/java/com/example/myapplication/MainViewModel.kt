package com.example.myapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.data.db.AppDatabase
import com.example.myapplication.data.db.model.Card
import com.example.myapplication.domain.repository.RoomRepositoryRealisation
import com.example.myapplication.utils.REPOSITORY
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application): AndroidViewModel(application) {

    fun delete(id: Long) = viewModelScope.launch(Dispatchers.IO) {
        REPOSITORY.deleteCard(id)
    }


    private val context = application


    fun initDatabase() {
        val dao = AppDatabase.getInstance(context).getDao()
        REPOSITORY = RoomRepositoryRealisation(dao)
    }

    fun getAllNotes(): LiveData<List<Card>>{
        return REPOSITORY.allCards
    }


}