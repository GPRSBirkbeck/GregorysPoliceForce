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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.gregoryspoliceforce.data.MockDataSource
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.ui.PoliceViewModel
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme


@Composable
fun HomeScreen(modifier: Modifier = Modifier,
               policeViewModel: PoliceViewModel = viewModel())  {
    val policeUiState by policeViewModel.uiState.collectAsState()
    HomeScreenLayout(forceList = policeUiState.forceList, onPoliceListClick = {policeViewModel.setPoliceForce("Cambridge")})
}

@Composable
fun HomeScreenLayout(forceList: List<Force>,
                     modifier: Modifier = Modifier,
                     onPoliceListClick : (String) -> Unit ){
    Column {
        WelcomeToThePolice(
            name = "Welcome to the Police Yovan.",
            startText = "Explore the Police with me below!",
            modifier = modifier.align(Alignment.CenterHorizontally)

        )
        ForceList(forceList = forceList)
    }
}

@Composable
fun WelcomeToThePolice(name: String, startText: String, modifier: Modifier = Modifier) {
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
fun ForceCard(force: Force, modifier: Modifier = Modifier) {
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
private fun ForceList(forceList: List<Force>, modifier: Modifier = Modifier){
    LazyColumn{
        items(forceList){
                force -> ForceCard(force = force)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PolicePreview() {
    GregorysPoliceForceTheme {
        WelcomeToThePolice(name = "Yovan", startText = "Let's start exploring the Police Database")
    }
}

@Preview
@Composable
private fun ForceCardPreview() {
    ForceCard(force = Force("london-test", "London's Test Force"))
}

// TODO Remove note: The composable function must provide default values for any parameters to preview it. For this reason, you can't preview the Greeting() function directly. Instead, you need to add another function, the BirthdayCardPreview() function in this case, that calls the Greeting() function with an appropriate parameter.

enum class HomeScreen2 () { //TODO compare this to cupcakeScreen 4 https://developer.android.com/codelabs/basic-android-kotlin-compose-navigation?continue=https%3A%2F%2Fdeveloper.android.com%2Fcourses%2Fpathways%2Fandroid-basics-compose-unit-4-pathway-2%23codelab-https%3A%2F%2Fdeveloper.android.com%2Fcodelabs%2Fbasic-android-kotlin-compose-navigation#3
    Home,
    Force,
    SeniorOfficers
}