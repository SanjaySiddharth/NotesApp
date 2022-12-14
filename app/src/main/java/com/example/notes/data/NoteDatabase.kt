package com.example.notes.data



import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.notes.models.NoteDataModel

@Database(entities = [NoteDataModel::class], version = 1, exportSchema = false)
abstract class NoteDatabase:RoomDatabase() {
    abstract fun noteDao():NoteDatabaseDao


}