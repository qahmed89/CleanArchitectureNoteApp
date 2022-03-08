package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

sealed class NotesEvent {
    data class Order (val noteOrder: NoteOrder) : NotesEvent()
    data class DeleteNotes(val note : Note) : NotesEvent()
    object RestoreNotes : NotesEvent()
    object ToggleOrderSection : NotesEvent()
}