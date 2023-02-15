package com.example.myapplication.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import androidx.room.Dao
import com.example.myapplication.data.db.model.Card


@Dao
interface Dao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertCard(card: Card)

    @Query("DELETE FROM cards WHERE Id = :id")
    suspend fun delete(id: Long)

    @Query("SELECT * from cards")
    fun getAllCards(): LiveData<List<Card>>

}