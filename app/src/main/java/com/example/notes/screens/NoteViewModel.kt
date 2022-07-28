package com.example.notes.screens

import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import com.example.notes.data.NoteDataSource
import com.example.notes.models.NoteDataModel

class NoteViewModel:ViewModel() {
    private var noteList = mutableStateListOf<NoteDataModel>()
    init {
        noteList.addAll(NoteDataSource().loadNotes())
    }
    fun addNote(note:NoteDataModel){
        noteList.add(note)
    }
    fun removeNote(note: NoteDataModel){
        noteList.remove(note)
    }
    fun getAllNotes(): List<NoteDataModel>{
        return noteList
    }

}