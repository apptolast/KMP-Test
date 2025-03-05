package com.apptolast.kmptest.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import com.apptolast.kmptest.interfaces.toast

class HomeList : Screen {

    @Composable
    override fun Content() {
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            items(listItems) { item ->
                ListItem(
                    text = item,
                    modifier = Modifier.padding(vertical = 8.dp),
                    onClick = { text ->
                        toast("click: $text")
                    }
                )
            }
        }
    }


    companion object {
        private val listItems = listOf("Item 1", "Item 2", "Item 3")
    }
}


@Composable
fun ListItem(
    text: String,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {},
) {
    Text(
        text = text,
        style = MaterialTheme.typography.subtitle2,
        modifier = modifier.clickable { onClick(text) }
    )
}


