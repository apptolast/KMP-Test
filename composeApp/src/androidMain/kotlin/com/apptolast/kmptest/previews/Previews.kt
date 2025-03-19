package com.apptolast.kmptest.previews

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator
import com.apptolast.kmptest.interfaces.toast
import com.apptolast.kmptest.screens.HomeList
import com.apptolast.kmptest.screens.ListItem
import com.apptolast.kmptest.screens.ListItemType
import com.apptolast.kmptest.screens.TestNavigation
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun HomeListPreview() {
    MaterialTheme {
        Navigator(
            screen = HomeList(),
            onBackPressed = { currentScreen ->
                toast("Pop screen #${(currentScreen as HomeList)}")
                true
            }
        )
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
        Navigator(
            screen = TestNavigation(title = "test"),
            onBackPressed = { currentScreen ->
                toast("Pop screen #${(currentScreen as HomeList)}")
                true
            }
        )
    }
}

