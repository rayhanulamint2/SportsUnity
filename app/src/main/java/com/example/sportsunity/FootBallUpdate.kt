package com.example.sportsunity

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
import com.example.sportsunity.model.TeamData

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootBallUpdate(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "WINNERSELECTION", header = viewModel.getTopBar() )
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
    ListForFootBallUpdate(navController = navController,teamdata = DataSourceTeamData().loadTeamData())
}

@Composable
fun ListForFootBallUpdate(navController: NavController,teamdata: List<TeamData>,modifier: Modifier = Modifier){
    val list = listOf<String>("1","2","3","4","5","6","7","8","9","10","11",)
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Spacer(modifier = Modifier.height(30.dp))
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

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
                            text = "Team 1",
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
                        .clickable { },
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
                items(teamdata) { teamdata ->
                    FootBallUpdateCard(
                        navController = navController,
                        teamdata = teamdata,
                        modifier = Modifier
                    )
                }
            }
        }
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.weight(.5f)
        ) {
            Spacer(modifier = Modifier.height(30.dp))

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
                            text = "Team 2",
                            color = Color.White
                        )
                    }
                }
                Card(
                    modifier = Modifier
                        .padding(top = 5.dp, start = 30.dp, end = 30.dp, bottom = 5.dp)
                        .clickable { },
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
                items(teamdata) { teamdata->
                    FootBallUpdateCard(
                        navController = navController,
                        teamdata = teamdata,
                        modifier = Modifier
                    )
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
