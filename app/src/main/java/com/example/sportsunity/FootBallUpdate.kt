package com.example.sportsunity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.LocalTextStyle
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.data.DataSourceIndividualTeam
import com.example.sportsunity.data.DataSourceTeamData
import com.example.sportsunity.model.IndividualTeam
import com.example.sportsunity.model.PlayerId
import com.example.sportsunity.model.TeamData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootBallUpdate(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "WINNERSELECTION", header = viewModel.topBar )
        },
        content = {innerpadding->
            myContentFootBallUpdate(navController,viewModel,innerpadding)
        }
    )
}
@Composable
fun myContentFootBallUpdate(navController: NavController,viewModel: SharedViewModel,innerpadding: PaddingValues){
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.image_1),
            contentDescription = "Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
    ListForFootBallUpdate(navController = navController,viewModel = viewModel,teamdata = DataSourceTeamData().loadTeamData())
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListForFootBallUpdate(navController: NavController,viewModel: SharedViewModel,teamdata: List<TeamData>,modifier: Modifier = Modifier){
    val list = listOf<String>("1","2","3","4","5","6","7","8","9","10","11",)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        var totalGoalsTeam1: Int = 0
        var totalGoalsTeam2: Int = 0
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            for(team in viewModel.allTeams){
                if(team.name==viewModel.team1&&team.tournamentName==viewModel.recentTournament.name){
                    viewModel.team1Details=team
                    break
                }
            }
            for(team in viewModel.allTeams){
                if(team.name==viewModel.team2&&team.tournamentName==viewModel.recentTournament.name){
                    viewModel.team2Details=team
                    break
                }
            }
            Spacer(modifier = Modifier.height(30.dp))


            var playerList = emptyList<String>()
            for(s in viewModel.team1Details.playerList!!){
                playerList+=s
            }
            var goal1 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist1 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal2 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist2 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal3 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist3 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal4 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist4 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal5 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist5 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal6 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist6 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal7 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist7 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal8 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist8 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal9 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist9 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal10 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist10 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal11 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist11 by rememberSaveable {
                mutableStateOf("0")
            }
            val dump = listOf("1")
            Row {
                Card(
                    modifier = Modifier.padding(
                        top = 5.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 5.dp
                    ),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = viewModel.team1,
                            color = Color.White
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(
                            top = 5.dp,
                            start = 30.dp,
                            end = 30.dp,
                            bottom = 5.dp
                        )
                        .clickable {
                            Log.d("special1","${viewModel.team2PlayerId}")
                            viewModel.PlayerIdUpdate(team = "team1")
                            totalGoalsTeam1 = goal1.toInt()+
                                    goal2.toInt()+
                                    goal3.toInt()+
                                    goal4.toInt()+
                                    goal5.toInt()+
                                    goal6.toInt()+
                                    goal7.toInt()+
                                    goal8.toInt()+
                                    goal9.toInt()+
                                    goal10.toInt()+
                                    goal11.toInt()
                        },
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = "Update",
                            color = Color.White
                        )
                    }
                }
            }
            LazyColumn(modifier = modifier.padding(top = 20.dp)) {
                items(dump) { teamdata ->

                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[0],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal1,
                                    onValueChange = { goal1 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist1,
                                    onValueChange = { assist1 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }

                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[1],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal2,
                                    onValueChange = { goal2 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist2,
                                    onValueChange = { assist2 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }


                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[2],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal3,
                                    onValueChange = { goal3 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist3,
                                    onValueChange = { assist3 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }

                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[3],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal4,
                                    onValueChange = { goal4 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist4,
                                    onValueChange = { assist4 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[4],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal5,
                                    onValueChange = { goal5 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist5,
                                    onValueChange = { assist5 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[5],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal6,
                                    onValueChange = { goal6 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist6,
                                    onValueChange = { assist6 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[6],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal7,
                                    onValueChange = { goal7 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist7,
                                    onValueChange = { assist7 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[7],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal8,
                                    onValueChange = { goal8 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist8,
                                    onValueChange = { assist8 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[8],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal9,
                                    onValueChange = { goal9 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist9,
                                    onValueChange = { assist9 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[9],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal10,
                                    onValueChange = { goal10 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist10,
                                    onValueChange = { assist10 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[10],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal11,
                                    onValueChange = { goal11 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist11,
                                    onValueChange = { assist11 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    viewModel.team1PlayerId =
                        listOf(
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[0],
                                goal = goal1,
                                assist = assist1
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[1],
                                goal = goal2,
                                assist = assist2
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[2],
                                goal = goal3,
                                assist = assist3
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[3],
                                goal = goal4,
                                assist = assist4
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[4],
                                goal = goal5,
                                assist = assist5
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[5],
                                goal = goal6,
                                assist = assist6
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[6],
                                goal = goal7,
                                assist = assist7
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[7],
                                goal = goal8,
                                assist = assist8
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[8],
                                goal = goal9,
                                assist = assist9
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[9],
                                goal = goal10,
                                assist = assist10
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[10],
                                goal = goal11,
                                assist = assist11
                            )
                        )
//                    FootBallUpdateCard(
//                        navController = navController,
//                        teamdata = teamdata,
//                        modifier = Modifier
//                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            Spacer(modifier = Modifier.height(30.dp))


            var playerList = emptyList<String>()
            for(s in viewModel.team2Details.playerList!!){
                playerList+=s
            }
            var goal1 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist1 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal2 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist2 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal3 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist3 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal4 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist4 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal5 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist5 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal6 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist6 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal7 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist7 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal8 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist8 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal9 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist9 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal10 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist10 by rememberSaveable {
                mutableStateOf("0")
            }
            var goal11 by rememberSaveable {
                mutableStateOf("0")
            }
            var assist11 by rememberSaveable {
                mutableStateOf("0")
            }
            val dump = listOf("1")
            Row {
                Card(
                    modifier = Modifier.padding(
                        top = 5.dp,
                        start = 30.dp,
                        end = 30.dp,
                        bottom = 5.dp
                    ),
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = viewModel.team2,
                            color = Color.White
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(top = 5.dp, start = 30.dp, end = 30.dp, bottom = 5.dp)
                        .clickable {
                            Log.d("special1","${viewModel.team2PlayerId}")
                            viewModel.PlayerIdUpdate(team = "team2")
                            totalGoalsTeam2 = goal1.toInt()+
                                    goal2.toInt()+
                                    goal3.toInt()+
                                    goal4.toInt()+
                                    goal5.toInt()+
                                    goal6.toInt()+
                                    goal7.toInt()+
                                    goal8.toInt()+
                                    goal9.toInt()+
                                    goal10.toInt()+
                                    goal11.toInt()
                            var winnerTeamName = ""
                            var losserTeamName = ""
                            var winnerTeamGoal = ""
                            var losserTeamGoal = ""
                            if(totalGoalsTeam1>totalGoalsTeam2){
                                winnerTeamName=viewModel.team1
                                losserTeamName = viewModel.team2
                                winnerTeamGoal = totalGoalsTeam1.toString()
                                losserTeamGoal = totalGoalsTeam2.toString()
                            }
                            else {
                                winnerTeamName = viewModel.team2
                                losserTeamName = viewModel.team1
                                winnerTeamGoal = totalGoalsTeam2.toString()
                                losserTeamGoal = totalGoalsTeam1.toString()
                            }
                            viewModel.recentTournament.name?.let {
                                viewModel.winnerList2Update(
                                    tournamentName = it,
                                    winnerTeamName = winnerTeamName,
                                    losserTeamName =  losserTeamName,
                                    losserTeamGoal = losserTeamGoal,
                                    winnerTeamGoal = winnerTeamGoal
                                )
                            }
                            navController.navigate("NEWMATCHCREATION")
                        },
                    colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                ) {
                    Row(
                        modifier = Modifier.padding(20.dp)
                    ) {
                        Text(
                            text = "Update",
                            color = Color.White
                        )
                    }
                }
            }
            LazyColumn(modifier = modifier.padding(top = 20.dp)) {
                items(dump) { teamdata ->

                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[0],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal1,
                                    onValueChange = { goal1 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist1,
                                    onValueChange = { assist1 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[1],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal2,
                                    onValueChange = { goal2 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist2,
                                    onValueChange = { assist2 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[2],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal3,
                                    onValueChange = { goal3 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist3,
                                    onValueChange = { assist3 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[3],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal4,
                                    onValueChange = { goal4 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist4,
                                    onValueChange = { assist4 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[4],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal5,
                                    onValueChange = { goal5 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist5,
                                    onValueChange = { assist5 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[5],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal6,
                                    onValueChange = { goal6 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist6,
                                    onValueChange = { assist6 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[6],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal7,
                                    onValueChange = { goal7 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist7,
                                    onValueChange = { assist7 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[7],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal8,
                                    onValueChange = { goal8 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist8,
                                    onValueChange = { assist8 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[8],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal9,
                                    onValueChange = { goal9 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist9,
                                    onValueChange = { assist9 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[9],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal10,
                                    onValueChange = { goal10 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist10,
                                    onValueChange = { assist10 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }

                    Card(
                        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
                        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
                    ) {
                        Row(
                            modifier = Modifier.padding(20.dp)
                        ){

                            Column(
                                modifier = Modifier.weight(.6f)
                            ) {

                                Text(
                                    text = "Player:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                Text(
                                    text = playerList[10],
                                    color = Color.White,
                                    fontSize = 17.sp,
                                )
                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Goal:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = goal11,
                                    onValueChange = { goal11 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )

                            }
                            Column(
                                horizontalAlignment = Alignment.CenterHorizontally,
                                modifier = Modifier.weight(.2f)
                            ) {
                                Text(
                                    text = "Assist:",
                                    fontSize = 13.sp,
                                    color = Color.White
                                )
                                OutlinedTextField(
                                    modifier = Modifier// Add border to TextField
                                        .fillMaxWidth()
                                        .padding(5.dp),
                                    value = assist11,
                                    onValueChange = { assist11 = it },
                                    label = {
                                        Text(text = "")

                                    },
                                    keyboardOptions = KeyboardOptions(
                                        keyboardType = KeyboardType.Number,
                                        imeAction = ImeAction.Next
                                    ),
                                    shape = RoundedCornerShape(30),
                                    colors = TextFieldDefaults.outlinedTextFieldColors(
                                        textColor = Color.White,
                                        focusedBorderColor = Color(0xFF87CEEB),
                                        cursorColor = Color.White,
                                        containerColor = colorResource(id = R.color.background_card)

                                    )
                                )
                            }
                        }
                    }
                    viewModel.team2PlayerId =
                        listOf(
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[0],
                                goal = goal1,
                                assist = assist1
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[1],
                                goal = goal2,
                                assist = assist2
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[2],
                                goal = goal3,
                                assist = assist3
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[3],
                                goal = goal4,
                                assist = assist4
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[4],
                                goal = goal5,
                                assist = assist5
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[5],
                                goal = goal6,
                                assist = assist6
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[6],
                                goal = goal7,
                                assist = assist7
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[7],
                                goal = goal8,
                                assist = assist8
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[8],
                                goal = goal9,
                                assist = assist9
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[9],
                                goal = goal10,
                                assist = assist10
                            ),
                            PlayerId(
                                tournamentName = viewModel.recentTournament.name,
                                playerName = playerList[10],
                                goal = goal11,
                                assist = assist11
                            )
                        )
//                    FootBallUpdateCard(
//                        navController = navController,
//                        teamdata = teamdata,
//                        modifier = Modifier
//                    )
                }
            }
        }
//        Button(onClick = { /*TODO*/ }) {
//            Text(
//                text = "UPDATE",
//                textAlign = TextAlign.Center)
//        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootBallUpdateCard(navController: NavController,teamdata:TeamData, modifier: Modifier = Modifier){
    var text1 by rememberSaveable {
        mutableStateOf("")
    }
    var text2 by rememberSaveable {
        mutableStateOf("")
    }
    Card(
        modifier = Modifier.padding(top=5.dp, start = 30.dp,end = 30.dp, bottom = 5.dp),
        colors = CardDefaults.cardColors(containerColor = colorResource(id = R.color.maastricht_Blue))
    ) {
        Row(
            modifier = Modifier.padding(20.dp)
        ){

            Column(
                modifier = Modifier.weight(.6f)
            ) {

                Text(
                    text = "Player:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                Text(
                    text = stringResource(teamdata.stringResourceId),
                    color = Color.White,
                    fontSize = 17.sp,
                )
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "Goal:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier// Add border to TextField
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = text1,
                    onValueChange = { text1 = it },
                    label = {
                        Text(text = "")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    shape = RoundedCornerShape(30),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.White,
                        focusedBorderColor = Color(0xFF87CEEB),
                        cursorColor = Color.White,
                        containerColor = colorResource(id = R.color.background_card)

                    )
                )
//                OutlinedTextField(
//                    value = text1,
//                    onValueChange = {text1 = it},
//                    modifier = Modifier
//                        .fillMaxWidth(.8f)
//                        .height(30.dp),
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Number
//                    ),
//                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.White), // Resize text field text
//                    colors = TextFieldDefaults.textFieldColors( // Customize text field colors
//                        textColor = Color.White,
//                        focusedLabelColor = Color.Transparent,
//                        cursorColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent, // Set focused indicator color to transparent
//                        unfocusedIndicatorColor = Color.Transparent,
//                        containerColor = colorResource(id = R.color.background_card)
//                    )
//                )

            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.weight(.2f)
            ) {
                Text(
                    text = "Assist:",
                    fontSize = 13.sp,
                    color = Color.White
                )
                OutlinedTextField(
                    modifier = Modifier// Add border to TextField
                        .fillMaxWidth()
                        .padding(5.dp),
                    value = text2,
                    onValueChange = { text2 = it },
                    label = {
                        Text(text = "")

                    },
                    keyboardOptions = KeyboardOptions(
                        keyboardType = KeyboardType.Number,
                        imeAction = ImeAction.Next
                    ),
                    shape = RoundedCornerShape(30),
                    colors = TextFieldDefaults.outlinedTextFieldColors(
                        textColor = Color.Black,
                        focusedBorderColor = Color(0xFF87CEEB),
                        cursorColor = Color.White,
                        containerColor = colorResource(id = R.color.background_card)

                    )
                )
//                OutlinedTextField(
//                    value = text2,
//                    onValueChange = {text2 = it},
//                    modifier = Modifier
//                        .fillMaxWidth(.8f)
//                        .height(30.dp),
//                    keyboardOptions = KeyboardOptions(
//                        keyboardType = KeyboardType.Text
//                    ),
//                    textStyle = LocalTextStyle.current.copy(fontSize = 16.sp, color = Color.White), // Resize text field text
//                    colors = TextFieldDefaults.textFieldColors( // Customize text field colors
//                        textColor = Color.White,
//                        focusedLabelColor = Color.Transparent,
//                        cursorColor = Color.White,
//                        focusedIndicatorColor = Color.Transparent, // Set focused indicator color to transparent
//                        unfocusedIndicatorColor = Color.Transparent, // Set unfocused indicator color to transparent
//                        containerColor = colorResource(id = R.color.background_card)
//                    )
//                )
            }
        }
    }
}
