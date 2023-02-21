package com.example.gregoryspoliceforce.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.core.text.HtmlCompat
import com.example.gregoryspoliceforce.R
import com.example.gregoryspoliceforce.ui.state.ForceDetailUiState
import com.example.gregoryspoliceforce.data.model.EngagementMethod
import com.example.gregoryspoliceforce.data.model.ForceDetail
import com.example.gregoryspoliceforce.ui.components.ErrorScreen
import com.example.gregoryspoliceforce.ui.components.LoadingScreen
import java.util.*

const val FORCE_DETAIL_NAME_TAG = "force_list_item_tag"

@Composable
fun ForceDetailScreen(
    modifier: Modifier = Modifier,
    forceDetailUiState: ForceDetailUiState,
) {
    when (forceDetailUiState) {
        is ForceDetailUiState.Loading -> LoadingScreen(modifier = modifier)
        is ForceDetailUiState.Success -> ForceDetailScreenLayout(chosenForce = forceDetailUiState.forceDetail)
        is ForceDetailUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ForceDetailScreenLayout(
    chosenForce: ForceDetail,
) {
    ForceDetailCard(forceDetail = chosenForce)
}

@Composable
fun ForceDetailCard(forceDetail: ForceDetail, modifier: Modifier = Modifier) {
    LazyColumn {
        item {
            Card(
                modifier = modifier
                    .padding(8.dp), elevation = 5.dp
            ) {
                Column {
                    forceDetail.name?.let {
                        Text(
                            text = stringResource(R.string.selected_force),
                            modifier = Modifier
                                .padding(16.dp)
                                .testTag(FORCE_DETAIL_NAME_TAG),
                            style = MaterialTheme.typography.h6
                        )
                        Text(
                            text = it,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.h4
                        )
                    }
                    forceDetail.telephone?.let {
                        Text(
                            text = stringResource(R.string.contact, it),
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.h6
                        )
                    }
                    forceDetail.url?.let {
                        Text(
                            text = stringResource(R.string.website),
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.h6
                        )
                        val uriHandler = LocalUriHandler.current
                            TextButton(onClick = { uriHandler.openUri(it) }) {
                                Text(
                                    text = it,
                                    modifier = Modifier.padding(2.dp),
                                    style = MaterialTheme.typography.body1,
                                    color = Color.Blue
                                )
                            }
                    }
                    forceDetail.description?.let {
                        Text(
                            text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
                                .toString().trim('\n'),
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.body1
                        )
                    }
                }
            }
            Text(
                text = stringResource(R.string.engagement_method),
                modifier = Modifier.padding(8.dp),
                style = MaterialTheme.typography.h6
            )
        }
        items(forceDetail.engagementMethods) { method ->
            if (method.url != null) {
                EngagementCard(engagementMethod = method)
            }
        }
    }
}

@Composable
fun EngagementCard(engagementMethod: EngagementMethod, modifier: Modifier = Modifier) {
    Card(
        modifier = modifier
            .padding(8.dp).fillMaxWidth(), elevation = 5.dp
    ) {

        Column {
            engagementMethod.title?.let {
                Text(
                    text = it.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.ROOT) else it.toString() },
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.h6
                )
            }
            engagementMethod.description?.let {
                Text(
                    text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
                        .toString().trim('\n'),
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.body1,
                )
            }
            val uriHandler = LocalUriHandler.current
            engagementMethod.url?.let {
                TextButton(onClick = { uriHandler.openUri(it) }) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(2.dp),
                        style = MaterialTheme.typography.body1,
                        color = Color.Blue
                    )

                }
            }
        }
    }
}
