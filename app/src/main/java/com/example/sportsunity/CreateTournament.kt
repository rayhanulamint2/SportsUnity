package com.example.sportsunity

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.ExitToApp
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTournament(navController: NavController, modifier: Modifier=Modifier){
    Scaffold(
        topBar = { TopBarCreateTournament(navController) },
        content = {innerpadding->
            myContentCreateTournament(navController,innerpadding)
        }
    )
}
@Composable
fun TopBarCreateTournament(navController: NavController,modifier: Modifier = Modifier){
    Column {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .background(Color.Black)
                .fillMaxWidth()
        ) {
            Text(
                text = stringResource(id = R.string.create_tournament),
                color = Color.White,
                textAlign = TextAlign.Center,
                style = MaterialTheme.typography.headlineLarge,
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
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun myContentCreateTournament(navController: NavController, innerpadding: PaddingValues){
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
            var sports by rememberSaveable {
                mutableStateOf("")
            }
            var volunteer by rememberSaveable {
                mutableStateOf("")
            }
            Image(
                painter = painterResource(id = R.drawable.image_5),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxWidth()
            )

            CreateTextFieldTournament(
                label = "Set Tournament Name",
                keyboardType = KeyboardType.Text,
                imeaction = ImeAction.Next
            )
//            CreateTextFieldTournament(
//                label = "Sports Type",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = sports,
                onValueChange = { sports = it },
                label = {
                    Text(text = "Sports Type")

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
                            onClick = { /* Handle trailing icon click here */ }
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

//            CreateTextFieldTournament(
//                label = "Add Sports Type",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
//            CreateTextFieldTournament(
//                label = "Volunteers",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
            OutlinedTextField(
                modifier = Modifier// Add border to TextField
                    .fillMaxWidth()
                    .padding(5.dp),
//            .height(50.dp),
                value = volunteer,
                onValueChange = { volunteer = it },
                label = {
                    Text(text = "Volunteer")

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
                            onClick = { /* Handle trailing icon click here */ }
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
//            CreateTextFieldTournament(
//                label = "Add Volunteers",
//                keyboardType = KeyboardType.Text,
//                imeaction = ImeAction.Next
//            )
            CreateTextFieldTournament(
                label = "Start Time",
                keyboardType = KeyboardType.Number,
                imeaction = ImeAction.Next
            )
            CreateTextFieldTournament(
                label = "End Time",
                keyboardType = KeyboardType.Number,
                imeaction = ImeAction.Next
            )
            Spacer(modifier = Modifier.height(40.dp))
            Button(onClick = { navController.navigate("MYTOURNAMENTS") }) {
                Text(
                    text = "CREATE"
                )
            }

        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextFieldTournament(
    label: String,
    keyboardType: KeyboardType,
    imeaction:ImeAction,
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