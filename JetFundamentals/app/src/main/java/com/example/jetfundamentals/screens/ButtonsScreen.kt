package com.example.jetfundamentals.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.unit.dp
import com.example.jetfundamentals.R
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun ExploreButtonsScreen() {
  Column(
    modifier = Modifier.fillMaxSize(),
    horizontalAlignment = Alignment.CenterHorizontally,
    verticalArrangement = Arrangement.Center
  ) {

    MyButton()
    MyRadioGroup()
    MyFloatingActionButton()

    BackButtonHandler {
      JetFundamentalsRouter.navigateTo(Screen.Navigation)
    }
  }
}

@Composable
fun MyButton() {
  //TODO write your code here
 Button(colors = ButtonDefaults.buttonColors(backgroundColor = colorResource(id = R.color.colorPrimary)),border= BorderStroke(1.dp,color = colorResource(
   id = R.color.colorPrimary
 )),onClick = {}){ Text(text = "This is a button",color = Color.White)}
}

@Composable
fun MyRadioGroup() {
  //TODO write your code here
  val radioButtons= listOf(0,1,2)
  val selectdButton = remember { mutableStateOf(radioButtons.first())}
  Column() {
  radioButtons.forEach { index->
    val isSelected= index==selectdButton.value
    val colors= RadioButtonDefaults.colors(selectedColor = colorResource(id = R.color.colorPrimary),unselectedColor = colorResource(
      id = R.color.colorPrimary
    ),disabledColor = Color.LightGray)
    RadioButton(selected = isSelected, onClick = { selectdButton.value=index},colors = colors)
  }
  }
}

@Composable
fun MyFloatingActionButton() {
  //TODO write your code here
}
