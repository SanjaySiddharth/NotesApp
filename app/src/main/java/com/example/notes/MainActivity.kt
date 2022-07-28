package com.example.notes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModel
import com.example.notes.data.NoteDataSource
import com.example.notes.models.NoteDataModel
import com.example.notes.screens.HomeScreen
import com.example.notes.screens.NoteViewModel
import com.example.notes.ui.theme.NotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NotesTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ){
//                    val noteViewModel: NoteViewModel by viewModels()
                    NoteApp(noteViewModel = NoteViewModel())
//                    val notes = remember {
//                        mutableStateListOf<NoteDataModel>()
//                    }
//                    HomeScreen(notes = notes,
//                        onAddNote = {
//                                    notes.add(it)
//                        },
//                        onRemoveNote ={
//
//                        } )
                }
            }
        }
    }
}

@Composable
fun NoteApp(noteViewModel: NoteViewModel){
    val notesList = noteViewModel.getAllNotes()
    HomeScreen(notes = notesList,
        onAddNote = {
                    noteViewModel.addNote(it)
        },
        onRemoveNote = {
            noteViewModel.removeNote(it)
        }
    )

}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    NotesTheme {

    }
}