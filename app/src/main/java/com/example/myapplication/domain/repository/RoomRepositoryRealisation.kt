package com.example.myapplication.domain.repository

import androidx.lifecycle.LiveData
import com.example.myapplication.data.db.Dao
import com.example.myapplication.data.db.model.Card


class RoomRepositoryRealisation(private val dao: Dao): RoomRepository {
    override val allCards: LiveData<List<Card>>
        get() = dao.getAllCards()

    override suspend fun insertCard(card: Card) {
        dao.insertCard(card)
    }

    override suspend fun deleteCard(id: Long) {
        dao.delete(id)
    }


}