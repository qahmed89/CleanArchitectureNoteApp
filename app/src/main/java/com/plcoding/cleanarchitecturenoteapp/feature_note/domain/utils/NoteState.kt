package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.utils

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note

data class NoteState (
    val notes : List<Note>  = emptyList(),
    val noteOrder: NoteOrder = NoteOrder.Date(OrderType.Descending),
    val isOrderSectionVisible : Boolean = false
        ){
}