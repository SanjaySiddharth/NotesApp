package com.example.notes.data

import androidx.room.*
import com.example.notes.models.NoteDataModel
import kotlinx.coroutines.flow.Flow

@Dao
interface NoteDatabaseDao {

    @Query("SELECT * from notes_db")
     fun getNotes(): Flow<List<NoteDataModel>>

    @Query("select * from notes_db where id=:id")
    suspend fun getNoteById(id:String):NoteDataModel

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(note:NoteDataModel)

    @Update(onConflict = OnConflictStrategy.REPLACE)
    suspend fun update(note:NoteDataModel)

    @Query("Delete * from note_db")
    suspend fun deleteAllItems()

    @Delete
    suspend fun deleteNote(note:NoteDataModel)

}