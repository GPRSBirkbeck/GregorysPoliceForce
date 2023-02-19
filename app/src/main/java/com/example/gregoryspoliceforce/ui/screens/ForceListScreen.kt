package com.example.gregoryspoliceforce.ui.screens

import androidx.compose.ui.Alignment
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gregoryspoliceforce.data.PoliceOnlineUiState
import com.example.gregoryspoliceforce.data.PoliceUiState
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.Image
import androidx.compose.ui.res.stringResource
import com.example.gregoryspoliceforce.R
import com.example.gregoryspoliceforce.ui.components.ErrorScreen
import com.example.gregoryspoliceforce.ui.components.LoadingScreen

@Composable
fun ForceListScreen(modifier: Modifier = Modifier, policeUiState: PoliceUiState, policeOnlineUiState: PoliceOnlineUiState, policeViewModel: PoliceViewModel, onPoliceListClick : (String) -> Unit = {})  {
    when (policeOnlineUiState) {
        is PoliceOnlineUiState.Loading -> LoadingScreen(modifier = modifier)
        is PoliceOnlineUiState.Success -> ForceListScreenLayout(forceList = policeOnlineUiState.onlineForceList, onPoliceListClick = onPoliceListClick)
        is PoliceOnlineUiState.Error -> ErrorScreen()
    }
}

@Composable
fun ForceListScreenLayout(forceList: List<Force>,
                          modifier: Modifier = Modifier,
                          onPoliceListClick : (String) -> Unit ){
        ForceList(forceList = forceList, onPoliceListClick = onPoliceListClick)
}

@Composable
fun ForceCard(force: Force, modifier: Modifier = Modifier, onPoliceListClick : (String) -> Unit) {
    Card(modifier = modifier
        .padding(8.dp), elevation = 4.dp) { //TODO make clickable call onPoliceListClick
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
            Surface(modifier = modifier.clickable { force.id?.let { onPoliceListClick(it) } }) {
                force.name?.let {
                    Text(text = it,
                        modifier = Modifier.padding(16.dp),
                        style = MaterialTheme.typography.h6
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
                modifier.clickable { force.id?.let { onPoliceListClick(it) } }
            }
    }
}
