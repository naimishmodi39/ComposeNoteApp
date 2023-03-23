package com.example.jetpackcompose.feature_note.domain.repository

import com.example.jetpackcompose.feature_note.domain.model.Note
import kotlinx.coroutines.flow.Flow

interface NoteRepository {


    fun getNotes():Flow<List<Note>>

    suspend fun getNotesById(id:Int):Note?

   suspend fun insertedNote(note:Note)

   suspend fun deleteNote(note:Note)



}