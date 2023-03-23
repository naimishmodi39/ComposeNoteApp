package com.example.jetpackcompose.feature_note.domain.use_case

data class NoteUseCase(
    val getNoteUseCase: GetNoteUseCase,
    val deleteNoteUseCase: DeleteNoteUseCase,
    val addNoteUseCase: AddNoteUseCase,
) {
}