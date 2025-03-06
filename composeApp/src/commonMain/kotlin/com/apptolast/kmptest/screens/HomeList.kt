package com.apptolast.kmptest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.apptolast.kmptest.interfaces.toast

class HomeList : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {

            items(ListItemType.entries) { item ->
                ListItem(
                    itemType = item,
                    modifier = Modifier.padding(vertical = 8.dp),
                    onClick = { itemType ->

                        when (item) {
                            ListItemType.Navigation -> {
                                navigator.push(TestNavigation())
                            }

                            else -> {
                                toast("click : ${item.title}")
                            }
                        }
                    }
                )
            }
        }
    }
}

enum class ListItemType(val title: String) {
    Navigation(title = "Navigation"),
    Item2(title = "Item 2"),
    Item3(title = "Item 3"),
}


@Composable
private fun ListItem(
    itemType: ListItemType,
    modifier: Modifier = Modifier,
    onClick: (ListItemType) -> Unit = {},
) {
    Text(
        text = itemType.title,
        style = MaterialTheme.typography.subtitle2,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick(itemType) }
            .background(Color.LightGray, shape = MaterialTheme.shapes.large.copy(CornerSize(10.dp)))
            .padding(12.dp),
    )
}


