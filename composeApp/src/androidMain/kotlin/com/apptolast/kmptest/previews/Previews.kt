package com.apptolast.kmptest.previews

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import com.apptolast.kmptest.screens.HomeScreen
import com.apptolast.kmptest.screens.ListItem
import com.apptolast.kmptest.screens.ListItemType
import com.apptolast.kmptest.screens.NavigationFeatureScreen
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeListPreview() {
    MaterialTheme {
        HomeScreen()
    }
}

@Composable
@Preview
fun ListItemPreview() {
    MaterialTheme {
        ListItem(
            itemType = ListItemType.Item2
        )
    }
}

@Composable
@Preview
fun TestNavigationPreview() {
    MaterialTheme {
        NavigationFeatureScreen(title = "title")
    }
}

