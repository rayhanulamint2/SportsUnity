package com.example.sportsunity

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.absoluteOffset
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sportsunity.data.DataSourceForSportList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WinnerSelection(navController: NavController,modifier:Modifier = Modifier){
    Scaffold(
        topBar = { TopBarWinnerSelection(navController = navController) },
        content = {innerpadding->
//            myContent(navController,innerpadding)
            myContentWinnerSelection(navController = navController, innerpadding = innerpadding )
        }
    )
}

@Composable
fun TopBarWinnerSelection(navController: NavController){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ){
            BackButtonFromWinnerSelection {
                navController.navigate("HOME")
            }
            Text(
                text = "CHESS",
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineSmall,
                modifier = Modifier
                    .padding(top = 4.dp, bottom = 5.dp)
                    .absoluteOffset(x = (-15).dp, y = 1.dp)
            )
        }
        Image(
            painter = painterResource(id = R.drawable.blue_line),
            contentDescription = "Blue Line",
            contentScale = ContentScale.Crop,
            modifier = Modifier
                .height(2.dp)
                .fillMaxWidth()
        )
    }
}


@Composable
fun BackButtonFromWinnerSelection(onClick: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.back_button)
    Image(
        painter = image,
        contentDescription = "Back Button",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 0.dp, bottom = 5.dp)
            .absoluteOffset(x = (-125).dp, y = 4.dp)
//                    .align(Alignment.Start)
            .clickable { onClick() }
    )
}

@Composable
fun myContentWinnerSelection(navController: NavController,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Card(
            modifier = Modifier.padding(60.dp),
            colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.background_card))
        ) {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.padding(20.dp)
            ) {
                Box(modifier = Modifier){
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_60), 
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Select Winner",
                        color = Color.White,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50)
                    ) {

                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Player 1",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.fillMaxWidth()
                )  {
                    Button(
                        onClick = { /*TODO*/ },
                        shape = RoundedCornerShape(50)
                    ) {

                    }
                    Spacer(modifier = Modifier.width(20.dp))
                    Text(
                        text = "Player 2",
                        color = Color.White
                    )
                }
                Spacer(modifier = Modifier.height(20.dp))
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "Confirm")
                }
            }
        }
    }
}
