package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTournamentChess(navController: NavController,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
//            TopBarCreateTournament(navController)
                 },
        content = {innerpadding->
            myContentCreateTournamentChess(navController,innerpadding)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentCreateTournamentChess(navController: NavController, innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
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

            Image(
                painter = painterResource(id = R.drawable.image_6),
                contentDescription = "Chess",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            Text(
                text = "CHESS",
                fontSize = 36.sp,
                color = Color.White
            )
            var text by rememberSaveable {
                mutableStateOf("")
            }
            OutlinedTextField(
                value = text,
                onValueChange = {text = it},
                label = {
                    Text(text = "ADD MEMBER")
                }
            )
            Column (
                horizontalAlignment = Alignment.CenterHorizontally
            ){
                OutlinedTextField(
                    value = text,
                    onValueChange = {text=it},
                    label = {
                        Text(text = "PLAYER LIST")
                    },
                    enabled = false
                )
                Button(onClick = { /*TODO*/ }) {
                    Text(text = "SEE MORE")
                }
            }
            Button(onClick = { }) {
                Text(text = " CREATE NEW" + "\nTOURNAMENT",
                    textAlign = TextAlign.Center
                )
            }
        }
    }
}