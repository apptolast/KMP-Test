package com.apptolast.kmptest.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.apptolast.kmptest.interfaces.toast
import kmp_test.composeapp.generated.resources.Res
import kmp_test.composeapp.generated.resources.app_name
import kotlinx.coroutines.launch
import org.jetbrains.compose.resources.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(navigateToNavigationFeature: (String) -> Unit = {}) {

    val snackbarHostState = remember { SnackbarHostState() }
    val scope = rememberCoroutineScope()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = stringResource(Res.string.app_name),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                    )
                },
            )
        },
        snackbarHost = { SnackbarHost(snackbarHostState) },
        containerColor = MaterialTheme.colorScheme.background,

        ) { paddingValues ->
        HomeContent(
            version = "version",
            modifier = Modifier.padding(paddingValues),
            onItemClick = { item ->
                when (item) {
                    ListItemType.Navigation -> navigateToNavigationFeature(item.title)

                    else -> {
                        scope.launch {
                            snackbarHostState.showSnackbar("click : ${item.title}")
                        }
                        toast("click : ${item.title}")
                    }
                }
            }
        )
    }
}

@Composable
fun HomeContent(
    version: String,
    modifier: Modifier = Modifier,
    onItemClick: (ListItemType) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
            .fillMaxWidth()
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
            .background(
                color = MaterialTheme.colorScheme.primaryContainer,
                shape = MaterialTheme.shapes.large.copy(CornerSize(10.dp))
            )
            .padding(12.dp),
    )
}

enum class ListItemType(val title: String) {
    Navigation(title = "Navigation"),
    Item2(title = "Item 2"),
    Item3(title = "Item 3"),
}
