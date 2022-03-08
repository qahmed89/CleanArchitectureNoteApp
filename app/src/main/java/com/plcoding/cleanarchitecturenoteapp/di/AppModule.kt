package com.plcoding.cleanarchitecturenoteapp.di

import android.app.Application
import androidx.room.Room
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.data_source.NoteDatabase.Companion.DATABASE_NAME
import com.plcoding.cleanarchitecturenoteapp.feature_note.data.repository.NoteRepositoryImp
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.repository.NoteRepository
import com.plcoding.cleanarchitecturenoteapp.feature_note.domain.use_cases.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideNoteDataBas(app: Application): NoteDatabase =
        Room.databaseBuilder(app, NoteDatabase::class.java, DATABASE_NAME).build()

    @Provides
    @Singleton
    fun provideNoteRepository (db : NoteDatabase) : NoteRepository =
        NoteRepositoryImp(db.noteDao)

    @Provides
    @Singleton
    fun provideNoteUseCases (repo : NoteRepository) :NoteUseCases =
        NoteUseCases(
            getNotes = GetNotesUseCase(repo),
            deleteNoteUseCase = DeleteNoteUseCase(repo),
            addNoteUseCase = AddNoteUseCase(repo),
            getNote = GetNoteUseCase(repo)
        )
}