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
import androidx.compose.foundation.layout.width
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
fun PersonalInfo(navController: NavController,modifier: Modifier = Modifier){
    Scaffold(
        topBar = {
//            TopBarPersonalInfo(navController)
            Column {
                TopAppBar(
                    title = {
                        Text(
                            text = "Personal Information",
                            color = Color.White
                        )
                    },
                    navigationIcon = {
                        IconButton(onClick = {
                            navController.navigate("MYPROFILE")
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
            myContentPersonalInfo(navController,innerpadding)
        }
    )
}

//@Composable
//fun TopBarPersonalInfo(navController: NavController){
//    Row(
//        horizontalArrangement = Arrangement.Center,
//        modifier = Modifier
//            .background(Color.Black)
//            .fillMaxWidth()
//    ){
//        Text(
//            text ="Personal Information",
//            color = Color.White,
//            textAlign = TextAlign.Center,
//            style = MaterialTheme.typography.headlineLarge,
//        )
//    }
//}

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
                mutableStateOf("")
            }
            var university by rememberSaveable {
                mutableStateOf("")
            }
            var email by rememberSaveable {
                mutableStateOf("")
            }
            var contact by rememberSaveable {
                mutableStateOf("")
            }
            var password by rememberSaveable {
                mutableStateOf("")
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
                        contentDescription = "user's photo",
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 15.dp)
                            .height(100.dp)
                            .width(100.dp),
                        alignment = Alignment.TopCenter
                    )
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ){
                        Text(
                            text = "Name",
                            color = Color.White,
//                            modifier = Modifier
//                                .fillMaxWidth(.90f)
//                                .padding(bottom = 0.dp),
                            textAlign = TextAlign.Start
                        )
                        name = CreateTextFieldPersonalInfo(
                            maintext = name,
                            label = "",
                            keyboardType = KeyboardType.Text,
                            imeaction = ImeAction.Next
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ){
                        Text(
                            text = "University Name",
                            color = Color.White,
//                            modifier = Modifier.fillMaxWidth(.90f),
                            textAlign = TextAlign.Start
                        )
                        university = CreateTextFieldPersonalInfo(
                            maintext = university,
                            label = "",
                            keyboardType = KeyboardType.Text,
                            imeaction = ImeAction.Next
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ) {
                        Text(
                            text = "Email",
                            color = Color.White,
//                            modifier = Modifier.fillMaxWidth(.90f),
                            textAlign = TextAlign.Start
                        )
                        email = CreateTextFieldPersonalInfo(
                            maintext = email,
                            label = "",
                            keyboardType = KeyboardType.Email,
                            imeaction = ImeAction.Next
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ) {
                        Text(
                            text = "Contact Number",
                            color = Color.White,
//                            modifier = Modifier.fillMaxWidth(.75f),
                            textAlign = TextAlign.Start
                        )
                        contact = CreateTextFieldPersonalInfo(
                            maintext = contact,
                            label = "",
                            keyboardType = KeyboardType.Number,
                            imeaction = ImeAction.Next
                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Column(
                        modifier = Modifier.fillMaxWidth(.8f)
                    ) {
                        Text(
                            text = "Password",
                            color = Color.White,
//                            modifier = Modifier.fillMaxWidth(.75f),
                            textAlign = TextAlign.Start
                        )
                        password = CreateTextFieldPersonalInfo(
                            maintext = password,
                            label = "",
                            keyboardType = KeyboardType.Password,
                            imeaction = ImeAction.Done
                        )
                    }

                }
//            }
            Spacer(modifier = Modifier.height(25.dp))
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
            .fillMaxWidth()
//            .padding(5.dp)
        ,
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
