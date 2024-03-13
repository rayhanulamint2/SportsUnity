package com.example.sportsunity

import android.widget.ImageButton
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Participations(navController:NavController, modifier: Modifier) {
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "MYPROFILE", header = "Participations")
                 },
        content = {innerpadding->
            myContentParticipations(navController,innerpadding)
        }
    )
}


@Composable
fun myContentParticipations(navController: NavController, innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column {
            Spacer(modifier = Modifier.height(60.dp))
            Card(
                modifier = Modifier
                    .padding(20.dp)
                    .weight(.5f),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.background_card))
            ) {
                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_60),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    Text(
                        text = "As Organizer",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
                val playerList = listOf(
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba"
                )
                LazyColumn(modifier = Modifier.padding(bottom = 0.dp)) {
                    items(playerList) { player ->
                        Text(
                            text = player,
                            color = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
            Card(
                modifier = Modifier
                    .padding(10.dp)
                    .weight(.5f),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.background_card))
            ) {
                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_60),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    Text(
                        text = "As Participant",
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
                val playerList = listOf(
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba",
                    "Khalid Bin Selim",
                    "Abhishek Das",
                    "Rayhanul Amin Tanvir",
                    "Gazi Mujtaba"
                )
                LazyColumn(modifier = Modifier.padding(bottom = 0.dp)) {
                    items(playerList) { player ->
                        Text(
                            text = player,
                            color = Color.White,
                            modifier = Modifier
                                .padding(5.dp)
                                .fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                }
            }
        }
    }
}
