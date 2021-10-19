package com.example.jetnote.ui.components

import NoteColor
import androidx.activity.viewModels
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.jetnote.JetNotesApplication
import com.example.jetnote.data.database.model.NoteDbModel
import com.example.jetnote.domain.model.NoteModel
import com.example.jetnote.routing.Screen
import com.example.jetnote.util.fromHex
import com.example.jetnote.viewmodel.MainViewModel
import com.example.jetnote.viewmodel.MainViewModelFactory
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

@Composable
fun NoteScreen(viewModel: MainViewModel) {
    val notes: List<NoteModel> by viewModel.notesNotInTrash.observeAsState(listOf())
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold( scaffoldState = scaffoldState,topBar = {
        TopAppBar(
            title = "JetNotes o menu ngoai",
            icon = Icons.Filled.List,
            onIconClick = { coroutineScope.launch { scaffoldState.drawerState.open() } })
    },
        drawerContent = {
            AppDrawer(currentScreen = Screen.Notes,
                closeDrawerAction = {
                    coroutineScope.launch {
                        scaffoldState.drawerState.close()
                    }
                }
            )
        },
        content = {
            if(notes.isEmpty()){
                Text(text = "HHIHI")

            }else{
                NoteList(notes = notes, onNoteCheckedChange = { }, onNoteClick = {})
            }

        },
                floatingActionButton = {
            FloatingActionButton(
                onClick = {

                }
            ) {
                Text("+")
            }}

    )
}

@Composable
private fun NoteList(
    notes: List<NoteModel>,
    onNoteCheckedChange: (NoteModel) -> Unit,
    onNoteClick: (NoteModel) -> Unit

) {
    val backgroundShape: Shape = RoundedCornerShape(4.dp)
    LazyColumn {
        items(notes) { element ->
            Row(
                modifier = Modifier
                    .padding(7.dp)
                    .shadow(1.dp, backgroundShape)
                    .heightIn(min = 64.dp)
                    .background(
                        Color.White, backgroundShape
                    )
            ) {

                NoteColor(
                    modifier = Modifier
                        .padding(start = 16.dp, end = 16.dp),
                    color = Color.fromHex(element.color.hex),
                    size = 40.dp,
                    border = 2.dp
                )
                Column(
                    modifier = Modifier
                        .weight(1f)
                        .align(Alignment.CenterVertically)
                ) {
                    Text(
                        text = element.title,
                        maxLines = 1,
                        color = Color.Black,
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 16.sp,
                            letterSpacing = 0.15.sp
                        )
                    )
                    Text(
                        text = element.content,
                        maxLines = 1,
                        color = Color.Black.copy(alpha = 0.75f),
                        style = TextStyle(
                            fontWeight = FontWeight.Normal,
                            fontSize = 14.sp,
                            letterSpacing = 0.25.sp
                        )
                    )

                }
            }
        }

    }
}

@Preview
@Composable
private fun NotesListPreview() {
    NoteList(
        notes = listOf(
            NoteModel(1, "RW Meeting", "Prepare sample project"),
            NoteModel(2, "Bills", "Pay by tomorrow", false),
            NoteModel(3, "Pancake recipe", "Milk, eggs, salt, flour..."),
            NoteModel(4, "Workout", "Running, push ups, pull ups, squats..."),
            NoteModel(5, "Title 5", "Content 5", false),
            NoteModel(6, "Title 6", "Content 6", false),
            NoteModel(7, "Title 7", "Content 7", false),
            NoteModel(8, "Title 8", "Content 8", false),
            NoteModel(9, "Title 9", "Content 9"),
            NoteModel(10, "Title 10", "Content 10", false),
            NoteModel(11, "Title 11", "Content 11", true),
            NoteModel(12, "Title 12", "Content 12", true)
        ),
        onNoteClick = {},
        onNoteCheckedChange = {},
    )
}

