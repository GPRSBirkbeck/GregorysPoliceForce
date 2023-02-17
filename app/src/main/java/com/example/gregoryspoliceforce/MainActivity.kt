package com.example.gregoryspoliceforce

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
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
import com.example.gregoryspoliceforce.data.MockDataSource
import com.example.gregoryspoliceforce.model.Force
import com.example.gregoryspoliceforce.ui.theme.GregorysPoliceForceTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //TODO Migrate this into a composable App?
        setContent {
            GregorysPoliceForceTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Column {
                        WelcomeToThePolice(
                            name = "Welcome to the Police Yovan.",
                            startText = "Explore the Police with me below!"
                        )
                        ForceList(forceList = MockDataSource().LoadMockPoliceSource())
                    }
                }
            }
        }
    }
}

@Composable
fun WelcomeToThePolice(name: String, startText: String) {
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
    Card(modifier = modifier.padding(8.dp), elevation = 4.dp) {
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