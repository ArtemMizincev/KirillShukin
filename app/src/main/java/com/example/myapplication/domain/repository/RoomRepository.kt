package com.example.myapplication.domain.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.db.model.Card


interface RoomRepository {


    val allCards: LiveData<List<Card>>

    suspend fun insertCard(card: Card)

    suspend fun deleteCard(id: Long)


}