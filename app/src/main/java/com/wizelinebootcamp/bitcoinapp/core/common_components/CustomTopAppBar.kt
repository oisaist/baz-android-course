package com.wizelinebootcamp.bitcoinapp.core.common_components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun CustomTopAppBar(
    navController: NavController,
    title: String,
    navigationIcon: ImageVector? = null,
    backStack: Boolean = false
) {
    if (backStack) {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                )
            },
            elevation = 12.dp,
            navigationIcon = {
                IconButton(onClick = {
                    navController.popBackStack()
                }) {
                    navigationIcon?.let { icon ->
                        Icon(
                            imageVector = icon,
                            contentDescription = null
                        )
                    }
                }
            }
        )
    } else {
        TopAppBar(
            title = {
                Text(
                    text = title,
                    style = MaterialTheme.typography.h6,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.Center,
                )
            },
            elevation = 12.dp
        )
    }
}
