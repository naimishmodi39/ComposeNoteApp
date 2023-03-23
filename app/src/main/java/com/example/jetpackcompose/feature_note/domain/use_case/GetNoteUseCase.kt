package com.example.jetpackcompose.feature_note.domain.use_case

import com.example.jetpackcompose.feature_note.domain.model.Note
import com.example.jetpackcompose.feature_note.domain.repository.NoteRepository
import com.example.jetpackcompose.feature_note.domain.util.NoteOrder
import com.example.jetpackcompose.feature_note.domain.util.OrderType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class GetNoteUseCase(private val repository: NoteRepository) {

    operator fun invoke(
        noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending)
    ):Flow<List<Note>>{

        return repository.getNotes().map { note ->
            when(noteOrder.orderType){
                is OrderType.Ascending ->{
                    when(noteOrder){
                        is NoteOrder.Date-> note.sortedBy { it.timestamp }

                        is NoteOrder.Title-> note.sortedBy { it.title.lowercase() }

                        is NoteOrder.Color-> note.sortedBy { it.color }

                    }
                }
                is OrderType.Descending ->{
                    when(noteOrder) {
                        is NoteOrder.Date -> note.sortedByDescending { it.timestamp }

                        is NoteOrder.Title -> note.sortedByDescending { it.title.lowercase() }

                        is NoteOrder.Color -> note.sortedByDescending { it.color }
                    }
                }
            }
        }
    }
}