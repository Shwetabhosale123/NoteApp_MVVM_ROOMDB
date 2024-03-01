package com.example.mvvm_roomdatabase_noteapplication

import androidx.lifecycle.LiveData


class NotesRepository (private val notesDao: NotesDao){
    val allNotes:LiveData<List<Note>> = notesDao.getAllNotes() //getting all notes from dao class

    suspend fun insert(note: Note){
        notesDao.insert(note)
    }

    suspend fun delete(note: Note){
        notesDao.delete(note)
    }

    suspend fun update(note: Note){
        notesDao.update(note)
    }
}