package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.sportsunity.SharedViewModel.SharedViewModel
import com.example.sportsunity.data.DataSourceForWinnerList

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun FootBall(navController: NavController,viewModel: SharedViewModel,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
            TopBarDesignWithBack(navController = navController, navigation = "SPORTSLISTFORORGANAIZER", header = "Football" )
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


            var text by rememberSaveable { mutableStateOf("") }
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth(.9f)
                    .padding(5.dp),
//            .height(50.dp),
                value = text,
                onValueChange = { text = it },
                label = {
                    Text(text = "Team Name")

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
            val player_no = listOf("1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11")
            LazyColumn(modifier = Modifier.padding(top = 20.dp)) {
                items(player_no) { player_no ->
                    CreateTextFieldFootBall(
                        label = "Player $player_no",
                        keyboardType = KeyboardType.Text,
                        imeaction = ImeAction.Next
                    )
                }
            }
            Button(onClick = { navController.navigate("HOME") }) {
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
) {
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
}