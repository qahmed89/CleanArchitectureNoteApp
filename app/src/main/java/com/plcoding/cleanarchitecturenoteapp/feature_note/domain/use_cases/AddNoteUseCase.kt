package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.InvalidNoteException
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class AddNoteUseCase(private val repository: NoteRepository) {


    suspend operator fun invoke(note: Note) {
        if(note.title.isBlank()){

         throw InvalidNoteException(message = "Title Cant not be Empty ")
        }

        if (note.content.isBlank()){
            throw InvalidNoteException(message = "Content Cant not be Empty ")
        }
        repository.insertNote(note)

    }
}