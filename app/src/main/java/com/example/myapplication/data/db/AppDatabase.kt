package com.example.myapplication.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.model.Card


@Database(
    version = 1,
    entities = [
        Card::class
    ]
)
abstract class AppDatabase: RoomDatabase() {

    abstract fun  getDao(): Dao

    companion object {
        private var database: AppDatabase? = null

        @Synchronized
        fun getInstance(context: Context): AppDatabase {
            return if (database == null){
                database = Room.databaseBuilder(context, AppDatabase::class.java, "db").build()
                database as AppDatabase
            }else{
                database as AppDatabase
            }
        }
    }

}