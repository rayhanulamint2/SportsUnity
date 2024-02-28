package com.example.sportsunity

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
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
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PersonalInfo(navController: NavController,modifier: Modifier = Modifier){
    Scaffold(
        topBar = { TopBarPersonalInfo(navController) },
        content = {innerpadding->
            myContentPersonalInfo(navController,innerpadding)
        }
    )
}

@Composable
fun TopBarPersonalInfo(navController: NavController){
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = Modifier
            .background(Color.Black)
            .fillMaxWidth()
    ){
        Text(
            text ="Personal Information",
            color = Color.White,
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.headlineLarge,
        )
    }
}

@Composable
fun myContentPersonalInfo(navController: NavController, innerpadding: PaddingValues){
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
            var name by rememberSaveable {
                mutableStateOf("Tanvir")
            }
            var university by rememberSaveable {
                mutableStateOf("university")
            }
            var email by rememberSaveable {
                mutableStateOf("email")
            }
            var contact by rememberSaveable {
                mutableStateOf("contact")
            }
            var password by rememberSaveable {
                mutableStateOf("password")
            }
//            Box(){
//                Image(
//                    painter = painterResource(id = R.drawable.rectangle_25),
//                    contentDescription = null,
//                    contentScale = ContentScale.Crop,
//                    modifier = Modifier
//                        .fillMaxSize(.98f)
//                        .padding(start = 10.dp, top = 30.dp, end = 10.dp, bottom = 20.dp)
//
//                )
                Column (
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.padding(top = 60.dp)
                ){
                    Image(
                        painter = painterResource(id = R.drawable.ellipse_1),
                        contentDescription = "user photo",
                        modifier = Modifier.fillMaxWidth()
                    )
                    Text(
                        text = "Name",
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    name = CreateTextFieldPersonalInfo(
                        maintext = name,
                        label = "",
                        keyboardType = KeyboardType.Text,
                        imeaction = ImeAction.Next
                    )
                    Text(
                        text = "University Name",
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    university = CreateTextFieldPersonalInfo(
                        maintext = university,
                        label = "",
                        keyboardType = KeyboardType.Text,
                        imeaction = ImeAction.Next
                    )
                    Text(
                        text = "Email",
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    email = CreateTextFieldPersonalInfo(
                        maintext = email,
                        label = "",
                        keyboardType = KeyboardType.Email,
                        imeaction = ImeAction.Next
                    )
                    Text(
                        text = "Contact Number",
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    contact = CreateTextFieldPersonalInfo(
                        maintext = contact,
                        label = "",
                        keyboardType = KeyboardType.Number,
                        imeaction = ImeAction.Next
                    )
                    Text(
                        text = "Password",
                        color = Color.White,
                        textAlign = TextAlign.Start
                    )
                    password = CreateTextFieldPersonalInfo(
                        maintext = password,
                        label = "",
                        keyboardType = KeyboardType.Password,
                        imeaction = ImeAction.Done
                    )

                }
//            }
            Spacer(modifier = Modifier.height(30.dp))
            Button(onClick = { navController.navigate("CONFIRMATION") }) {
                Text(text = "UPDATE")
            }
        }
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateTextFieldPersonalInfo(
    maintext:String,
    label: String,
    keyboardType: KeyboardType,
    imeaction: ImeAction,
    modifier: Modifier = Modifier
): String {
    var text by rememberSaveable { mutableStateOf(maintext) }
    OutlinedTextField(
        modifier = Modifier// Add border to TextField
            .fillMaxWidth(.8f)
            .padding(5.dp),
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
            textColor = Color.Black,
            focusedBorderColor = Color(0xFF87CEEB),
            focusedLabelColor = Color.Gray,
            cursorColor = Color.Black,
            containerColor = Color.White

        )
    )
    return text
}
