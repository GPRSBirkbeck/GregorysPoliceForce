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
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme

@Composable
fun ForceDetailScreen(modifier: Modifier = Modifier, policeUiState: PoliceUiState,detailPoliceOnlineUiState: DetailPoliceOnlineUiState, policeViewModel: PoliceViewModel)  {
    when (detailPoliceOnlineUiState) {
        is DetailPoliceOnlineUiState.Loading -> LoadingScreen(modifier = modifier)
        is DetailPoliceOnlineUiState.Success -> ForceDetailScreenLayout(chosenForce = detailPoliceOnlineUiState.onlineForceDetail)
        is DetailPoliceOnlineUiState.Error -> ErrorScreen()
    }

    //ForceDetailScreenLayout(forceList = policeUiState.forceList, onPoliceListClick = {policeViewModel.setPoliceForce("Cambridge")})
}

@Composable
fun ForceDetailScreenLayout(chosenForce: ForceDetail,
                     modifier: Modifier = Modifier){
    Column {
//        NextStep(
//            name = "YOU DID IT.",
//            startText = "Explore the Police with me below!",
//            modifier = modifier.align(Alignment.CenterHorizontally)
//
//        )
        ForceDetailCard(forceDetail = chosenForce)
    }
}

@Composable
fun NextStep(name: String, startText: String, modifier: Modifier = Modifier) {
    Column {
        Text(
            text = name,
            fontSize = 36.sp
        )
        Text(
            text = startText,
            fontSize = 24.sp
        )
    }
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

                    //TODO add fun Images
//            Image(
//                painter = painterResource(affirmation.imageResourceId),
//                contentDescription = stringResource(affirmation.stringResourceId),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(194.dp),
//                contentScale = ContentScale.Crop
//            )
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
                text = "Engagement methods",
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

@Composable
private fun ForceList(forceList: List<Force>, modifier: Modifier = Modifier, onPoliceListClick : (String) -> Unit ){
    LazyColumn{
        items(forceList){
                force -> ForceCard(force = force, onPoliceListClick = onPoliceListClick)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NextStep() {
    GregorysPoliceForceTheme {
        WelcomeToThePolice(name = "Yovan", startText = "Let's start exploring the Police Database")
    }
}

//@Preview
//@Composable
//private fun ForceCardPreview() {
//    ForceCard(force = Force("london-test", "London's Test Force"))
//}
//TODO fix