package com.example.sportsunity

import android.util.Log
import android.widget.Space
import androidx.compose.foundation.Image
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTournamentChess(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
//            TopBarCreateTournament(navController)
                 TopBarDesignWithBack(navController = navController, navigation = "SPORTSLISTFORORGANAIZER", header = "${viewModel.sport}")
                 },
        content = {innerpadding->
            var tanvir by remember{
                mutableStateOf(1)
            }
            if(tanvir==2) {
                myContentCreateTournamentChess(navController, viewModel = viewModel, innerpadding)
            }
            else{
                loading()
                LaunchedEffect(Unit){
                    viewModel.findAllTeams()
                    Log.d("allTeams", "$viewModel.allTeams")
                    tanvir =2
                }
            }
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentCreateTournamentChess(navController: NavController,viewModel: SharedViewModel, innerpadding: PaddingValues){

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
            var playerList= listOf("Khalid Bin Selim", "Abhishek Das", "Rayhanul Amin Tanvir", "Gazi Mujtaba")
            var tanvir by rememberSaveable {
                mutableStateOf(1)
            }
            for(sports in viewModel.allSports){
                if(sports.sportName==viewModel.sport&&sports.tournamentName==viewModel.recentTournament.name){
                    playerList = sports.playerList!!
                    viewModel.recentSport = sports
                    Log.d("tasnuva","${viewModel.recentSport}")
                    break
                }
            }
            var text by rememberSaveable {
                mutableStateOf("")
            }
            Spacer(modifier = Modifier.height(50.dp))
            Image(
                painter = painterResource(id = R.drawable.image_6),
                contentDescription = "Chess",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(5.dp)
            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = text,
                onValueChange = { text = it },
                label = {
                    val ttt = if(viewModel.sport=="FOOTBALL"){
                        "Add Team"
                    }
                    else "Add Player"
                    Text(text = ttt)

                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Text,
                    imeAction = ImeAction.Next
                ),
                shape = RoundedCornerShape(30),
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    textColor = Color.White,
                    focusedBorderColor = Color(0xFF87CEEB),
                    focusedLabelColor = Color.Gray,
                    cursorColor = Color.White,
                    containerColor = Color.Black

                ),
                trailingIcon = {
                    Box(
                        modifier = Modifier.padding(end = 16.dp)
                    ) {
                        IconButton(
                            onClick = {
                                if(viewModel.sport=="FOOTBALL"){
                                    viewModel.teamName = text
                                    navController.navigate("FOOTBALL")
                                }
                                else{
                                    playerList+=text
                                    Log.d("playerList","$playerList")
                                    viewModel.updatePlayerList(playerList)
                                    for(sports in viewModel.allSports){
                                        if(sports.sportName==viewModel.sport&&sports.tournamentName==viewModel.recentTournament.name){
                                            sports.playerList = playerList
                                        }
                                    }
                                    text = ""
                                    tanvir = 1-tanvir
                                }
                            }
                        ) {
                            Icon(
                                imageVector = Icons.Default.Add,
                                contentDescription = "Add",
                                tint = Color.Gray // Customize the color of the icon
                            )
                        }
                    }
                }
            )
            Card(
                modifier = Modifier.padding(20.dp),
                colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.background_card))
            ) {
                Box(modifier = Modifier){
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_60),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    val t = if(viewModel.sport=="FOOTBALL") {
                        "Team List"
                    }
                    else {
                        "Player List"
                    }
                    Text(
                        text = t
                        ,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }
                var playerListForFootball:List<String?> = emptyList()
                for(team in viewModel.allTeams){
                    if(team.tournamentName==viewModel.recentTournament.name){
                        playerListForFootball+=team.name
                    }
                }


                LazyColumn(modifier = Modifier.padding(bottom = 20.dp)) {
                    if(viewModel.sport=="FOOTBALL"){
                        items(playerListForFootball) { player ->
                            if (player != null) {
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
                    else{
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
}