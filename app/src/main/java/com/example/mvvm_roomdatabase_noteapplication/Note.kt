package com.example.mvvm_roomdatabase_noteapplication

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.FileDescriptor
import java.sql.Timestamp


@Entity(tableName = "notesTable")
class Note (
    //variables
    @ColumnInfo(name="title")val noteTitle:String,
    @ColumnInfo(name="description")val noteDescriptor:String,
    @ColumnInfo(name="timestamp")val timestamp:String
    ) {
    @PrimaryKey(autoGenerate = true)
    var id = 0
}