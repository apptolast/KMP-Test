package com.apptolast.kmptest.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import com.apptolast.kmptest.interfaces.toast

class HomeList : Screen {
//    override val key = uniqueScreenKey

    @Composable
    override fun Content() {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            item {
                Text(
                    text = "Test 1",
                    modifier = Modifier.clickable {
                        toast("Item click 1")
                    }
                )
            }
            item {
                Text(
                    text = "Test 2",
                    modifier = Modifier.clickable {
                        toast("Item click 2")
                    }
                )
            }
        }
    }
}