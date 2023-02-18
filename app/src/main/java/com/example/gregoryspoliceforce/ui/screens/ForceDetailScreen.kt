package com.example.gregoryspoliceforce.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.gregoryspoliceforce.data.PoliceUiState
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme

@Composable
fun ForceDetailScreen(modifier: Modifier = Modifier, policeUiState: PoliceUiState, policeViewModel: PoliceViewModel)  {
    ForceDetailScreenLayout(forceList = policeUiState.forceList, onPoliceListClick = {policeViewModel.setPoliceForce("Cambridge")})
}

@Composable
fun ForceDetailScreenLayout(forceList: List<Force>,
                     modifier: Modifier = Modifier,
                     onPoliceListClick : (String) -> Unit ){
    Column {
        NextStep(
            name = "YOU DID IT.",
            startText = "Explore the Police with me below!",
            modifier = modifier.align(Alignment.CenterHorizontally)

        )
        ForceList(forceList = forceList, onPoliceListClick = onPoliceListClick)
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
fun ForceDetailCard(force: Force, modifier: Modifier = Modifier) {
    Card(modifier = modifier.padding(8.dp).clickable {  }, elevation = 4.dp) { //TODO make clickable call onPoliceListClick

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
            Text(text = force.name,
                modifier = Modifier.padding(16.dp),
                style = MaterialTheme.typography.h6
            )
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