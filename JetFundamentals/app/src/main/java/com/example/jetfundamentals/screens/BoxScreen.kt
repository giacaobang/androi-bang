package com.example.jetfundamentals.screens

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.jetfundamentals.router.BackButtonHandler
import com.example.jetfundamentals.router.JetFundamentalsRouter
import com.example.jetfundamentals.router.Screen

@Composable
fun BoxScreen() {
  MyBox()

  BackButtonHandler {
    JetFundamentalsRouter.navigateTo(Screen.Navigation)
  }
}

@Composable
fun MyBox(
  modifier: Modifier = Modifier,
  contentModifier: Modifier = Modifier
) {
  //TODO write your code here
}