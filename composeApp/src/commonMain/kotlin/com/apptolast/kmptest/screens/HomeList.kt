package com.apptolast.kmptest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.apptolast.kmptest.SurfaceScreen
import com.apptolast.kmptest.interfaces.toast
import kmp_test.composeapp.generated.resources.Res
import kmp_test.composeapp.generated.resources.app_name
import org.jetbrains.compose.resources.stringResource

class HomeList : Screen {

    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow

//        val homeListViewModel = koinInject<HomeListViewModel>()
//        val version = koinInject<Greeting>().greet()

        SurfaceScreen {
            HomeScreen(
                version = "version",
                onItemClick = { item ->
                    when (item) {
                        ListItemType.Navigation -> {
                            navigator.push(TestNavigation(item.title))
                        }

                        else -> {
                            toast("click : ${item.title}")
                        }
                    }
                })
        }
    }
}

@Composable
fun HomeScreen(
    version: String,
    onItemClick: (ListItemType) -> Unit = {}
) {
    Column(
        modifier = Modifier.fillMaxSize(),
    ) {
        Text(
            text = stringResource(Res.string.app_name),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f)
                .padding(16.dp)
        ) {

            items(ListItemType.entries) { item ->
                ListItem(
                    itemType = item,
                    modifier = Modifier.padding(vertical = 8.dp),
                    onClick = {
                        onItemClick(item)
                    }
                )
            }
        }
        Text(
            text = version,
            modifier = Modifier.fillMaxWidth().padding(16.dp),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
    }
}

@Composable
fun ListItem(
    itemType: ListItemType,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
) {
    Text(
        text = itemType.title,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .background(Color.LightGray, shape = MaterialTheme.shapes.large.copy(CornerSize(10.dp)))
            .padding(12.dp),
    )
}

enum class ListItemType(val title: String) {
    Navigation(title = "Navigation"),
    Item2(title = "Item 2"),
    Item3(title = "Item 3"),
}
