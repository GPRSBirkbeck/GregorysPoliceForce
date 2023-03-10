package com.example.gregoryspoliceforce.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import com.example.gregoryspoliceforce.ui.state.ForceListUiState
import com.example.gregoryspoliceforce.data.model.Force
import androidx.compose.ui.res.stringResource
import com.example.gregoryspoliceforce.R
import com.example.gregoryspoliceforce.ui.components.ErrorScreen
import com.example.gregoryspoliceforce.ui.components.LoadingScreen

const val FORCE_LIST_TEST_TAG = "force_list_test_tag"

@Composable
fun ForceListScreen(
    modifier: Modifier = Modifier,
    forceListUiState: ForceListUiState,
    onPoliceListClick: (String) -> Unit = {}
) {
    when (forceListUiState) {
        is ForceListUiState.Loading -> LoadingScreen(modifier = modifier)
        is ForceListUiState.Success -> ForceListScreenLayout(
            forceList = forceListUiState.forceList,
            onPoliceListClick = onPoliceListClick
        )
        is ForceListUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ForceListScreenLayout(
    forceList: List<Force>,
    onPoliceListClick: (String) -> Unit,
) {
    Column {
        Text(
            text = stringResource(R.string.our_forces),
            modifier = Modifier.padding(2.dp),
            style = MaterialTheme.typography.h6
        )
        ForceList(forceList = forceList, onPoliceListClick = onPoliceListClick)
    }
}

@Composable
fun ForceCard(force: Force, modifier: Modifier = Modifier, onPoliceListClick: (String) -> Unit) {
    Card(
        modifier = modifier
            .padding(8.dp), elevation = 5.dp
    ) {
        Column {
            Surface(modifier = modifier.clickable { force.id?.let { onPoliceListClick(it) } }) {
                force.name?.let {
                    Text(
                        text = it,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
                    )
                }

            }

        }
    }
}

@Composable
private fun ForceList(
    forceList: List<Force>,
    modifier: Modifier = Modifier,
    onPoliceListClick: (String) -> Unit
) {
    LazyColumn(modifier = Modifier.testTag(FORCE_LIST_TEST_TAG)) {
        items(forceList) { force ->
            ForceCard(force = force, onPoliceListClick = onPoliceListClick)
            modifier.clickable { force.id?.let { onPoliceListClick(it) } }
        }
    }
}
