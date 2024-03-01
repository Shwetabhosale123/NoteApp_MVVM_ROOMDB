package com.example.mvvm_roomdatabase_noteapplication

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import java.text.SimpleDateFormat
import java.util.Date

class AddEditNoteActivity : AppCompatActivity() {
    lateinit var noteTitleEdt:EditText
    lateinit var noteDescriptionEdt:EditText
    lateinit var addupdateBtn:Button
    lateinit var viewModal: NoteViewModal
    var noteID=-1

    @SuppressLint("SimpleDateFormat", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_note)
        noteTitleEdt=findViewById(R.id.idEdtNoteTitle)
        noteDescriptionEdt=findViewById(R.id.idEdtNoteDescription)
        addupdateBtn=findViewById(R.id.idBtnAddUpdate)
        viewModal=ViewModelProvider(this,ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(NoteViewModal::class.java)

        val noteType=intent.getStringExtra("noteType")
        if (noteType.equals("Edit")){
            val noteTitle=intent.getStringExtra("noteTitle")
            val noteDes=intent.getStringExtra("noteDescription")
             noteID=intent.getIntExtra("noteID",-1)
            addupdateBtn.setText("Update Note")
            noteTitleEdt.setText(noteTitle)
            noteDescriptionEdt.setText(noteDes)
        }else{
            addupdateBtn.setText("Save Note")
        }

        addupdateBtn.setOnClickListener{
            val noteTitle=noteTitleEdt.text.toString()
            val noteDescription=noteDescriptionEdt.text.toString()

            if(noteType.equals("Edit")){
                if(noteTitle.isNotEmpty() && noteDescription.isNotEmpty()){
                    val sdf=SimpleDateFormat("dd MM,yyyy - HH:mm")
                    val currentDate:String=sdf.format(Date())
                    val updateNote=Note(noteTitle,noteDescription,currentDate)
                    updateNote.id=noteID
                    viewModal.updateNote(updateNote)
                    Toast.makeText(this,"Note Updated...",Toast.LENGTH_LONG).show()
                }
            }else{
                if(noteTitle.isNotEmpty()  &&  noteDescription.isNotEmpty()){
                    val sdf=SimpleDateFormat("dd MM,yyyy - HH:mm")
                    val currentDate:String=sdf.format(Date())
                    viewModal.addNote(Note(noteTitle,noteDescription,currentDate))
                    Toast.makeText(this,"Note Added..",Toast.LENGTH_LONG).show()

                }
            }
            startActivity(Intent(applicationContext,MainActivity::class.java))
            this.finish()
        }

    }
}