package com.example.sportsunity

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.data.DataSourceForWinnerList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootBall(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "SPORTSLISTFORORGANAIZER", header = viewModel.topBar )
        },
        content = {innerpadding->
            myContentFootBall(navController,viewModel,innerpadding)
        }
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBarDesignWithBack(navController: NavController, navigation: String, header: String){
    Column {
        TopAppBar(
            title = {
                Text(
                    text = header,
                    color = Color.White
                )
            },
            navigationIcon = {
                IconButton(onClick = {
                    navController.navigate(navigation)
                }) {
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

}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentFootBall(navController: NavController, viewModel: SharedViewModel, innerpadding: PaddingValues) {
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
            Spacer(modifier = Modifier.height(60.dp))

            val teamName = viewModel.teamName
            var text by rememberSaveable { mutableStateOf("${viewModel.teamName}") }

                Box(modifier = Modifier) {
                    Image(
                        painter = painterResource(id = R.drawable.rectangle_60),
                        contentDescription = null,
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(20.dp)
                    )
                    val t = text
                    Text(
                        text = t,
                        color = Color.White,
                        fontSize = 20.sp,
                        modifier = Modifier
                            .fillMaxWidth()
                            .align(Alignment.Center),
                        textAlign = TextAlign.Center
                    )
                }

//            OutlinedTextField(
//                modifier = Modifier// Add border to TextField
//                    .fillMaxWidth(.9f)
//                    .padding(5.dp),
////            .height(50.dp),
//                value = text,
//                onValueChange = { text = it },
//                enabled = false,
//                keyboardOptions = KeyboardOptions(
//                    keyboardType = KeyboardType.Text,
//                    imeAction = ImeAction.Next
//                ),
//                shape = RoundedCornerShape(30),
//                colors = TextFieldDefaults.outlinedTextFieldColors(
//                    textColor = Color.White,
//                    focusedBorderColor = Color(0xFF87CEEB),
//                    focusedLabelColor = Color.Gray,
//                    cursorColor = Color.White,
//                    containerColor = Color.Black
//
//                )
//            )
            val player_no = listOf("1")//, "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")
            var playerList = listOf<String>("")
            var player1 by rememberSaveable {
                mutableStateOf("")
            }
            var player2 by rememberSaveable {
                mutableStateOf("")
            }
            var player3 by rememberSaveable {
                mutableStateOf("")
            }
            var player4 by rememberSaveable {
                mutableStateOf("")
            }
            var player5 by rememberSaveable {
                mutableStateOf("")
            }
            var player6 by rememberSaveable {
                mutableStateOf("")
            }
            var player7 by rememberSaveable {
                mutableStateOf("")
            }
            var player8 by rememberSaveable {
                mutableStateOf("")
            }
            var player9 by rememberSaveable {
                mutableStateOf("")
            }
            var player10 by rememberSaveable {
                mutableStateOf("")
            }
            var player11 by rememberSaveable {
                mutableStateOf("")
            }
            LazyColumn(modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxHeight(.8f)
            ) {
                items(player_no) { player_no ->
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player1,
                        onValueChange = { player1 = it },
                        label = {
                            Text(text = "Player 1")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player2,
                        onValueChange = { player2 = it },
                        label = {
                            Text(text = "Player 2")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player3,
                        onValueChange = { player3 = it },
                        label = {
                            Text(text = "Player 3")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player4,
                        onValueChange = { player4 = it },
                        label = {
                            Text(text = "Player 4")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player5,
                        onValueChange = { player5 = it },
                        label = {
                            Text(text = "Player 5")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player6,
                        onValueChange = { player6 = it },
                        label = {
                            Text(text = "Player 6")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player7,
                        onValueChange = { player7 = it },
                        label = {
                            Text(text = "Player 7")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player8,
                        onValueChange = { player8 = it },
                        label = {
                            Text(text = "Player 8")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player9,
                        onValueChange = { player9 = it },
                        label = {
                            Text(text = "Player 9")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player10,
                        onValueChange = { player10 = it },
                        label = {
                            Text(text = "Player 10")

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

                        )
                    )
                    OutlinedTextField(
                        modifier = Modifier// Add border to TextField
                            .fillMaxWidth()
                            .padding(5.dp),
//            .height(50.dp),
                        value = player11,
                        onValueChange = { player11 = it },
                        label = {
                            Text(text = "Player 11")

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

                        )
                    )
                }
            }
            playerList = listOf(player1,player2,player3,player4,player5,player6,player7,player8,player9,player10,player11)
            Button(onClick = {
                viewModel.recentTournament.name?.let { viewModel.teamsUpdate(tournamentName = it, playerList = playerList, teamName = teamName) }

                navController.navigate("CREATETOURNAMENTCHESS")
            }) {
                Text(text = "ADD TEAM")
            }



        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextFieldFootBall(
    label: String,
    keyboardType: KeyboardType,
    imeaction: ImeAction,
    modifier: Modifier = Modifier
):String {
    var text by rememberSaveable { mutableStateOf("") }
    OutlinedTextField(
        modifier = Modifier// Add border to TextField
            .fillMaxWidth()
            .padding(5.dp),
//            .height(50.dp),
        value = text,
        onValueChange = { text = it },
        label = {
            Text(text = label)

        },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType,
            imeAction = imeaction
        ),
        shape = RoundedCornerShape(30),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            textColor = Color.White,
            focusedBorderColor = Color(0xFF87CEEB),
            focusedLabelColor = Color.Gray,
            cursorColor = Color.White,
            containerColor = Color.Black

        )
    )
    return text
}