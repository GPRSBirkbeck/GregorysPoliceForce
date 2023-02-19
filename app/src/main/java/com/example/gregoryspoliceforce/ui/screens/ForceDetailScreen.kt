package com.example.gregoryspoliceforce.ui.screens

import android.text.Html
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.core.text.HtmlCompat
import com.example.gregoryspoliceforce.R
import com.example.gregoryspoliceforce.data.DetailPoliceOnlineUiState
import com.example.gregoryspoliceforce.data.PoliceOnlineUiState
import com.example.gregoryspoliceforce.data.PoliceUiState
import com.example.gregoryspoliceforce.model.EngagementMethod
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.model.ForceDetail
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.components.ErrorScreen
import com.example.gregoryspoliceforce.ui.components.LoadingScreen
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme

@Composable
fun ForceDetailScreen(modifier: Modifier = Modifier, policeUiState: PoliceUiState,detailPoliceOnlineUiState: DetailPoliceOnlineUiState, policeViewModel: PoliceViewModel)  {
    when (detailPoliceOnlineUiState) {
        is DetailPoliceOnlineUiState.Loading -> LoadingScreen(modifier = modifier)
        is DetailPoliceOnlineUiState.Success -> ForceDetailScreenLayout(chosenForce = detailPoliceOnlineUiState.onlineForceDetail)
        is DetailPoliceOnlineUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ForceDetailScreenLayout(chosenForce: ForceDetail,
                     modifier: Modifier = Modifier){
        ForceDetailCard(forceDetail = chosenForce)
}

@Composable
fun ForceDetailCard(forceDetail: ForceDetail, modifier: Modifier = Modifier) {
    LazyColumn {
        item {
            Card(
                modifier = modifier
                    .padding(8.dp), elevation = 4.dp
            ) {
                Column {
                    forceDetail.name?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.h5
                        )
                    }
                    forceDetail.telephone?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.h6
                        )
                    }
                    forceDetail.url?.let {
                        Text(
                            text = it,
                            modifier = Modifier.padding(8.dp),
                            style = MaterialTheme.typography.h6
                        )
                    }
                    forceDetail.description?.let {
                        Text(
                            text = HtmlCompat.fromHtml(it, HtmlCompat.FROM_HTML_MODE_LEGACY)
                                .toString(),
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
    Card(modifier = modifier
        .padding(8.dp), elevation = 4.dp) {

        Column {
            engagementMethod.title?.let {
                Text(text = it,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.body1
                )
            }
            engagementMethod.description?.let {
                Text(text = it,
                    modifier = Modifier.padding(2.dp),
                    style = MaterialTheme.typography.subtitle2,
                )
            }
            val uriHandler = LocalUriHandler.current
            engagementMethod.url?.let {
                TextButton(onClick = { uriHandler.openUri(it) }) {
                    Text(
                        text = it,
                        modifier = Modifier.padding(2.dp),
                        style = MaterialTheme.typography.subtitle2,
                        color = Color.Blue
                    )

                }
            }
        }
    }
}
