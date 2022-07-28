package com.example.notes.data

import com.example.notes.models.NoteDataModel

class NoteDataSource {
    fun loadNotes():List<NoteDataModel> {
        return listOf(
            NoteDataModel(title = "first note", description = "Heyyaa folks hows sup") ,
            NoteDataModel(title = "second note", description = "Heyyaa folks hosdsdsws sup")

        )
    }
}