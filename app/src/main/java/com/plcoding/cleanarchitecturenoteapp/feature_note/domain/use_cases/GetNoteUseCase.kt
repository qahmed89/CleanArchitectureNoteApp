package com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases

import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.model.Note
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository

class GetNoteUseCase(
    private val repo: NoteRepository
) {
    suspend operator fun invoke(id: Int): Note? {
        return repo.getNoteById(id)
    }
}