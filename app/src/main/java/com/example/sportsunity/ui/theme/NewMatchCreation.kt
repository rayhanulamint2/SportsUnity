package com.example.sportsunity.ui.theme

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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sportsunity.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewMatchCreation(text: String, navController: NavController, modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
//            TopBarNewMatchCreation(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "Chess",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("SPORTSLISTFORORGANAIZER")
                        }) {
                            //                                 Icon(
                            //                                     imageVector = Icons.Default.Menu,
                            //                                     contentDescription = null,
                            //                                     tint = Color.White
                            //                                 )
                            Image(
                                painter = painterResource(id = R.drawable.back_button),
                                contentDescription = null,
                                modifier = Modifier
                                    .height(50.dp)
                                    .width(50.dp)
                            )
                        }
                    },
                    colors = TopAppBarDefaults.smallTopAppBarColors(Color.Black)
                )
                Image(
                    painter = painterResource(id = R.drawable.blue_line),
                    contentDescription = "Blue Line",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .height(2.dp)
                        .fillMaxWidth()
                )
            }
                 },
        content = {innerpadding->
            myContentNewMatchCreation(navController,innerpadding)
        }
    )
}

@Composable
fun TopBarNewMatchCreation(navController: NavController){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ){
            BackButtonFromNewMatchCreation {
                navController.navigate("SPORTSLISTFORORGANAIZER")
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
fun BackButtonFromNewMatchCreation(onClick: () -> Unit) {
    val image: Painter = painterResource(id = R.drawable.back_button)
    Image(
        painter = image,
        contentDescription = "Back Button",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(40.dp)
            .padding(top = 0.dp, bottom = 5.dp)
            .absoluteOffset(x = (-120).dp, y = 4.dp)
//                    .align(Alignment.Start)
            .clickable { onClick() }
    )
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentNewMatchCreation(navController: NavController,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize(),contentAlignment = Alignment.Center) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(modifier = Modifier){
                Image(
                    painter = painterResource(id = R.drawable.rectangle_51), 
                    contentDescription = "background",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
//                        .fillMaxWidth()
                        .height(425.dp)
                        .width(375.dp)
                        .clip(shape = RoundedCornerShape(15))
                        .padding(10.dp),

                )
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    var player1 by rememberSaveable {
                        mutableStateOf("")
                    }
                    var player2 by rememberSaveable {
                        mutableStateOf("")
                    }
                    var round by rememberSaveable {
                        mutableStateOf("")
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = stringResource(id = R.string.create_match),
                        color = Color.White,
                        style = MaterialTheme.typography.headlineSmall
                        )
                    Spacer(modifier = Modifier.height(30.dp))
                    Text(
                        text = "Player 1",
                        color = Color.White,
                    )
                    OutlinedTextField(
                        value = player1,
                        onValueChange = {player1 = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp,top = 10.dp, bottom = 10.dp),
                        shape = RoundedCornerShape(30),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.White,
                            focusedBorderColor = Color(0xFF87CEEB),
                            focusedLabelColor = Color.Gray,
                            containerColor = colorResource(id = R.color.maastricht_Blue)
                        )

                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Player 2",
                        color = Color.White,
                    )
                    OutlinedTextField(
                        value = player2,
                        onValueChange = {player2 = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp,top = 10.dp, bottom = 10.dp),
                        shape = RoundedCornerShape(30),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.White,
                            focusedBorderColor = Color(0xFF87CEEB),
                            focusedLabelColor = Color.Gray,
                            containerColor = colorResource(id = R.color.maastricht_Blue)
                        )
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Round",
                        color = Color.White,
                    )
                    OutlinedTextField(
                        value = round,
                        onValueChange = {round = it},
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(start = 20.dp, end = 20.dp,top = 10.dp, bottom = 10.dp),
                        shape = RoundedCornerShape(30),
                        colors = TextFieldDefaults.outlinedTextFieldColors(
                            textColor = Color.White,
                            focusedBorderColor = Color(0xFF87CEEB),
                            focusedLabelColor = Color.Gray,
                            containerColor = colorResource(id = R.color.maastricht_Blue)
                        )
                    )

                    Spacer(modifier = Modifier.height(35.dp))
                    Button(onClick = { navController.navigate("WINNERSELECTION") }) {
                        Text(
                            text = "NEXT"
                        )
                    }
                }
            }
        }
    }
}