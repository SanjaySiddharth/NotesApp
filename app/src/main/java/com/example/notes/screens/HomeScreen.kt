package com.example.notes.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.notes.components.NoteButton
import com.example.notes.components.NoteCard
import com.example.notes.data.NoteDataSource
import com.example.notes.models.NoteDataModel


@Composable
fun HomeScreen(
    notes:List<NoteDataModel>,
    onAddNote:(NoteDataModel)-> Unit,
    onRemoveNote:(NoteDataModel)->Unit)
{
    var title by remember {
        mutableStateOf("")
    }
    var description by remember {
        mutableStateOf("")
    }
    val context = LocalContext.current
    Column(modifier = Modifier.padding(4.dp)) {
        TopAppBar(
            title = { Text(text = "Notes") },
            actions = {
                Icon(
                    imageVector = Icons.Default.Notifications,
                    contentDescription = "Notifications",
                )
            },
            backgroundColor = Color.LightGray,
        )
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            com.example.notes.components.TextField(
                value = title,
                modifier = Modifier.padding(top = 9.dp, bottom = 9.dp),
                label ="Title" ,
                onTextChange ={
                              title= it
                },
            )
            com.example.notes.components.TextField(
                modifier=Modifier.padding(8.dp),
                value = description,
                label ="Add a note" ,
                onTextChange ={
                              description= it
                },
            )
            NoteButton(
                modifier = Modifier.padding(8.dp),
                value = "Save",
                onClick = {
                          if(title.isNotEmpty() && description.isNotEmpty()){
                              //save or add data to list
                              onAddNote(NoteDataModel(title = title, description = description))
                              title=""
                              description=""
                              Toast.makeText(context,"created",Toast.LENGTH_LONG).show()
                          }
                },
            )
                

        }//end of inner column
        Divider()
        LazyColumn(){
            items(notes){note->
                NoteCard(note = note,
                    onClicked ={
                    onRemoveNote(note)
                } )
            }
        }


    }

}



@Preview (showBackground = true)
@Composable
fun Preview(){
    HomeScreen(notes = NoteDataSource().loadNotes(), onAddNote = {}, onRemoveNote = {})
}