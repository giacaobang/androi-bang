package com.example.jetnote.ui.components

import android.icu.text.CaseMap
import android.service.autofill.OnClickAction
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.ScaffoldState
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch


@Composable
fun TopAppBar(title: String, icon: ImageVector, onIconClick: () -> Unit) {
    Row(modifier = Modifier.fillMaxWidth()) {
        Image(
            imageVector = icon,
            contentDescription = "Drawer Header Icon",
            colorFilter = ColorFilter.tint(MaterialTheme.colors.onSurface),
            modifier = Modifier.padding(16.dp)
        )
        Text(text = title, modifier = Modifier.align(Alignment.CenterVertically))
    }
}


@Preview(showBackground = true)
@Composable
fun AppTopBarPreview() {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
    val coroutineScope = rememberCoroutineScope()
    TopAppBar(
        "hello",
        icon = Icons.Filled.List,
        onIconClick = { coroutineScope.launch { scaffoldState.drawerState.open() } }
    )
}